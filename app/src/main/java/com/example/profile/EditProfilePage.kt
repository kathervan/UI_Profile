package com.example.profile

import android.app.Activity
import android.content.Intent
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory
import kotlinx.android.synthetic.main.activity_edit_profile_page.*


class EditProfilePage : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_profile_page)
        //Now get the support action bar
        val actionBar = supportActionBar

        val img = BitmapFactory.decodeResource(resources, R.drawable.kuro)
        val round = RoundedBitmapDrawableFactory.create(resources, img)

        round.cornerRadius = 25f

        round.isCircular = true
        profileImage.setImageDrawable(round)

        // Set toolbar title/app title
        actionBar!!.title = "Edit Profile"

        //Display the app icon in action bar
        actionBar.setDisplayShowHomeEnabled(true)
        actionBar.setDisplayUseLogoEnabled(true)


        buttonAdd.setOnClickListener{
            saveEditProfile()
        }

    }

    private fun saveEditProfile(){
        //Create an Explicit Intent for the ProfilePage
        val intent = Intent(this,
            ProfilePage::class.java)

        //Prepare extra
        val saveName = editTextProfileName.text.toString()
        val saveOccupation = editTextOccupation.text.toString()
        val saveEducation = editTextEducation.text.toString()
        val saveCountry = editTextCountry.text.toString()
        val saveEmail = editTextEmail.text.toString()
        val savePhone = editTextPhone.text.toString()
        //val saveProfilePhoto = textViewChangeProfilePhoto.text.toString()

        intent.putExtra(EXTRA_NAME, saveName)
        intent.putExtra(EXTRA_OCCUPATION, saveOccupation)
        intent.putExtra(EXTRA_EDUCATION, saveEducation)
        intent.putExtra(EXTRA_COUNTRY, saveCountry)
        intent.putExtra(EXTRA_EMAIL, saveEmail)
        intent.putExtra(EXTRA_PHONE, savePhone)

        //Start an activity with no return value
        startActivity(intent)

        //setResult(Activity.RESULT_OK, intent)
        //finish()

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {

        val inflater = menuInflater
        inflater.inflate(R.menu.example_menu, menu);



        return super.onCreateOptionsMenu(menu)
    }

    companion object{
        const val EXTRA_NAME = "com.example.profile"
        const val EXTRA_OCCUPATION = "com.example.profile"
        const val EXTRA_EDUCATION = "com.example.profile"
        const val EXTRA_COUNTRY = "com.example.profile"
        const val EXTRA_EMAIL = "com.example.profile"
        const val EXTRA_PHONE = "com.example.profile"

    }

}
