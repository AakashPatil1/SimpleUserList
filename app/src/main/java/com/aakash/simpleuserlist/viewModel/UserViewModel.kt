package com.aakash.simpleuserlist.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aakash.simpleuserlist.utils.NetworkHelper
import com.aakash.simpleuserlist.utils.Resource
import com.aakash.simpleuserlist.model.data.User
import com.aakash.simpleuserlist.model.repository.UsersRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(
    private val usersRepository: UsersRepository,
    private val networkHelper: NetworkHelper
) : ViewModel() {

    private val _userList = MutableLiveData<Resource<List<User>>>()
    val userList: LiveData<Resource<List<User>>> get() = _userList

    init {
        fetchUserList()
    }

    fun fetchUserList() {
        _userList.value = Resource.Loading()
        viewModelScope.launch {
            if (networkHelper.isNetworkConnected()) {
                try {
                    val users = usersRepository.fetchUserList()
                    if (users.isNotEmpty()) {
                        _userList.value = Resource.Success(users)
                    } else {
                        _userList.value = Resource.Error("User list is empty", null)
                    }
                } catch (e: Exception) {
                    _userList.value = Resource.Error("Failed to fetch user list", null)
                }
            } else {
                _userList.value = Resource.Error("No Internet Connection", null)
            }
        }
    }
}