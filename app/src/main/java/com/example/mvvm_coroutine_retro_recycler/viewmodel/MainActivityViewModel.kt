package com.example.mvvm_coroutine_retro_recycler.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
 import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import com.example.mvvm_coroutine_retro_recycler.models.RecyclerList
import com.example.mvvm_coroutine_retro_recycler.netkork.RetroInstance
import com.example.mvvm_coroutine_retro_recycler.netkork.RetroService
import kotlinx.coroutines.Dispatchers
import retrofit2.http.Query

class MainActivityViewModel : ViewModel() {
    lateinit var recyclerListLiveData : MutableLiveData<RecyclerList>

    init {
        recyclerListLiveData = MutableLiveData()
    }

    fun getRecyclerListObserver() : MutableLiveData<RecyclerList> {

        return  recyclerListLiveData
    }

    fun makeApicall() {

        viewModelScope.launch(Dispatchers.IO){

          val retroInstance =  RetroInstance.getRetroInstance().create(RetroService::class.java)
          val response  =  retroInstance.getDataFromAPI("ny")
            recyclerListLiveData.postValue(response)
        }

    }
}