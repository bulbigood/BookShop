package com.example.booktask.data.source.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import com.example.booktask.data.source.ProfileDataSource
import com.example.booktask.data.types.Profile

@Dao
interface ProfileDao : ProfileDataSource {

    override fun observe(key: String): LiveData<Result<Profile>>

    override suspend fun get(key: String): Result<Profile>

    override suspend fun save(key: String, value: Profile)

    override suspend fun remove(key: String)

}