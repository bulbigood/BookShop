package com.example.booktask.data.source.web

import androidx.lifecycle.LiveData
import com.example.booktask.data.source.FinishedBooksDataSource
import com.example.booktask.data.types.Book

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
		TODO("Not yet implemented")
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
