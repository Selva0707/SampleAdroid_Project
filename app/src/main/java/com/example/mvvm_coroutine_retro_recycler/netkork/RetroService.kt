package com.example.mvvm_coroutine_retro_recycler.netkork

import com.example.mvvm_coroutine_retro_recycler.models.RecyclerList
import retrofit2.http.GET
import retrofit2.http.Query

interface RetroService {

    //because of using coroutines we have to use suspand fun
    @GET("repositories")
    suspend fun getDataFromAPI(@Query ("q") query: String) : RecyclerList
}