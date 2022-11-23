package com.capstone.c22018.buangin.ui.register

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.capstone.c22018.buangin.databinding.ActivityRegisterBinding
import com.capstone.c22018.buangin.ui.login.LoginActivity

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setActionBtn()

    }

    private fun setActionBtn() {

        binding.icBack.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }

        binding.btnRegister.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }

        binding.tvLogin.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }

        binding.iconFb.setOnClickListener {
            Toast.makeText(this, "Fitur Ini Belum Tersedia", Toast.LENGTH_SHORT).show()
        }

        binding.iconGoogle.setOnClickListener {
            Toast.makeText(this, "Fitur Ini Belum Tersedia", Toast.LENGTH_SHORT).show()
        }

    }
}