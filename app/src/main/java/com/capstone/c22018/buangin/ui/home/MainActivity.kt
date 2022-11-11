package com.capstone.c22018.buangin.ui.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.capstone.c22018.buangin.R
import com.capstone.c22018.buangin.databinding.ActivityMainBinding
import com.capstone.c22018.buangin.ui.profile.ProfileActivity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.photoProfile.setOnClickListener {
            startActivity(Intent(this, ProfileActivity::class.java))
        }


    }
}