package com.example.booktask

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.booktask.data.source.dao.FinishedBooksDao
import com.example.booktask.data.source.dao.ProfileDao
import com.example.booktask.data.types.Book
import com.example.booktask.data.types.Profile

@Database(entities = [
	Profile::class,
	Book::class
], version = 1)
abstract class AppDatabase : RoomDatabase() {
	abstract fun profileDao(): ProfileDao
	abstract fun finishedBooksDao(): FinishedBooksDao
}