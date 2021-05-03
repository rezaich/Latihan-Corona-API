package com.example.apicorona

import retrofit2.Call
import retrofit2.http.*

interface ApiInterface {
    @GET("/indonesia")
    fun getDatas(): Call<ArrayList<CoronaModel>>
}