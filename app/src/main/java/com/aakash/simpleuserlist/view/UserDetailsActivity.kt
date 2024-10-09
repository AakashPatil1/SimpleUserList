package com.aakash.simpleuserlist.view

import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.aakash.simpleuserlist.R
import com.aakash.simpleuserlist.model.data.User

class UserDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_details)
        val imageViewBack: ImageView = findViewById(R.id.imageViewBack)
        val textViewUserName: TextView = findViewById(R.id.textViewUserName)
        val textViewUserEmail: TextView = findViewById(R.id.textViewUserEmail)
        val textViewUserPhone: TextView = findViewById(R.id.textViewUserPhone)
        val textViewUserAddress: TextView = findViewById(R.id.textViewUserAddress)
        if (intent != null) {
            val user = intent.getParcelableExtra<User>("USER")
            Log.d("TAG", "onCreate: ${user}")
            user?.let {
                textViewUserName.text = it.name
                textViewUserEmail.text = it.email
                textViewUserPhone.text = it.phone
                val fullAddress =
                    "${it.address.street}, ${it.address.suite}, ${it.address.city}, ${it.address.zipcode}"
                textViewUserAddress.text = fullAddress
            }

        }
        imageViewBack.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }
    }
}