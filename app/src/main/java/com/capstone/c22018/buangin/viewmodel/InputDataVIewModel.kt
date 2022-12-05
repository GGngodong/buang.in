package com.capstone.c22018.buangin.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.capstone.c22018.buangin.database.BankSampahDao
import com.capstone.c22018.buangin.database.BankSampahModel
import com.capstone.c22018.buangin.database.ClientDatabase.Companion.getInstance
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.schedulers.Schedulers

class InputDataVIewModel (app: Application) : AndroidViewModel(app) {

    var bankSampahDao : BankSampahDao? = null

    fun insertData (userName: String, wasteType: String, wasteWeight: Int, price: Int, date: String, address: String, note: String) {
        Completable.fromAction{
            val modelDB = BankSampahModel(0, "", "", 0, 0, "", "","").apply {
                this.userName = userName
                this.wasteType = wasteType
                this.weight = wasteWeight
                this.price = price
                this.date = date
                this.address = address
                this.note = note
                bankSampahDao?.insertData(this)
            }

        }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe()
    }
    init {
        bankSampahDao = getInstance(app)?.appDatabase?.bankSampahDao()
    }

}
