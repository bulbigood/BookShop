package com.example.booktask.model.types.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "books")
data class Book @JvmOverloads constructor(
    @PrimaryKey @ColumnInfo var id: Int = 0,
    @ColumnInfo var name: String = "",
    @ColumnInfo var authors: Int = 0,
    @ColumnInfo var imageUrl: String? = null
)
