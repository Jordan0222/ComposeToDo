package com.jordan.composetodo.feature_todo.data.remote

import com.jordan.composetodo.feature_todo.data.remote.dto.TodoInfoDto
import com.jordan.composetodo.feature_todo.domain.model.TodoInfo
import retrofit2.http.GET
import retrofit2.http.Query

interface TodoApi {

    @GET("/todos")
    suspend fun getTodoInfo(
    ): List<TodoInfoDto>

    companion object {
        const val BASE_URL = "https://jsonplaceholder.typicode.com"
    }
}