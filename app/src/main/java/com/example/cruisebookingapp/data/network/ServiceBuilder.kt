package com.example.cruisebookingapp.data.network

import com.example.cruisebookingapp.API_BASE_URL
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ServiceBuilder<T> {
    fun buildService(serviceType : Class<T> ) : T {
        val okHttp = OkHttpClient.Builder() //                .addInterceptor(logger)
            .addInterceptor { chain ->
                var request = chain.request()
                request = request.newBuilder()
                    .build()
                chain.proceed(request)
            }

        val retrofit : Retrofit = Retrofit.Builder()
            .baseUrl(API_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttp.build())
            .build()


        return retrofit.create(serviceType)
    }
}