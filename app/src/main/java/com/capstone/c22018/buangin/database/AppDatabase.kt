package com.capstone.c22018.buangin.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [BankSampahModel::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase () {
    abstract fun bankSampahDao(): BankSampahDao
}