package com.example.booktask

import android.app.Application
import androidx.room.Room
import com.example.booktask.data.repo.FinishedBooksRepository
import com.example.booktask.data.repo.ProfileRepository
import com.example.booktask.data.source.web.FinishedBooksWebSource
import com.example.booktask.data.source.web.ProfileWebSource
import com.example.booktask.data.source.web.WebApi
import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class App : Application() {

    lateinit var profileRepository: ProfileRepository
    lateinit var finishedBooksRepository: FinishedBooksRepository

    override fun onCreate() {
        super.onCreate()

        val gson: Gson = GsonBuilder()
            //.registerTypeAdapter(Id::class.java, IdTypeAdapter())
            //.enableComplexMapKeySerialization()
            //.setDateFormat(DateFormat.LONG)
            .serializeNulls()
            .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
            .setPrettyPrinting()
            .create()

        val retrofit = Retrofit.Builder()
            .baseUrl("https://firebasestorage.googleapis.com/v0/b/test-f4f35.appspot.com/o/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
        val webApi = retrofit.create(WebApi::class.java)

        if (_database == null) {
            _database = Room.databaseBuilder(
                applicationContext,
                AppDatabase::class.java, "database"
            ).build()
        }

        setupDataSources(webApi)
    }

    private fun setupDataSources(webApi: WebApi) {
        val token = DEFAULT_TOKEN
        val profileWebSource = ProfileWebSource(webApi)
        val finishedBooksWebSource = FinishedBooksWebSource(webApi)
        profileRepository = ProfileRepository(
            token,
            localDataSource = database.profileDao(),
            remoteDataSource = profileWebSource
        )
        finishedBooksRepository = FinishedBooksRepository(
            token,
            localDataSource = database.finishedBooksDao(),
            remoteDataSource = finishedBooksWebSource
        )
    }

    companion object {
        private var _database: AppDatabase? = null
        private val database: AppDatabase
            get() = _database!!

        private const val DEFAULT_TOKEN = "ziPZ63IYeuRiHz2ytNlzDw0h98Ve6A7I"
        private const val PARTIAL_PROFILE_TOKEN = "hldktIc3tiGx3Tu6UlhpXNH993u8vifT"
        private const val NO_BOOKS_TOKEN = "RDhi7k79GSmdZcW4Gg7X0sUNUbYQZsxF"
        private const val EXPIRED_TOKEN = "xfTV94kfsVFyxPfvTg55aDx_jxvrNUBg"
        private const val ERROR_TOKEN = "LbwCgZvvlFO2ydRK5BAfau2elUYnauNT"
    }
}