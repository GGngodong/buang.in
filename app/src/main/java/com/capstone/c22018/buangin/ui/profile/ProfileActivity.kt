package com.capstone.c22018.buangin.ui.profile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.capstone.c22018.buangin.R
import com.capstone.c22018.buangin.databinding.ActivityProfileBinding
import com.capstone.c22018.buangin.ui.profile.profileuser.ProfileUserFragment

class ProfileActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val mFragmentManager = supportFragmentManager
        val mProfileUser = ProfileUserFragment()
        val fragment = mFragmentManager.findFragmentByTag(ProfileUserFragment::class.java.simpleName)

        if (fragment !is ProfileUserFragment) {
            mFragmentManager
                .beginTransaction()
                .add(R.id.frame_profile, mProfileUser, ProfileUserFragment::class.java.simpleName)
                .commit()
        }

    }
}