package com.aakash.simpleuserlist.model.data

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Geo(
    @SerializedName("lat")
    @Expose
    val lat: String,

    @SerializedName("lng")
    @Expose
    val lng: String
) : Parcelable