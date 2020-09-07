package com.example.booktask.model.source.web

import androidx.lifecycle.LiveData
import com.example.booktask.model.source.ProfileDataSource
import com.example.booktask.model.types.db.Profile
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
        return api.getProfile(key).result {
            toProfile(key)
        }
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