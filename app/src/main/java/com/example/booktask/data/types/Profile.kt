package com.example.booktask.data.types

data class Profile(
    val accountId: String,
    val birthDate: String?,
    val city: String?,
    val country: String?,
    val email: String,
    val firstName: String?,
    val lastName: String?,
    val gender: String?,
    val isFull: Boolean?,
    val lang: String?,
    val phoneNumber: String?,
    val vip: Boolean,
    val vipExpired: String?
)