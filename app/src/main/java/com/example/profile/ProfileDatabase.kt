package com.example.profile

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [ProfileEntity::class], version = 1)
abstract class ProfileDatabase: RoomDatabase(){
    //Create an instance of the DAO
    abstract fun profileDao() : ProfileDao

    companion object{
        //Create an instance of the Room Database
        //Singleton prevents multiple instances of the database
        @Volatile
        private var INSTANCE : ProfileDatabase? = null

        fun getDatabase(context: Context) : ProfileDatabase{
            val tempDB = INSTANCE
            if(tempDB!=null){
                return tempDB
            }

            //Create an instance of the Database
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context,
                    ProfileDatabase::class.java,
                    "profile_db"
                ).build()
                INSTANCE = instance

                return instance
            }
        }
    }


}