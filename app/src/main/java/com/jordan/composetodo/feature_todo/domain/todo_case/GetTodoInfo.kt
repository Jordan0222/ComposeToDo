package com.jordan.composetodo.feature_todo.domain.todo_case

import com.jordan.composetodo.feature_todo.domain.model.TodoInfo
import com.jordan.composetodo.feature_todo.domain.repository.TodoInfoRepository
import com.jordan.composetodo.util.Resource
import kotlinx.coroutines.flow.Flow

class GetTodoInfo(
    private val repository: TodoInfoRepository
) {

    operator fun invoke(): Flow<Resource<List<TodoInfo>>> {
        return repository.getTodoInfo()
    }
}