package com.example.booktask.model.source.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.booktask.model.types.db.Book
import com.example.booktask.model.types.db.BookWithAuthors

@Dao
interface BookDao {

    @Query("SELECT * FROM Books")
    fun observeAll(): LiveData<List<BookWithAuthors>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(vararg books: Book)

    @Query("DELETE FROM Books")
    suspend fun clear()
}
