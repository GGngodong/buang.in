package com.capstone.c22018.buangin.ui.register

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.capstone.c22018.buangin.databinding.ActivityRegisterPhotoBinding

class RegisterPhotoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterPhotoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterPhotoBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}