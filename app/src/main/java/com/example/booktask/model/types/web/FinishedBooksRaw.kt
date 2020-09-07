package com.example.booktask.model.types.web

import com.example.booktask.model.types.db.Book

// TODO:
data class FinishedBooksRaw(
    val count: Int,
    val books: List<Book>
)
