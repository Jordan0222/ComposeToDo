package com.jordan.composetodo.feature_todo.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.jordan.composetodo.feature_todo.domain.model.TodoInfo

@Entity
data class TodoInfoEntity(
    val completed: Boolean,
    val id: Int,
    val title: String,
    val userId: Int,
    @PrimaryKey val todoId: Int? = null
) {
    fun toTodoInfo(): TodoInfo {
        return TodoInfo(
            completed = completed,
            id = id,
            title = title,
            userId = userId
        )
    }
}