package com.example.booktask.model.source

import androidx.lifecycle.LiveData

interface DataSource<KEY, VALUE> {
    fun observe(key: KEY): LiveData<Result<VALUE>>
    fun observeAll(key: KEY): LiveData<Result<List<VALUE>>>

    suspend fun get(key: KEY): Result<VALUE>
    suspend fun getAll(key: KEY): Result<List<VALUE>>

    suspend fun save(key: KEY, value: VALUE)
    suspend fun saveAll(key: KEY, values: Collection<VALUE>)

    suspend fun remove(key: KEY)
    suspend fun removeAll(key: KEY)
}