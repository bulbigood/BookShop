package com.example.booktask.model.types.web

import com.example.booktask.model.types.db.Author
import com.example.booktask.model.types.db.Book

data class BookRaw(
    val id: Long,
    val name: String,
    val authors: List<Long>,
    val imageUrl: String?
) {
    fun toBook(authors: List<Author>): Book {
        return Book(
            id = id,
            name = name,
            authors = authors,
            imageUrl = imageUrl
        )
    }
}
