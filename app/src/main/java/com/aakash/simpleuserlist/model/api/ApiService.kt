package com.aakash.simpleuserlist.model.api


import com.aakash.simpleuserlist.model.data.User
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("users")
    suspend fun fetchUsersList(): Response<List<User>>

}
