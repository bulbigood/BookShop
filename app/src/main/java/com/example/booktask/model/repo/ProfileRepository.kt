package com.example.booktask.model.repo

import androidx.lifecycle.LiveData
import com.example.booktask.model.source.ProfileDataSource
import com.example.booktask.model.types.db.Profile
import timber.log.Timber

class ProfileRepository(
    private val token: String,
    private val localDataSource: ProfileDataSource,
    private val remoteDataSource: ProfileDataSource
) : Repository<Profile> {

    override fun data(): LiveData<Result<Profile>> {
        return localDataSource.observe(token)
    }

    override suspend fun refresh() {
        val data = remoteDataSource.get(token).getOrElse {
            Timber.e(it)
            return
        }
        // TODO: атомарная операция update
        localDataSource.remove(token)
        localDataSource.save(token, data)
    }
}
