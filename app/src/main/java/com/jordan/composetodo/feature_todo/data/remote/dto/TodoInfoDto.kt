package com.jordan.composetodo.feature_todo.data.remote.dto

import com.jordan.composetodo.feature_todo.data.local.entity.TodoInfoEntity

data class TodoInfoDto(
    val completed: Boolean,
    val id: Int,
    val title: String,
    val userId: Int
) {
    fun toTodoInfoEntity(): TodoInfoEntity{
        return TodoInfoEntity(
            completed = completed,
            id = id,
            title = title,
            userId = userId
        )
    }
}