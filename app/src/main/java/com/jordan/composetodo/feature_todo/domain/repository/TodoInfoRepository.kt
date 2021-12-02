package com.jordan.composetodo.feature_todo.domain.repository

import com.jordan.composetodo.feature_todo.domain.model.TodoInfo
import com.jordan.composetodo.util.Resource
import kotlinx.coroutines.flow.Flow

interface TodoInfoRepository {

    fun getTodoInfo(): Flow<Resource<List<TodoInfo>>>
}