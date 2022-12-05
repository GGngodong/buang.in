package com.capstone.c22018.buangin.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface BankSampahDao {

    @Query("SELECT * FROM waste_bank")
    fun getAll(): LiveData<List<BankSampahModel>>

    @Query("SELECT SUM(price) FROM waste_bank")
    fun getSaldo(): LiveData<Int>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertData(modelDatabases: BankSampahModel)

    @Query("DELETE FROM waste_bank WHERE uid= :uid")
    fun deleteSingleData(uid: Int)
}