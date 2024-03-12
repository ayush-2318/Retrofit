package com.example.retrofit

import com.example.retrofit.data.ReterofitServices

class Repo (
    private val reterofitServices: ReterofitServices
){
    suspend fun getAllPosts()= reterofitServices.getAllData()
}