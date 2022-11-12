package com.capstone.c22018.buangin.ui.riwayat

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.capstone.c22018.buangin.databinding.ActivityRiwayatBinding
import com.capstone.c22018.buangin.ui.home.MainActivity

class RiwayatActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRiwayatBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRiwayatBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.icBack.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }

    }
}