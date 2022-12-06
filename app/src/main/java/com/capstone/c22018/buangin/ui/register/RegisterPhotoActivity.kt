package com.capstone.c22018.buangin.ui.register

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.capstone.c22018.buangin.databinding.ActivityRegisterPhotoBinding
import com.capstone.c22018.buangin.ui.login.LoginActivity
import com.capstone.c22018.buangin.utility.rotateBitmap
import java.io.File

class RegisterPhotoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterPhotoBinding
    private var getFile: File? = null
    private var result: Bitmap? = null

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
           if (!allPermissionGranted()) {
               ActivityCompat.requestPermissions(
                   this,
                   REQUIRED_PERMISSIONS,
                   REQUEST_CODE_PERMISSIONS
               )
           } else {
               startCameraX()
           }
        }

    }




    private fun startCameraX() {
        val intent = Intent(this, CameraActivity::class.java)
        launcherIntentCameraX.launch(intent)
    }

    @Suppress("DEPRECATION")
    private val launcherIntentCameraX = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) {
        if (it.resultCode == CAMERA_X_RESULT) {
            val myFile = it.data?.getSerializableExtra("picture") as File
            val isBackCamera = it.data?.getBooleanExtra("isBackCamera", true) as Boolean

            getFile = myFile
            result = rotateBitmap(
                BitmapFactory.decodeFile(getFile?.path),
                isBackCamera
            )
            binding.ivProfile.setImageBitmap(result)
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        if (requestCode == REQUEST_CODE_PERMISSIONS) {
            if (!allPermissionGranted()) {
                Toast.makeText(
                    this,
                    "Tidak mendapatkan perizinan",
                    Toast.LENGTH_LONG
                ).show()
            }
            if (allPermissionGranted()) {
                startCameraX()
            }
        }
    }

    private fun allPermissionGranted() = REQUIRED_PERMISSIONS.all {
        ContextCompat.checkSelfPermission(baseContext, it) == PackageManager.PERMISSION_GRANTED
    }

    companion object {
        const val CAMERA_X_RESULT = 200
        private val REQUIRED_PERMISSIONS = arrayOf(Manifest.permission.CAMERA)
        private const val REQUEST_CODE_PERMISSIONS = 10
    }

}