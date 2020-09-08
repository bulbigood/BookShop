package com.example.booktask.model.types.web

import com.example.booktask.model.types.db.Author

data class AuthorRaw(
	val id: Long,
	val firstName: String,
	val lastName: String,
	val birthDate: String?
) {
	fun toAuthor(): Author {
		return Author(
			id = id,
			firstName = firstName,
			lastName = lastName,
			birthDate = birthDate
		)
	}
}
