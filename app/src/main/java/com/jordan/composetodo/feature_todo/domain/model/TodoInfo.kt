package com.jordan.composetodo.feature_todo.domain.model

data class TodoInfo(
    val completed: Boolean,
    val id: Int,
    val title: String,
    val userId: Int
)
