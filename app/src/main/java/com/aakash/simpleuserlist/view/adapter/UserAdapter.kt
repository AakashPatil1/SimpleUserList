package com.aakash.simpleuserlist.view.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.aakash.simpleuserlist.R
import com.aakash.simpleuserlist.model.data.User
import com.aakash.simpleuserlist.view.UserDetailsActivity

class UserAdapter : ListAdapter<User, UserAdapter.UserViewHolder>(UserDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.user_item, parent, false)
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = getItem(position)
        holder.bind(user)
    }

    class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val userNameTextView: TextView = itemView.findViewById(R.id.textViewUserName)
        private val userEmailTextView: TextView = itemView.findViewById(R.id.textViewUserEmail)
        private val textViewViewDetails: TextView = itemView.findViewById(R.id.textViewViewDetails)

        fun bind(user: User) {
            userNameTextView.text = user.name
            userEmailTextView.text = user.email

            textViewViewDetails.setOnClickListener {
                val context = itemView.context
                val intent = Intent(context, UserDetailsActivity::class.java).apply {
                    putExtra("USER", user)
                }
                context.startActivity(intent)
            }
        }
    }

    class UserDiffCallback : DiffUtil.ItemCallback<User>() {
        override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
            return oldItem == newItem
        }
    }
}
