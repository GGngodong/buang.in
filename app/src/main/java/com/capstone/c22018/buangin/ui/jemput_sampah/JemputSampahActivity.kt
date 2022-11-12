package com.capstone.c22018.buangin.ui.jemput_sampah

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.capstone.c22018.buangin.databinding.ActivityJemputSampahBinding
import com.capstone.c22018.buangin.ui.home.MainActivity

class JemputSampahActivity : AppCompatActivity() {

    private lateinit var binding: ActivityJemputSampahBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityJemputSampahBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setToolbar()

        binding.icBack.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }

    }

    private fun setToolbar() {
        if (supportActionBar != null) {
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
            supportActionBar?.setDisplayShowTitleEnabled(false)
        }
    }

}