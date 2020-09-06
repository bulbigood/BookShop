package com.example.booktask.data.source

import androidx.lifecycle.LiveData

interface DataSource<K, V> {
    fun observe(key: K): LiveData<Result<V>>
    fun observeAll(key: K): LiveData<Result<List<V>>>

    suspend fun get(key: K): Result<V>
    suspend fun getAll(key: K): Result<List<V>>

    suspend fun save(key: K, value: V)
    suspend fun saveAll(key: K, values: Collection<V>)

    suspend fun remove(key: K)
    suspend fun removeAll(key: K)
}