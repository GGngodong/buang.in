package com.capstone.c22018.buangin.ui.register

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.capstone.c22018.buangin.R
import com.capstone.c22018.buangin.databinding.ActivityRegisterBinding
import com.capstone.c22018.buangin.ui.register.registeruser.RegisterFragment

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val mFragmentManager = supportFragmentManager
        val mRegisterAccount = RegisterFragment()
        val fragment = mFragmentManager.findFragmentByTag(RegisterFragment::class.java.simpleName)

        if (fragment !is RegisterFragment) {
            mFragmentManager
                .beginTransaction()
                .add(R.id.frame_container, mRegisterAccount, RegisterFragment::class.java.simpleName)
                .commit()
        }

    }

}