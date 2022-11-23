package com.capstone.c22018.buangin.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.capstone.c22018.buangin.ui.register.RegisterActivity
import com.capstone.c22018.buangin.databinding.ActivityLoginBinding
import com.capstone.c22018.buangin.ui.home.MainActivity

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setActionBtn()

    }

    private fun setActionBtn() {

        binding.btnLogin.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }

        binding.tvRegister.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }

        binding.iconFb.setOnClickListener {
            Toast.makeText(this, "Fitur Ini Belum Tersedia", Toast.LENGTH_SHORT).show()
        }

        binding.iconGoogle.setOnClickListener {
            Toast.makeText(this, "Fitur Ini Belum Tersedia", Toast.LENGTH_SHORT).show()
        }

        binding.forgotPass.setOnClickListener {
            Toast.makeText(this, "Fitur Ini Belum Tersedia", Toast.LENGTH_SHORT).show()
        }

    }

}