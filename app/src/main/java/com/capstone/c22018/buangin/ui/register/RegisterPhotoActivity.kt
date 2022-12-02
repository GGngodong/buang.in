package com.capstone.c22018.buangin.ui.register

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.capstone.c22018.buangin.databinding.ActivityRegisterPhotoBinding
import com.capstone.c22018.buangin.ui.login.LoginActivity

class RegisterPhotoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterPhotoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterPhotoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setActionBtn()

    }

    private fun setActionBtn() {

        binding.btnSimpan.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
            Toast.makeText(this, "Foto Telah disimpan", Toast.LENGTH_SHORT).show()
        }

        binding.icAdd.setOnClickListener {
            startActivity(Intent(this, CameraActivity::class.java))
        }

    }

}