package com.capstone.c22018.buangin.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.capstone.c22018.buangin.database.User
import com.capstone.c22018.buangin.ui.register.RegisterActivity
import com.capstone.c22018.buangin.databinding.ActivityLoginBinding
import com.capstone.c22018.buangin.ui.home.MainActivity
import com.capstone.c22018.buangin.utility.Preferences
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    private lateinit var mFirebaseDatabase: DatabaseReference
    private lateinit var mFirebaseInstance: FirebaseDatabase
    private lateinit var mDatabase: DatabaseReference

    private lateinit var preferences: Preferences

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mDatabase = FirebaseDatabase.getInstance().getReference("User")
        preferences = Preferences(this)

        auth = FirebaseAuth.getInstance()

        setActionBtn()
    }

    private fun setActionBtn() {
        binding.btnLogin.setOnClickListener {
            val email = binding.edtEmail.text.toString().trim()
            val password = binding.edtPassword.text.toString()

            // pushLogin(email, password)
            loginAccount(email, password)
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


    // Auth
    private fun loginAccount(email: String, password: String) {
        showLoading(true)
        auth.signInWithEmailAndPassword(email,password)
            .addOnCompleteListener(this) {
                if (it.isSuccessful) {
                    showLoading(false)
                    Toast.makeText(this, "Login Account Berhasil", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                } else {
                    showLoading(false)
                    Toast.makeText(this, "${it.exception?.message}", Toast.LENGTH_LONG).show()
                }
            }
    }

    // RealtimeDatabase
    private fun pushLogin(email: String, password: String) {
        mDatabase.child(email).addValueEventListener(object: ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val user = dataSnapshot.getValue(User::class.java)
                if (user == null) {
                    Toast.makeText(this@LoginActivity, "User tidak ditemukan", Toast.LENGTH_SHORT).show()
                } else {
                    if (user.password.equals(password)) {

                        preferences.setValues("nama", user.name.toString())
                        preferences.setValues("url", user.url.toString())
                        preferences.setValues("email", user.email.toString())
                        preferences.setValues("status", "1")

//                        startActivity(Intent(this@LoginActivity, MainActivity::class.java))
//                        finishAffinity()
                    }
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@LoginActivity, ""+error.message, Toast.LENGTH_LONG).show()
            }
        })
    }

    private fun showLoading(loading: Boolean) {
        if (loading) {
            binding.showLoading.visibility = View.VISIBLE
        } else {
            binding.showLoading.visibility = View.GONE
        }
    }

}