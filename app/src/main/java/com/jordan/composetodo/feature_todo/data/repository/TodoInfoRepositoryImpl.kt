package com.jordan.composetodo.feature_todo.data.repository

import com.jordan.composetodo.feature_todo.data.local.TodoDao
import com.jordan.composetodo.feature_todo.data.remote.TodoApi
import com.jordan.composetodo.feature_todo.domain.model.TodoInfo
import com.jordan.composetodo.feature_todo.domain.repository.TodoInfoRepository
import com.jordan.composetodo.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

class TodoInfoRepositoryImpl(
    private val api: TodoApi,
    private val dao: TodoDao
) : TodoInfoRepository{

    override fun getTodoInfo(): Flow<Resource<List<TodoInfo>>> = flow {
        emit(Resource.Loading())

        val todoInfos = dao.getTodoInfo().map { it.toTodoInfo() }
        emit(Resource.Loading(todoInfos))

        try {
            val remoteTodoInfos = api.getTodoInfo()
            dao.deleteTodoInfo(remoteTodoInfos.map { it.userId })
            dao.insertTodoInfo(remoteTodoInfos.map { it.toTodoInfoEntity()})
        } catch (e: HttpException) {
            emit(Resource.Error(
                message = "Oops, somethings went wrong!",
                // 有可能會從 database 拿到資料
                data = todoInfos
            ))
        } catch (e: IOException) {
            emit(Resource.Error(
                message = "Couldn't reach server, check your internet connection.",
                // 有可能會從 database 拿到資料
                data = todoInfos
            ))
        }

        val newTodoInfos = dao.getTodoInfo().map { it.toTodoInfo() }
        emit(Resource.Success(newTodoInfos))
    }
}