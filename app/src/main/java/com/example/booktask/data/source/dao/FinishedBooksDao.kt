package com.example.booktask.data.source.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import com.example.booktask.data.source.FinishedBooksDataSource
import com.example.booktask.data.types.Book

@Dao
interface FinishedBooksDao : FinishedBooksDataSource {

    override fun observe(key: String): LiveData<Result<Book>>

    override suspend fun get(key: String): Result<Book>

    override suspend fun getAll(key: String): Result<List<Book>>

    override suspend fun save(key: String, value: Book)

    override suspend fun saveAll(key: String, values: Collection<Book>)

    override suspend fun remove(key: String)

    override suspend fun removeAll(key: String)

}