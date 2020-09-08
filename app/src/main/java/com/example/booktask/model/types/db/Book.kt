package com.example.booktask.model.types.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

@Entity(tableName = "books")
data class Book @JvmOverloads constructor(
    @PrimaryKey @ColumnInfo var id: Long = 0,
    @ColumnInfo var name: String = "",
    @ColumnInfo var imageUrl: String? = null,
    @Ignore var authors: List<Author> = emptyList()
)
