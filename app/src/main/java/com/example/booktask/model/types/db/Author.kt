package com.example.booktask.model.types.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "authors")
data class Author @JvmOverloads constructor(
    @PrimaryKey @ColumnInfo var id: Long = 0,
    @ColumnInfo var firstName: String = "",
    @ColumnInfo var lastName: String = "",
    @ColumnInfo var birthDate: String? = null
)
