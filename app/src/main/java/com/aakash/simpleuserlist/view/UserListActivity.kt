package com.aakash.simpleuserlist.view

import android.os.Bundle
import android.view.View
import android.widget.SearchView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.aakash.simpleuserlist.R
import com.aakash.simpleuserlist.utils.LoadingDialog
import com.aakash.simpleuserlist.utils.Resource
import com.aakash.simpleuserlist.model.data.User
import com.aakash.simpleuserlist.view.adapter.UserAdapter
import com.aakash.simpleuserlist.viewModel.UserViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UserListActivity : AppCompatActivity() {

    private val viewModel: UserViewModel by viewModels()
    private lateinit var userAdapter: UserAdapter
    private lateinit var searchView: SearchView
    private var list: List<User> = emptyList()
    private lateinit var loadingDialog: LoadingDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_list)

        val recyclerView = findViewById<RecyclerView>(R.id.recycleView)
        val textViewPlaceHolder = findViewById<TextView>(R.id.textViewPlaceHolder)
        searchView = findViewById(R.id.searchView)
        loadingDialog = LoadingDialog(this)

        recyclerView.layoutManager = LinearLayoutManager(this)
        userAdapter = UserAdapter()
        recyclerView.adapter = userAdapter


        viewModel.userList.observe(this) { resource ->
            when (resource) {
                is Resource.Loading -> {
                    loadingDialog.show()
                }

                is Resource.Success -> {
                    textViewPlaceHolder.visibility = View.GONE
                    recyclerView.visibility = View.VISIBLE
                    loadingDialog.dismiss()
                    list = resource.data!!
                    userAdapter.submitList(list)
                }

                is Resource.Error -> {
                    loadingDialog.dismiss()
                    textViewPlaceHolder.visibility = View.VISIBLE
                    recyclerView.visibility = View.GONE
                    Toast.makeText(this@UserListActivity, resource.message, Toast.LENGTH_LONG)
                        .show()
                }
            }
        }


        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(value: String?): Boolean {
                if (list.isNotEmpty()) {
                    val filteredList = list.filter { user ->
                        user.name.contains(value ?: "", ignoreCase = true)
                    }

                    if (filteredList.isNotEmpty()) {
                        userAdapter.submitList(filteredList)
                    } else {
                        Toast.makeText(this@UserListActivity, "No match found", Toast.LENGTH_SHORT)
                            .show()
                    }
                }
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                if (list.isNotEmpty()) {
                    val filteredList = list.filter { user ->
                        user.name.contains(newText ?: "", ignoreCase = true)
                    }

                    if (filteredList.isNotEmpty()) {
                        userAdapter.submitList(filteredList)
                    }
                }
                return false
            }
        })

        searchView.setOnCloseListener {
            userAdapter.submitList(list)
            false
        }
    }

}