package com.example.cruisebookingapp.data.network

import androidx.lifecycle.LiveData
import com.example.cruisebookingapp.data.model.Ship
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ShipService {
    @GET("ships")
    fun listShip() : Call<List<Ship>>

    @GET("ship/{id}")
    fun getShip(@Path("id") _id : String) : Call<Ship>
}