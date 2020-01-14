package com.example.profile

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "profile")
data class ProfileEntity (
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val user_name: String,
    val user_work: String,
    val user_education: String,
    val user_country: String,
    val user_email: String,
    val user_phone: String
    //val user_picture: String
)