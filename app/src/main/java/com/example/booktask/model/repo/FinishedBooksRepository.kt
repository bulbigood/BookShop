package com.example.booktask.model.repo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.booktask.model.source.FinishedBooksDataSource
import com.example.booktask.model.types.db.Book
import timber.log.Timber

class FinishedBooksRepository(
    private val token: String,
    private val localDataSource: FinishedBooksDataSource,
    private val remoteDataSource: FinishedBooksDataSource
) : Repository<List<Book>> {

	override fun data(): LiveData<Result<List<Book>>> {
		// TODO:
		return MutableLiveData()
		//return localDataSource.observeAll(token)
	}

	override suspend fun refresh() {
		val data = remoteDataSource.getAll(token).getOrElse {
            Timber.e(it)
            return
        }
		// TODO: атомарная операция update
		localDataSource.removeAll(token)
		localDataSource.saveAll(token, data)
	}
}
