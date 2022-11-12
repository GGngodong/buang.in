package com.capstone.c22018.buangin.ui.jenis_sampah

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.capstone.c22018.buangin.databinding.ActivityJenisSampahBinding

class JenisSampahActivity : AppCompatActivity() {

    private lateinit var binding: ActivityJenisSampahBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityJenisSampahBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}