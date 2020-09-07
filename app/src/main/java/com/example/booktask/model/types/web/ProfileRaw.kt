package com.example.booktask.model.types.web

import com.example.booktask.model.types.db.Profile

data class ProfileRaw(
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
) {
    fun toProfile(token: String): Profile {
        return Profile(
            token = token,
            accountId = accountId,
            birthDate = birthDate,
            city = city,
            country = country,
            email = email,
            firstName = firstName,
            lastName = lastName,
            gender = gender,
            isFull = isFull,
            lang = lang,
            phoneNumber = phoneNumber,
            vip = vip,
            vipExpired = vipExpired
        )
    }
}