package com.capstone.c22018.buangin.ui.jenis_sampah

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.capstone.c22018.buangin.R
import com.capstone.c22018.buangin.databinding.ActivityJenisSampahBinding
import com.capstone.c22018.buangin.ui.home.MainActivity

class JenisSampahActivity : AppCompatActivity() {

    private lateinit var binding: ActivityJenisSampahBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityJenisSampahBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setToolBar()

        binding.icBack.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }

    }

    private fun setToolBar(){
        if (supportActionBar != null) {
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
            supportActionBar?.setTitle(R.string.jenisSampah)
        }
    }
}