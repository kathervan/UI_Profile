package com.example.profile

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class ProfileViewModel (application: Application) : AndroidViewModel(application){
    private val profileRepository: ProfileRepository

    val profileList : LiveData<List<ProfileEntity>>

    init {
        val profileDao = ProfileDatabase.getDatabase(application).profileDao()
        profileRepository = ProfileRepository(profileDao)
        profileList = profileRepository.profileList
    }
    //Execute a coroutine
    fun insertProfile(profileEntity: ProfileEntity) = viewModelScope.launch {
        profileRepository.insertProfile(profileEntity)
    }

}