package com.example.booktask.utils

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Call

typealias StringResource = Int

suspend fun <T> Call<T>.result(): Result<T> {
    return withContext(Dispatchers.IO) {
        val response = execute()
        val data = response.body()
        if (response.isSuccessful && data != null) {
            Result.success(data)
        } else {
            val message = response.errorBody()?.string() ?: response.message()
            Result.failure(RuntimeException(message))
        }
    }
}

fun <T> Result<T>.toLiveData(onError: () -> Unit): LiveData<T> {
    val flow = MutableLiveData<T>()
    if (isSuccess) {
        flow.value = getOrNull()
    } else {
        onError()
    }
    return flow
}
