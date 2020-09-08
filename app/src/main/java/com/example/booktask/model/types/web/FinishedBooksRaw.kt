package com.example.booktask.model.types.web

import com.example.booktask.model.types.db.Book

data class FinishedBooksRaw(
    val books: List<BookRaw>,
    val authors: List<AuthorRaw>
) {
    fun toBooksList(): List<Book> {
        val authorsMap = authors.associateBy { it.id }
        return books.map { bookRaw ->
            val authors = bookRaw.authors.mapNotNull {
                authorsMap[it]?.toAuthor()
            }
            bookRaw.toBook(authors)
        }
    }
}
