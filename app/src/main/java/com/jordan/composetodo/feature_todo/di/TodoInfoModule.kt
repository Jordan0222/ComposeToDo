package com.jordan.composetodo.feature_todo.di

import android.app.Application
import androidx.room.Room
import com.jordan.composetodo.feature_todo.data.local.TodoInfoDatabase
import com.jordan.composetodo.feature_todo.data.remote.TodoApi
import com.jordan.composetodo.feature_todo.data.repository.TodoInfoRepositoryImpl
import com.jordan.composetodo.feature_todo.domain.repository.TodoInfoRepository
import com.jordan.composetodo.feature_todo.domain.todo_case.GetTodoInfo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object TodoInfoModule {

    @Provides
    @Singleton
    fun provideGetTodoInfoCase(repository: TodoInfoRepository): GetTodoInfo {
        return GetTodoInfo(repository)
    }

    @Provides
    @Singleton
    fun provideTodoInfoRepository(
        db: TodoInfoDatabase,
        api: TodoApi
    ): TodoInfoRepository {
        return TodoInfoRepositoryImpl(api, db.dao)
    }

    @Provides
    @Singleton
    fun provideTodoInfoDatabase(app: Application): TodoInfoDatabase {
        return Room.databaseBuilder(
            app, TodoInfoDatabase::class.java, "todo_db"
        ).build()
    }

    @Provides
    @Singleton
    fun provideTodoInfoApi(): TodoApi {
        return Retrofit.Builder()
            .baseUrl(TodoApi.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(TodoApi::class.java)
    }
}