package com.example.booktask.model.source.web

import com.example.booktask.model.types.web.ApiResponse
import com.example.booktask.model.types.web.FinishedBooksRaw
import com.example.booktask.model.types.web.ProfileRaw
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface WebApi {

    @GET("{token}%2Fprofile.json?alt=media")
    suspend fun getProfile(
        @Path("token") token: String
    ): Response<ApiResponse<ProfileRaw>>

    @GET("{token}%2Fbooks.json?alt=media")
    suspend fun getFinishedBooks(
        @Path("token") token: String
    ): Response<ApiResponse<FinishedBooksRaw>>

}