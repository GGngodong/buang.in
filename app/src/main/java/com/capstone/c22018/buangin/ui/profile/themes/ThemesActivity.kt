package com.capstone.c22018.buangin.ui.profile.themes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.capstone.c22018.buangin.databinding.ActivityThemesBinding

class ThemesActivity : AppCompatActivity() {

    private lateinit var binding: ActivityThemesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityThemesBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}