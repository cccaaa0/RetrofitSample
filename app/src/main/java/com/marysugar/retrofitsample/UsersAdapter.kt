package com.marysugar.retrofitsample

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.marysugar.retrofitsample.response.User
import org.w3c.dom.Text

class UsersAdapter(private val context: Context, private var list: MutableList<User>) :
    RecyclerView.Adapter<UsersAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsersAdapter.ViewHolder {
        val inflater = LayoutInflater.from(context)
        val view: View = inflater.inflate(R.layout.item_row, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val user = list[position]
        holder.name?.text = user.name
        val info1 = user.userName + " | " + user.email
        holder.info1?.text = info1
        val info2 = user.phone + "|" + user.webSite
        holder.info2?.text = info2
        val address = user.addressObject?.let {
            it.suite + it.street + it.city + it.zipCode
        }
        holder.address?.text = address

    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var name: TextView? = null
        var info1: TextView? = null
        var info2: TextView? = null
        var address: TextView? = null

        init {
            name = view.findViewById(R.id.tv_user_name)
            info1 = view.findViewById(R.id.tv_user_info1)
            info2 = view.findViewById(R.id.tv_user_info2)
            address = view.findViewById(R.id.tv_user_address)
        }

    }
}