package com.aakash.simpleuserlist.model.repository

import com.aakash.simpleuserlist.model.api.ApiHelper
import com.aakash.simpleuserlist.model.data.User
import javax.inject.Inject

class UsersRepository @Inject constructor(
    private val apiHelper: ApiHelper
) {

    suspend fun fetchUserList(): List<User> {
        val response = apiHelper.fetchUsersList()
        return if (response.isSuccessful && response.body() != null) {
            response.body()!!
        } else {
            emptyList()
        }
    }

}