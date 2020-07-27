package com.arpit.catfactsapp


import retrofit2.Call
import retrofit2.http.GET

interface ApiRequest {

    @GET("/facts/random")
    fun getCatFacts(): Call<Response>
}