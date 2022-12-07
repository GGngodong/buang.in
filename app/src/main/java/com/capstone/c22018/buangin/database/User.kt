package com.capstone.c22018.buangin.database

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User(
    var email: String ?= "",
    var name: String ?= "",
    var password: String ?= "",
    var url: String ?= "",
): Parcelable
