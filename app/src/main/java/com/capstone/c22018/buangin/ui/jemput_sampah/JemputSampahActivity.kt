package com.capstone.c22018.buangin.ui.jemput_sampah

import android.app.DatePickerDialog
import android.app.DatePickerDialog.OnDateSetListener
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.capstone.c22018.buangin.R
import com.capstone.c22018.buangin.databinding.ActivityJemputSampahBinding
import com.capstone.c22018.buangin.ui.home.MainActivity
import com.capstone.c22018.buangin.utility.FunctionHelper.rupiahFormat
import com.capstone.c22018.buangin.viewmodel.InputDataVIewModel
import java.util.*

class JemputSampahActivity : AppCompatActivity() {

    private lateinit var binding: ActivityJemputSampahBinding
    private lateinit var inputDataViewModel: InputDataVIewModel
    private lateinit var strNama: String
    private lateinit var strTanggal: String
    private lateinit var strAlamat: String
    private lateinit var strCatatan: String
    lateinit var strKategoriSelected: String
    lateinit var strHargaSelected: String
    private lateinit var strKategori: Array<String>
    lateinit var strHarga: Array<String>
    private var countTotal = 0
    var countBerat = 0
    var countHarga = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityJemputSampahBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setToolbar()
        setupData()
        setInputData()

        binding.icBack.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }

    }

    private fun setToolbar() {
        if (supportActionBar != null) {
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
            supportActionBar?.setDisplayShowTitleEnabled(false)
        }
    }

    private fun setupData () {
        strKategori = resources.getStringArray(R.array.kategori_sampah)
        strHarga = resources.getStringArray(R.array.harga_perkilo)

        inputDataViewModel = ViewModelProvider(this)[InputDataVIewModel::class.java]

        val arrayLang = ArrayAdapter(this, android.R.layout.simple_list_item_1,strKategori)
        arrayLang.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spKategoriSampah.adapter = arrayLang

        binding.spKategoriSampah.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                strKategoriSelected = parent.getItemAtPosition(position).toString()
                strHargaSelected = strHarga[position]
                binding.spKategoriSampah.isEnabled = true
                countHarga = strHargaSelected.toInt()
                if (binding.inputBerat.text.toString() != ""){
                    countBerat = binding.inputBerat.text.toString().toInt()
                    setTotalPrice(countBerat)
                } else {
                    binding.klmHarga.setText(rupiahFormat(countHarga))
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }
        binding.inputBerat.addTextChangedListener(object : TextWatcher{
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun afterTextChanged(s: Editable) {
                binding.inputBerat.removeTextChangedListener(this)
                if (s.isNotEmpty()){
                    countBerat = s.length
                    setTotalPrice(countBerat)
                } else {
                    binding.klmHarga.setText(rupiahFormat(countBerat))
                }
                binding.inputBerat.addTextChangedListener(this)
            }

        })

        binding.inputTanggalPenjemputan.setOnClickListener{
            val datePicker = Calendar.getInstance()
            val date = OnDateSetListener { _, year, month, dayOfMonth ->
                datePicker.set(Calendar.YEAR, year)
                datePicker.set(Calendar.MONTH, month)
                datePicker.set(Calendar.DAY_OF_MONTH, dayOfMonth)
                strTanggal = "${datePicker.get(Calendar.DAY_OF_MONTH)}-${datePicker.get(Calendar.MONTH)}-${datePicker.get(Calendar.YEAR)}"
                binding.inputTanggalPenjemputan.setText(strTanggal)
            }
            DatePickerDialog(this, date, datePicker.get(Calendar.YEAR), datePicker.get(Calendar.MONTH), datePicker.get(Calendar.DAY_OF_MONTH)).show()
        }
    }
    private fun setTotalPrice(berat: Int) {
        countTotal = countHarga * berat
        binding.klmHarga.setText(rupiahFormat(countTotal))
    }

    private fun setInputData(){
        binding.btnSimpan.setOnClickListener{
            strNama = binding.inputNama.text.toString()
            strAlamat = binding.inputTanggalPenjemputan.text.toString()
            strAlamat = binding.inputAlamat.text.toString()
            strCatatan = binding.note.text.toString()
            if (strNama.isEmpty() or strTanggal.isEmpty() or strAlamat.isEmpty() or (strKategori.isEmpty()) or (countBerat == 0) or (countHarga == 0)) {
                Toast.makeText(
                    this,
                    "Data tidak boleh ada yang kosong!",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                inputDataViewModel.insertData(
                    strNama,
                    strKategoriSelected,
                    countBerat,
                    countHarga,
                    strTanggal,
                    strAlamat,
                    strCatatan
                )
                Toast.makeText(
                    this,
                    "Pesanan Anda sedang diproses, cek di menu riwayat",
                    Toast.LENGTH_SHORT
                ).show()
                finish()
            }
        }
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

}