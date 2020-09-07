package com.example.booktask.model.types.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "profiles")
data class Profile @JvmOverloads constructor(
    @PrimaryKey @ColumnInfo var token: String = "",
    @ColumnInfo var accountId: String = "",
    @ColumnInfo var birthDate: String? = null,
    @ColumnInfo var city: String? = null,
    @ColumnInfo var country: String? = null,
    @ColumnInfo var email: String = "",
    @ColumnInfo var firstName: String? = null,
    @ColumnInfo var lastName: String? = null,
    @ColumnInfo var gender: String? = null,
    @ColumnInfo var isFull: Boolean? = null,
    @ColumnInfo var lang: String? = null,
    @ColumnInfo var phoneNumber: String? = null,
    @ColumnInfo var vip: Boolean = false,
    @ColumnInfo var vipExpired: String? = null
)
