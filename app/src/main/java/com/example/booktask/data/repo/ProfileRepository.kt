package com.example.booktask.data.repo

import androidx.lifecycle.LiveData
import com.example.booktask.data.source.ProfileDataSource
import com.example.booktask.data.types.Profile

class ProfileRepository(
    private val token: String,
    private val localDataSource: ProfileDataSource,
    private val remoteDataSource: ProfileDataSource
) : Repository<Profile> {

    override fun data(): LiveData<Result<Profile>> {
        return localDataSource.observe(token)
    }

    override suspend fun refresh() {
        val data = remoteDataSource.get(token).getOrThrow()
        localDataSource.remove(token)
        localDataSource.save(token, data)
    }
}