package com.ahmedmamdouh13.ama.qurbacomposedemo.data

import android.content.Context
import com.ahmedmamdouh13.ama.qurbacomposedemo.data.local.LocalDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class PostsRepository() {

    suspend fun getAllPosts(context: Context): Flow<Result> {
        return flow {
            try {
                val allPosts = LocalDataSource.getAllPosts(context)
                kotlinx.coroutines.delay(2000)
                emit(Result.Success(allPosts))
            } catch (e: Exception) {
                emit(Result.Error(e))
            }
        }
    }

}