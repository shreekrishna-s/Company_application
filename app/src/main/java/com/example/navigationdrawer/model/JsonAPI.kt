package com.example.navigationdrawer.model

import retrofit2.Call
import retrofit2.http.GET


interface JsonAPI {
    @GET("users")
    fun getEmployees(): Call<List<Employee>>
}