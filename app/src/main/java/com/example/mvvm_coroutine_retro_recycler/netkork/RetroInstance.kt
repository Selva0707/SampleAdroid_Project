package com.example.mvvm_coroutine_retro_recycler.netkork

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetroInstance {

    //https://api.github.com/search/repositories?q=ny

    companion object{
        val BaseURL = "https://api.github.com/search/"

        fun getRetroInstance () : Retrofit {

            return Retrofit.Builder()
                .baseUrl(BaseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }
}