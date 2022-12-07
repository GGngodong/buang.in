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
import com.google.firebase.database.*

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding

    private lateinit var mFirebaseDatabase: DatabaseReference
    private lateinit var mFirebaseInstance: FirebaseDatabase
    private lateinit var mDatabase: DatabaseReference

    private lateinit var preferences: Preferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mFirebaseInstance = FirebaseDatabase.getInstance()
        mDatabase = FirebaseDatabase.getInstance().reference
        mFirebaseDatabase = mFirebaseInstance.getReference("User")

        preferences = Preferences(this)

        setActionBtn()

    }

    private fun setActionBtn() {

        binding.btnRegister.setOnClickListener {
            val edtName = binding.edtNameRegister.text.toString()
            val edtEmail = binding.edtEmail.text.toString()
            val edtPass = binding.edtPassword.text.toString()

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
                } else {
                    showLoading(false)
                    Toast.makeText(this@RegisterActivity, "Account sudah terdaftar", Toast.LENGTH_SHORT).show()
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