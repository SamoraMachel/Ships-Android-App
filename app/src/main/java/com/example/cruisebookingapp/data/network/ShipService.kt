package com.example.cruisebookingapp.data.network

import com.example.cruisebookingapp.data.model.Ship
import retrofit2.Call
import retrofit2.http.GET

interface ShipService {
    @GET("ships")
    fun listShip() : Call<List<Ship>>

}