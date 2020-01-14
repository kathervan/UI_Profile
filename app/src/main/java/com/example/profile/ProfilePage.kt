package com.example.profile

import android.app.Activity
import android.content.Intent
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_edit_profile_page.*
import kotlinx.android.synthetic.main.activity_edit_profile_page.profileImage
import kotlinx.android.synthetic.main.activity_profile_page.*

class ProfilePage : AppCompatActivity() {

    private lateinit var profileViewModel: ProfileViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_page)

        //Now get the support action bar
        val actionBar = supportActionBar

        val img = BitmapFactory.decodeResource(resources, R.drawable.kuro)
        val round = RoundedBitmapDrawableFactory.create(resources, img)

        round.cornerRadius = 25f

        round.isCircular = true
        profileImage.setImageDrawable(round)

        // Set toolbar title/app title
        actionBar!!.title = "Profile"

        //Display the app icon in action bar
        actionBar.setDisplayShowHomeEnabled(true)
        actionBar.setDisplayUseLogoEnabled(true)

        //Declare and initialize RecyclerView
        val recycler: RecyclerView = findViewById(R.id.recyclerview)
        val adapter = ProfileAdapter(this)
        recycler.adapter = adapter
        recycler.layoutManager = LinearLayoutManager(this)

        //Initialize viewModel
        profileViewModel = ViewModelProvider(this)
            .get(ProfileViewModel::class.java)

        //Add an observer to the ViewModel (LiveData)
        profileViewModel.profileList.observe(
            this,

            Observer{
                if(it.isNotEmpty()){
                    //set list of sleep to the adapter
                    adapter.setProfile(it)
                }
            }
        )

        val name = intent.getStringExtra(EditProfilePage.EXTRA_NAME)
        val occupation = intent.getStringExtra(EditProfilePage.EXTRA_OCCUPATION)
        val education = intent.getStringExtra(EditProfilePage.EXTRA_EDUCATION)
        val country = intent.getStringExtra(EditProfilePage.EXTRA_COUNTRY)
        val email = intent.getStringExtra(EditProfilePage.EXTRA_EMAIL)
        val phone = intent.getStringExtra(EditProfilePage.EXTRA_PHONE)

        textViewName.text = ": ${name}"
        textViewOccupation.text = ": ${occupation}"
        textViewEducation.text = ": ${education}"
        textViewCountry.text = ": ${country}"
        //Privacy
        //textViewEducation.text = String.format("%s",email)
        //textViewEducation.text = String.format("%s",phone)


    }
/*
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

        if(requestCode == REQUEST_CODE){
            if(resultCode == Activity.RESULT_OK){
                val user_name = data?.getStringExtra(EditProfilePage.EXTRA_NAME)
                val user_Occupation = data?.getStringExtra(EditProfilePage.EXTRA_OCCUPATION)
                val user_Education = data?.getStringExtra(EditProfilePage.EXTRA_EDUCATION)
                val user_Country = data?.getStringExtra(EditProfilePage.EXTRA_COUNTRY)
                val user_Email = data?.getStringExtra(EditProfilePage.EXTRA_EMAIL)
                val user_Phone = data?.getStringExtra(EditProfilePage.EXTRA_PHONE)

                val profileEntity = ProfileEntity(
                     id = 0,
                     user_name = user_name!!,
                     user_work = user_Occupation!!,
                     user_education = user_Education!!,
                     user_country = user_Country!!,
                     user_email = user_Email!!,
                     user_phone = user_Phone!!
                     //user_picture: String
                )

                profileViewModel.insertProfile(profileEntity)


            }
        }

        super.onActivityResult(requestCode, resultCode, data)
    }
*//*
    companion object{
        const val REQUEST_CODE = 1
    }*/
}
