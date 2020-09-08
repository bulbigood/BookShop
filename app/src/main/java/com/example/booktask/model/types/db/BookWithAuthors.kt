package com.example.booktask.model.types.db

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation

data class BookWithAuthors(
    @Embedded
    val book: Book,
    @Relation(
        parentColumn = "id",
        entityColumn = "id",
        entity = Author::class,
        associateBy = Junction(
            value = Book2Author::class,
            parentColumn = "bookId",
            entityColumn = "authorId"
        )
    )
    val authors: List<Author> = emptyList()
) {
    fun toBook(): Book {
        return Book(
            id = book.id,
            name = book.name,
            authors = authors,
            imageUrl = book.imageUrl
        )
    }
}
