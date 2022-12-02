package com.capstone.c22018.buangin.ui.profile.language

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.capstone.c22018.buangin.databinding.ActivityProfileLanguageBinding

class ProfileLanguageActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProfileLanguageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileLanguageBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}