package com.aakash.simpleuserlist.model.data

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Company(
    @SerializedName("name")
    @Expose
    val name: String,

    @SerializedName("catchPhrase")
    @Expose
    val catchPhrase: String,

    @SerializedName("bs")
    @Expose
    val bs: String
) : Parcelable