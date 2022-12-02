package com.capstone.c22018.buangin.ui.profile.privacy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.capstone.c22018.buangin.databinding.ActivityProfilePrivacyBinding

class ProfilePrivacyActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProfilePrivacyBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfilePrivacyBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}