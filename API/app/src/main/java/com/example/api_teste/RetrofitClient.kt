package com.example.api_teste

import android.provider.SyncStateContract
import com.example.api_teste.Constants.Constants_URL
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient private constructor(){

    companion object{

        private lateinit var INSTANCE : Retrofit
        private fun getRetrofitInstance(): Retrofit{

            var httpClient = OkHttpClient.Builder()
            if(!::INSTANCE.isInitialized){
                INSTANCE = Retrofit.Builder()
                    .baseUrl(Constants_URL.URL.MAIN)
                    .client(httpClient.build())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()

            }
            return INSTANCE
        }

        fun <T> createService(serviceClass: Class<T>): T{
            return getRetrofitInstance().create(serviceClass)
        }


    }

}