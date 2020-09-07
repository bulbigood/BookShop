package com.example.booktask.model.source.web

import androidx.lifecycle.LiveData
import com.example.booktask.model.source.FinishedBooksDataSource
import com.example.booktask.model.types.db.Book

class FinishedBooksWebSource(
	private val api: WebApi
) : FinishedBooksDataSource {
	override fun observe(key: String): LiveData<Result<Book>> {
		TODO("Not yet implemented")
	}

	override fun observeAll(key: String): LiveData<Result<List<Book>>> {
		TODO("Not yet implemented")
	}

	override suspend fun get(key: String): Result<Book> {
		TODO("Not yet implemented")
	}

	override suspend fun getAll(key: String): Result<List<Book>> {
		return Result.failure(RuntimeException("Not yet implemented"))
	}

	override suspend fun save(key: String, value: Book) {
		TODO("Not yet implemented")
	}

	override suspend fun saveAll(key: String, values: Collection<Book>) {
		TODO("Not yet implemented")
	}

	override suspend fun remove(key: String) {
		TODO("Not yet implemented")
	}

	override suspend fun removeAll(key: String) {
		TODO("Not yet implemented")
	}
}
