package com.capstone.c22018.buangin.ui.register

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.capstone.c22018.buangin.databinding.ActivityCameraBinding

class CameraActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCameraBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCameraBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}