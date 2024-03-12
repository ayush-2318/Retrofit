package com.example.retrofit.data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ReterofitInstances {
    companion object{
        var reterofitServices: ReterofitServices?=null
        fun getReterofitInstance(): ReterofitServices {
            if(reterofitServices ==null){
                reterofitServices =Retrofit.Builder()
                    .baseUrl("https://dummyjson.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(ReterofitServices::class.java)
            }
            return reterofitServices!!
        }
    }
}