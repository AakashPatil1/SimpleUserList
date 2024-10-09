package com.aakash.simpleuserlist.model.data

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

import kotlinx.parcelize.Parcelize


@Parcelize
data class User(
    @SerializedName("id")
    @Expose
    val id: Int,

    @SerializedName("name")
    @Expose
    val name: String,

    @SerializedName("username")
    @Expose
    val username: String,

    @SerializedName("email")
    @Expose
    val email: String,

    @SerializedName("address")
    @Expose
    val address: Address,

    @SerializedName("phone")
    @Expose
    val phone: String,

    @SerializedName("website")
    @Expose
    val website: String,

    @SerializedName("company")
    @Expose
    val company: Company
) : Parcelable