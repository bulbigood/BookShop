package com.example.booktask.model.types.web

data class ApiResponse<T>(
	val data: T?,
	val reason: String?,
	val status: String
)
