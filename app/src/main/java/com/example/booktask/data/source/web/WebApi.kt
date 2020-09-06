package com.example.booktask.data.source.web

import com.example.booktask.data.types.FinishedBooks
import com.example.booktask.data.types.Profile
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface WebApi {

    @GET("{token}%2Fprofile.json?alt=media")
    suspend fun getProfile(
        @Path("token") token: String
    ): Call<Profile>

    @GET("{token}%2Fbooks.json?alt=media")
    suspend fun getFinishedBooks(
        @Path("token") token: String
    ): Call<FinishedBooks>

}