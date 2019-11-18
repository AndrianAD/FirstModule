package com.android.pickerfoto

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class File(var name: String, var path: String) : Parcelable