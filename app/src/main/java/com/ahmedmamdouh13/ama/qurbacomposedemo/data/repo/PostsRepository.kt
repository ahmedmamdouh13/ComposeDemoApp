package com.ahmedmamdouh13.ama.qurbacomposedemo.data.repo

import android.content.Context
import com.ahmedmamdouh13.ama.qurbacomposedemo.data.local.LocalDataSource
import com.ahmedmamdouh13.ama.qurbacomposedemo.data.model.Result
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class PostsRepository() {

    suspend fun getAllPosts(context: Context): Flow<Result> {
        return flow {
            try {
                val allPosts = LocalDataSource.getAllPosts(context)
                kotlinx.coroutines.delay(500)
                emit(Result.Success(allPosts) as Result)
            } catch (e: Exception) {
                emit(Result.Error(e))
            }
        }
    }
}

