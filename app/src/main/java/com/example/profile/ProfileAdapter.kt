package com.example.profile

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ProfileAdapter internal constructor(context: Context)
    : RecyclerView.Adapter<ProfileAdapter.ProfileViewHolder>(){

    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private var profileEntitys = emptyList<ProfileEntity>()

    inner class ProfileViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView) {
        val textViewProfileName: TextView = itemView.findViewById(R.id.textViewProfileName)

    }

    override fun onBindViewHolder(holder: ProfileViewHolder, position: Int) {
        val profileRec:ProfileEntity = profileEntitys.get(position)
        holder.textViewProfileName.text = profileRec.user_name.toString()

    }

    override fun getItemCount(): Int {
        return profileEntitys.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfileViewHolder {
        val itemView = inflater.inflate(R.layout.recyclerview_profile, parent, false)
        return ProfileViewHolder(itemView)
    }

    fun setProfile(profileEntitys: List<ProfileEntity>){
        this.profileEntitys = profileEntitys
        notifyDataSetChanged()
    }

}