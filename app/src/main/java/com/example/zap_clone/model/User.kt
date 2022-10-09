package com.example.zap_clone.model

import android.os.Parcel
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(
    val id: String?,
    val name: String?,
    val email: String?
) : Parcelable