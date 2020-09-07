package com.example.booktask.model.types.web

data class BookRaw(
    val id: Int,
    val name: String,
    val authors: List<Int>,
    val imageUrl: String?
)
