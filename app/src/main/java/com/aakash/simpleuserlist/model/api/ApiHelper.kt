package com.aakash.simpleuserlist.model.api

import com.aakash.simpleuserlist.model.data.User

import retrofit2.Response

interface ApiHelper {
    suspend fun fetchUsersList(): Response<List<User>>
}