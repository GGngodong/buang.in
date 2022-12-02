package com.capstone.c22018.buangin.ui.profile.help

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.capstone.c22018.buangin.databinding.ActivityProfileHelpBinding

class ProfileHelpActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProfileHelpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileHelpBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}