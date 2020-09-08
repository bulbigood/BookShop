package com.example.booktask.model.source.db

import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import com.example.booktask.model.source.FinishedBooksDataSource
import com.example.booktask.model.types.db.Book

class FinishedBooksDatabaseSource(
	private val api: BookDao
) : FinishedBooksDataSource {
	override fun observe(key: String): LiveData<Result<Book>> {
		TODO("Not yet implemented")
	}

	override fun observeAll(key: String): LiveData<Result<List<Book>>> {
		return api.observeAll()
			.map {  list ->
				list.map {
					it.toBook()
				}
			}
			.map { Result.success(it) }
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
		api.insert(*values.toTypedArray())
	}

	override suspend fun remove(key: String) {
		TODO("Not yet implemented")
	}

	override suspend fun removeAll(key: String) {
		api.clear()
	}
}
