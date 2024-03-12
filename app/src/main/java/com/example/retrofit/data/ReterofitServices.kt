package com.example.retrofit.data

import retrofit2.Response
import retrofit2.http.GET

interface ReterofitServices {
    @GET("/posts")
    suspend fun getAllData():Response<sampleJsonDataModel>
}