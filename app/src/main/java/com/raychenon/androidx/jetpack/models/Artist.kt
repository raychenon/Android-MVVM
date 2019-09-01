package com.raychenon.androidx.jetpack.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Artist(
    val id: Long,
    val name: String,
    val picture_medium: String,
    val picture_big: String
) : Parcelable
