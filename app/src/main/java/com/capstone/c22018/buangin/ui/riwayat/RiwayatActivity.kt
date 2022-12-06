package com.capstone.c22018.buangin.ui.riwayat

import android.app.Activity
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.capstone.c22018.buangin.database.BankSampahModel
import com.capstone.c22018.buangin.databinding.ActivityRiwayatBinding
import com.capstone.c22018.buangin.ui.home.MainActivity
import com.capstone.c22018.buangin.utility.FunctionHelper
import com.capstone.c22018.buangin.viewmodel.HistoryViewModel

class RiwayatActivity : AppCompatActivity(), RiwayatAdapter.RiwayatAdapterCallback {

    private lateinit var binding: ActivityRiwayatBinding
    private var modelDatabaseList: MutableList<BankSampahModel> = ArrayList()
    private lateinit var riwayatAdapter: RiwayatAdapter
    private lateinit var riwayatViewModel: HistoryViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRiwayatBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.icBack.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }

        setSupportActionBar(binding.toolbar)
        setLayout()
        setViewModel()
    }

    private fun setLayout(){
        binding.apply {
            tvNotFound.visibility = View.GONE
            riwayatAdapter = RiwayatAdapter(this@RiwayatActivity,modelDatabaseList, this@RiwayatActivity)
            rvHistory.setHasFixedSize(true)
            rvHistory.layoutManager = LinearLayoutManager(this@RiwayatActivity)
            rvHistory.adapter = riwayatAdapter
        }
    }
    private fun setViewModel() {
        riwayatViewModel = ViewModelProvider(this)[HistoryViewModel::class.java]

        riwayatViewModel.totalBalance.observe(this) { integer ->
            if (integer == null) {
                val jumlahSaldo = 0
                val initSaldo = FunctionHelper.rupiahFormat(jumlahSaldo)
                binding.tvSaldo.text = initSaldo
            } else {
                val initSaldo = FunctionHelper.rupiahFormat(integer)
                binding.tvSaldo.text = initSaldo
            }
        }

        riwayatViewModel.dataBank.observe(this) { modelDatabases: List<BankSampahModel> ->
            if (modelDatabases.isEmpty()) {
                binding.tvNotFound.visibility = View.VISIBLE
                binding.rvHistory.visibility = View.GONE
            } else {
                binding.rvHistory.visibility = View.GONE
                binding.rvHistory.visibility = View.VISIBLE
            }
            riwayatAdapter.setUpData(modelDatabases)
        }
    }
    override fun onDelete(modelDatabase: BankSampahModel?) {
        val alertDialogBuilder = AlertDialog.Builder(this)
        alertDialogBuilder.setMessage("Hapus riwayat ini?")
        alertDialogBuilder.setPositiveButton("Ya, Hapus") { _: DialogInterface, _: Int ->
            val uid = modelDatabase?.uid
            uid?.let { riwayatViewModel.deleteDataById(it) }
            Toast.makeText(this@RiwayatActivity, "Data yang dipilih sudah dihapus", Toast.LENGTH_SHORT).show()
        }

        alertDialogBuilder.setNegativeButton("Batal") { dialogInterface: DialogInterface, _: Int -> dialogInterface.cancel() }
        val alertDialog = alertDialogBuilder.create()
        alertDialog.show()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

}