package com.example.cruisebookingapp.data.network

import com.example.cruisebookingapp.API_BASE_URL
import retrofit2.Retrofit

class ServiceBuilder<T> {
    fun buildService(serviceType : Class<T> ) : T {


        val retrofit : Retrofit = Retrofit.Builder()
            .baseUrl(API_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofit.create(serviceType)
    }
}