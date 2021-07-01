package com.indialone.myownsiimplenavigationdemo

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(
    var username: String,
    var password: String
) : Parcelable
