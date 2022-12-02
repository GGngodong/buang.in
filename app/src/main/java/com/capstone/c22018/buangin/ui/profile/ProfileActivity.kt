package com.capstone.c22018.buangin.ui.profile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.capstone.c22018.buangin.databinding.ActivityProfileBinding
import com.capstone.c22018.buangin.ui.login.LoginActivity
import com.capstone.c22018.buangin.ui.profile.account.ProfileAccountActivity
import com.capstone.c22018.buangin.ui.profile.help.ProfileHelpActivity
import com.capstone.c22018.buangin.ui.profile.language.ProfileLanguageActivity
import com.capstone.c22018.buangin.ui.profile.privacy.ProfilePrivacyActivity

class ProfileActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setActionBtn()

    }

    private fun setActionBtn() {

        binding.rlAccount.setOnClickListener {
            startActivity(Intent(this, ProfileAccountActivity::class.java))
        }

        binding.rlAbout.setOnClickListener {
            startActivity(Intent(this, ProfileHelpActivity::class.java))
        }

        binding.rlPrivacy.setOnClickListener {
            startActivity(Intent(this, ProfilePrivacyActivity::class.java))
        }

        binding.rlLanguage.setOnClickListener {
            startActivity(Intent(this, ProfileLanguageActivity::class.java))
        }

        binding.btnLogout.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }

    }


}