package com.example.booktask.model.types.db

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(tableName = "book2author", primaryKeys = ["bookId", "authorId"])
data class Book2Author @JvmOverloads constructor(
    @ColumnInfo var bookId: Long = 0,
    @ColumnInfo var authorId: Long = 0,
)
