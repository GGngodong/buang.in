package com.capstone.c22018.buangin.ui.profile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.capstone.c22018.buangin.databinding.ActivityProfileBinding
import com.capstone.c22018.buangin.ui.profile.themes.ThemesActivity

class ProfileActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rlThemes.setOnClickListener {
            startActivity(Intent(this, ThemesActivity::class.java))
        }

    }
}