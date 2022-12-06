package com.capstone.c22018.buangin.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.capstone.c22018.buangin.database.BankSampahDao
import com.capstone.c22018.buangin.database.BankSampahModel
import com.capstone.c22018.buangin.database.ClientDatabase.Companion.getInstance
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.schedulers.Schedulers

class HistoryViewModel (application: Application) : AndroidViewModel(application){

    var totalBalance : LiveData<Int>
    var dataBank: LiveData<List<BankSampahModel>>
    private var bankSampahDao : BankSampahDao ? = null

    fun deleteDataById(uid : Int) {
        Completable.fromAction{
            bankSampahDao?.deleteSingleData(uid)
        }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe()
    }

    init {
        bankSampahDao = getInstance(application)?.appDatabase?.bankSampahDao()
        dataBank = bankSampahDao?.getAll()!!
        totalBalance = bankSampahDao?.getSaldo()!!
    }

}