package com.capstone.c22018.buangin.ui.register

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.capstone.c22018.buangin.database.User
import com.capstone.c22018.buangin.databinding.ActivityRegisterBinding
import com.capstone.c22018.buangin.ui.login.LoginActivity
import com.capstone.c22018.buangin.utility.Preferences
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding

    private lateinit var mFirebaseDatabase: DatabaseReference
    private lateinit var mFirebaseInstance: FirebaseDatabase
    private lateinit var mDatabase: DatabaseReference

    private lateinit var preferences: Preferences

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mFirebaseInstance = FirebaseDatabase.getInstance()
        mDatabase = FirebaseDatabase.getInstance().reference
        mFirebaseDatabase = mFirebaseInstance.getReference("User")

        preferences = Preferences(this)

        auth = FirebaseAuth.getInstance()

        setActionBtn()

    }

    private fun setActionBtn() {
        binding.btnRegister.setOnClickListener {
            val edtName = binding.edtNameRegister.text.toString()
            val edtEmail = binding.edtEmail.text.toString()
            val edtPass = binding.edtPassword.text.toString()

            regisAccount(edtEmail, edtPass)
            registerAccount(edtName, edtEmail, edtPass)
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

    // Auth
    private fun regisAccount(edtEmail: String, edtPass: String) {
        showLoading(true)
        auth.createUserWithEmailAndPassword(edtEmail, edtPass)
            .addOnCompleteListener(this) {
                if (it.isSuccessful) {
                    showLoading(false)
                    emailVerification()
                    Toast.makeText(this, "Register Berhasil, Silahkan Verifikasi Email", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, RegisterPhotoActivity::class.java)
                    startActivity(intent)
                    finishAffinity()
                } else {
                    showLoading(false)
                    Toast.makeText(this, "${it.exception?.message}", Toast.LENGTH_LONG).show()
                }
            }
    }

    private fun emailVerification() {
        val user = auth.currentUser
        user?.sendEmailVerification()?.addOnCompleteListener {
            if (it.isSuccessful) {
                Toast.makeText(this, "Email Verifikasi Telah Dikirim", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "${it.exception?.message}", Toast.LENGTH_SHORT).show()
            }
        }
    }

    // RealtimeDatabase
    private fun registerAccount(edtName: String, edtEmail: String, edtPass: String) {
        val user = User()
        user.name = edtName
        user.email = edtEmail
        user.password = edtPass

        checkingUsername(edtName, user)
    }

    private fun checkingUsername(iName: String, data: User) {
        mFirebaseDatabase.child(iName).addValueEventListener(object : ValueEventListener {

            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val user = dataSnapshot.getValue(User::class.java)
                showLoading(true)
                if (user == null) {
                    mFirebaseDatabase.child(iName).setValue(data)

                    preferences.setValues("nama", data.name.toString())
                    preferences.setValues("url", "")
                    preferences.setValues("email", data.email.toString())
                    preferences.setValues("status", "1")

                    showLoading(false)
                    val intent = Intent(this@RegisterActivity,
                        RegisterPhotoActivity::class.java).putExtra("data", data.name)
                    startActivity(intent)
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@RegisterActivity, error.message, Toast.LENGTH_SHORT).show()
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