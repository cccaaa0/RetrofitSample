package com.marysugar.retrofitsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.marysugar.retrofitsample.api.ApiClient
import com.marysugar.retrofitsample.response.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private var listUsers: MutableList<User> = mutableListOf()
    private lateinit var adapter: UsersAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerMain = findViewById<RecyclerView>(R.id.recycler_main)
        recyclerMain.layoutManager = LinearLayoutManager(this@MainActivity)

        adapter = UsersAdapter(
            this,
            listUsers
        )
        recyclerMain.adapter = adapter

        getUsersData()
    }

    private fun getUsersData() {
        ApiClient.apiService.getUsers().enqueue(object : Callback<MutableList<User>> {
            override fun onFailure(call: Call<MutableList<User>>, t: Throwable) {
            }

            override fun onResponse(
                call: Call<MutableList<User>>,
                response: Response<MutableList<User>>
            ) {
                val usersResponse = response.body()
                listUsers.clear()
                usersResponse?.let { listUsers.addAll(it) }
                adapter.notifyDataSetChanged()
            }
        })
    }
}