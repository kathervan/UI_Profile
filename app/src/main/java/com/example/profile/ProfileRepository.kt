package com.example.profile

import androidx.lifecycle.LiveData

class ProfileRepository (private val profileDao: ProfileDao){
    val profileList : LiveData<List<ProfileEntity>> = profileDao.getProfile()

    suspend fun insertProfile(profileEntity: ProfileEntity){
        profileDao.insertProfile(profileEntity)
    }
}
