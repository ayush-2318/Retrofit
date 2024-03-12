package com.example.retrofit

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofit.data.sampleJsonDataModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PostsViewModel(
    private  val repo: Repo
):ViewModel() {
    val postLiveData=MutableLiveData<sampleJsonDataModel>()
    init {
        getAllPosts()
    }
    fun getAllPosts(){
        viewModelScope.launch (Dispatchers.IO){
            val response=repo.getAllPosts()
            if(response.isSuccessful){
                postLiveData.postValue(response.body())
            }
        }
    }
}