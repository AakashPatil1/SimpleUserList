package com.aakash.simpleuserlist.model.api

import com.aakash.simpleuserlist.model.data.User
import retrofit2.Response
import javax.inject.Inject

class ApiHelperImpl @Inject constructor(private val apiService: ApiService) : ApiHelper {

    override suspend fun fetchUsersList(): Response<List<User>> =  apiService.fetchUsersList()

}