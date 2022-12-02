package com.capstone.c22018.buangin.ui.profile.account

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.capstone.c22018.buangin.databinding.ActivityProfileAccountBinding

class ProfileAccountActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProfileAccountBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileAccountBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}