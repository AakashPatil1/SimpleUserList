package com.aakash.simpleuserlist.model.data

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Address(
    @SerializedName("street")
    @Expose
    val street: String,

    @SerializedName("suite")
    @Expose
    val suite: String,

    @SerializedName("city")
    @Expose
    val city: String,

    @SerializedName("zipcode")
    @Expose
    val zipcode: String,

    @SerializedName("geo")
    @Expose
    val geo: Geo
) : Parcelable