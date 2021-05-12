package com.marysugar.retrofitsample.api

import com.marysugar.retrofitsample.response.User
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("users")
    fun getUsers(): Call<MutableList<User>>
}