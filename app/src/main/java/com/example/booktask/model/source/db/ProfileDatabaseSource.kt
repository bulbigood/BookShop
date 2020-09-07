package com.example.booktask.model.source.db

import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import com.example.booktask.model.source.ProfileDataSource
import com.example.booktask.model.types.db.Profile

class ProfileDatabaseSource(
    private val api: ProfileDao
) : ProfileDataSource {
    override fun observe(key: String): LiveData<Result<Profile>> {
        return api.observe(key).map {
            if (it != null) {
                Result.success(it)
            } else {
                Result.failure(NullPointerException())
            }
        }
    }

    override fun observeAll(key: String): LiveData<Result<List<Profile>>> {
        TODO("Not yet implemented")
    }

    override suspend fun get(key: String): Result<Profile> {
        TODO("Not yet implemented")
    }

    override suspend fun getAll(key: String): Result<List<Profile>> {
        TODO("Not yet implemented")
    }

    override suspend fun save(key: String, value: Profile) {
        api.insert(value)
    }

    override suspend fun saveAll(key: String, values: Collection<Profile>) {
        TODO("Not yet implemented")
    }

    override suspend fun remove(key: String) {
        api.delete(key)
    }

    override suspend fun removeAll(key: String) {
        TODO("Not yet implemented")
    }

}