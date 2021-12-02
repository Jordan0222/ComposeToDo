package com.jordan.composetodo.feature_todo.data.local

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.jordan.composetodo.feature_todo.data.local.TodoDao
import com.jordan.composetodo.feature_todo.data.local.entity.TodoInfoEntity

@Database(
    entities = [TodoInfoEntity::class],
    version = 1
)
abstract class TodoInfoDatabase: RoomDatabase() {
    abstract val dao: TodoDao
}
