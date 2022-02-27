package com.ahmedmamdouh13.ama.qurbacomposedemo.data.local

import android.content.Context
import com.ahmedmamdouh13.ama.qurbacomposedemo.R
import com.ahmedmamdouh13.ama.qurbacomposedemo.data.model.Posts
import com.google.gson.Gson

object LocalDataSource {
    suspend fun getAllPosts(context: Context): Posts {
        val json = context.resources.openRawResource(R.raw.api).bufferedReader().use { it.readText() }
        return Gson().fromJson(json, Posts::class.java)
    }
}

