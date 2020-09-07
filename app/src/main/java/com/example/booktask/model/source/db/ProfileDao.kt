package com.example.booktask.model.source.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.booktask.model.types.db.Profile

@Dao
interface ProfileDao {

    @Query("SELECT * FROM Profiles WHERE token = :key")
    fun observe(key: String): LiveData<Profile?>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(vararg profiles: Profile)

    @Query("DELETE FROM Profiles WHERE token = :key")
    suspend fun delete(key: String)
}
