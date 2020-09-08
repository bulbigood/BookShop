package com.example.booktask.utils

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.booktask.model.types.web.ApiResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

typealias StringResource = Int

// TODO: куда кидать контекст корутины? Проверить эмуляцией долгой загрузки
suspend fun <T, K> Response<ApiResponse<T>>.result(transform: T.() -> K): Result<K> {
	return withContext(Dispatchers.IO) {
		val data = body()?.data
		if (isSuccessful && data != null) {
			val transformedData = data.transform()
			Result.success(transformedData)
		} else {
			val message = errorBody()?.string() ?: message()
			Result.failure(RuntimeException(message))
		}
	}
}

fun <T> Result<T>.toLiveData(onError: (Throwable) -> Unit): LiveData<T> {
	val flow = MutableLiveData<T>()
	fold({
        flow.value = it
    }) {
		onError(it)
	}
	return flow
}
