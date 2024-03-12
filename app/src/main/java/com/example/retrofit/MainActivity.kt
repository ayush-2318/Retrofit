package com.example.retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.example.retrofit.data.ReterofitInstances

class MainActivity : AppCompatActivity() {
    private  lateinit var postsViewModel: PostsViewModel
    private lateinit var postViewModelFactory: PostViewModelFactory
    private lateinit var repo: Repo
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
        postsViewModel.postLiveData.observe(this){
            // perform action with data
            Log.i("postlivedata",it.toString())
        }
    }
    private fun init(){
        repo= Repo(ReterofitInstances.getReterofitInstance())
        postViewModelFactory= PostViewModelFactory(repo)
        postsViewModel=ViewModelProvider(this,postViewModelFactory).get(PostsViewModel::class.java)
    }
}