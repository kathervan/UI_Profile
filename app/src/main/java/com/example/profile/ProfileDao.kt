package com.example.profile

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface ProfileDao {
    @Insert
    suspend fun insertProfile(profileEntity: ProfileEntity)

    @Query("SELECT * FROM profile")
    fun getProfile() : LiveData<List<ProfileEntity>>

    @Query("SELECT * FROM profile WHERE id = :profile_id")
    fun getProfile(profile_id: Int): ProfileEntity

    @Update
    suspend fun updateProfile(profileEntity: ProfileEntity)

    @Delete
    suspend fun deleteProfile(profileEntity: ProfileEntity)

    @Query("DELETE FROM profile WHERE id = :profile_id")
    suspend fun deleteProfile(profile_id: Int)

}