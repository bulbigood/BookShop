package com.example.booktask.data.repo

import androidx.lifecycle.LiveData
import com.example.booktask.data.source.FinishedBooksDataSource
import com.example.booktask.data.types.Book

class FinishedBooksRepository(
    private val token: String,
    private val localDataSource: FinishedBooksDataSource,
    private val remoteDataSource: FinishedBooksDataSource
) : Repository<List<Book>> {

    override fun data(): LiveData<Result<List<Book>>> {
        return localDataSource.observeAll(token)
    }

    override suspend fun refresh() {
        val data = remoteDataSource.getAll(token).getOrThrow()
        localDataSource.removeAll(token)
        localDataSource.saveAll(token, data)
    }
}
