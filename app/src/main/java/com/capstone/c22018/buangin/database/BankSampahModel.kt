package com.capstone.c22018.buangin.database

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(tableName = "waste_bank")
@Parcelize
data class BankSampahModel (
    @PrimaryKey(autoGenerate = true)
    var uid: Int = 0,

    @ColumnInfo(name = "user_name")
    var userName: String,

    @ColumnInfo(name = "waste_type")
    var wasteType: String,

    @ColumnInfo(name = "weight")
    var weight: Int = 0,

    @ColumnInfo(name = "price")
    var price: Int = 0,

    @ColumnInfo(name = "date")
    var date: String,

    @ColumnInfo(name = "address")
    var address: String,

    @ColumnInfo(name = "note")
    var note: String
        ) : Parcelable