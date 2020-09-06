package com.example.booktask.data.source.web

import androidx.lifecycle.LiveData
import com.example.booktask.data.source.ProfileDataSource
import com.example.booktask.data.types.Profile
import com.example.booktask.utils.result

class ProfileWebSource(
    private val api: WebApi
) : ProfileDataSource {
    override fun observe(key: String): LiveData<Result<Profile>> {
        TODO("Not yet implemented")
    }

    override fun observeAll(key: String): LiveData<Result<List<Profile>>> {
        TODO("Not yet implemented")
    }

    override suspend fun get(key: String): Result<Profile> {
        return api.getProfile(key).result()
    }

    override suspend fun getAll(key: String): Result<List<Profile>> {
        TODO("Not yet implemented")
    }

    override suspend fun save(key: String, value: Profile) {
        TODO("Not yet implemented")
    }

    override suspend fun saveAll(key: String, values: Collection<Profile>) {
        TODO("Not yet implemented")
    }

    override suspend fun remove(key: String) {
        TODO("Not yet implemented")
    }

    override suspend fun removeAll(key: String) {
        TODO("Not yet implemented")
    }

}