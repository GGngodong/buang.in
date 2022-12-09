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
import com.google.firebase.auth.FirebaseAuth

class ProfileActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProfileBinding

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()
        val user = auth.currentUser

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
            btnLogout()
        }
    }

    private fun btnLogout() {
        auth = FirebaseAuth.getInstance()
        auth.signOut()
        val intent = Intent(this, LoginActivity::class.java)
        finishAffinity()
        startActivity(intent)
    }

}