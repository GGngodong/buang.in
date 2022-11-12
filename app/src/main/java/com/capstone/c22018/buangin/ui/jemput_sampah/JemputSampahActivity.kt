package com.capstone.c22018.buangin.ui.jemput_sampah

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.capstone.c22018.buangin.databinding.ActivityJemputSampahBinding

class JemputSampahActivity : AppCompatActivity() {

    private lateinit var binding: ActivityJemputSampahBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityJemputSampahBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}