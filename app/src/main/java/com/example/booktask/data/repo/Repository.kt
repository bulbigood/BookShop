package com.example.booktask.data.repo

import androidx.lifecycle.LiveData

interface Repository<T> {
    fun data(): LiveData<Result<T>>
    suspend fun refresh()
}