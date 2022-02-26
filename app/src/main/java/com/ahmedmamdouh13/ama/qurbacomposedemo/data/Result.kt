package com.ahmedmamdouh13.ama.qurbacomposedemo.data

sealed class Result {
   data class Success<T>(val data: T) : Result()
   data class Error(val e: Exception) : Result()
}
