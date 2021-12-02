package com.jordan.composetodo.feature_todo.presentation

import com.jordan.composetodo.feature_todo.domain.model.TodoInfo

data class TodoState (
    val todoInfoItems: List<TodoInfo> = emptyList(),
    val isLoading: Boolean = false
)