package com.jordan.composetodo.feature_todo.data.local

import androidx.room.*
import com.jordan.composetodo.feature_todo.data.local.entity.TodoInfoEntity

@Dao
interface TodoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTodoInfo(infos: List<TodoInfoEntity>)

    @Query("DELETE FROM todoinfoentity WHERE userId IN(:userIds)")
    suspend fun deleteTodoInfo(userIds: List<Int>)

    @Query("SELECT * FROM todoinfoentity")
    suspend fun getTodoInfo(): List<TodoInfoEntity>
}