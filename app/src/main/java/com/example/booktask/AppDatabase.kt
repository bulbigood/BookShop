package com.example.booktask

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.booktask.model.source.db.BookDao
import com.example.booktask.model.source.db.ProfileDao
import com.example.booktask.model.types.db.Author
import com.example.booktask.model.types.db.Book
import com.example.booktask.model.types.db.Book2Author
import com.example.booktask.model.types.db.Profile

@Database(
	entities = [
		Profile::class,
		Book::class,
		Author::class,
		Book2Author::class
	],
	version = 3,
	exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
	abstract fun profileDao(): ProfileDao
	abstract fun finishedBooksDao(): BookDao
}
