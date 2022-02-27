package com.ahmedmamdouh13.ama.qurbacomposedemo.data

import android.content.Context
import com.ahmedmamdouh13.ama.qurbacomposedemo.data.local.LocalDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow

class PostsRepository() {

    suspend fun getAllPosts(context: Context): Flow<Result> {
        return flow {
            val allPosts = LocalDataSource.getAllPosts(context)
            kotlinx.coroutines.delay(500)
            emit(Result.Success(allPosts) as Result)


        }.catch {
            emit(Result.Error(Exception("Something went wrong!")))
        }

    }
}

