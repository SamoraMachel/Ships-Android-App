package com.example.cruisebookingapp.data.repository

import android.content.Context
import android.widget.Toast
import com.example.cruisebookingapp.data.model.Ship
import com.example.cruisebookingapp.data.network.ServiceBuilder
import com.example.cruisebookingapp.data.network.ShipService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Singleton

@Singleton
class ShipRepository(val context : Context) {
    fun getShips(): List<Ship> {
        var listofShips : List<Ship> = mutableListOf()
        val shipService : ShipService = ServiceBuilder<ShipService>().buildService(ShipService::class.java)
        val shipCall: Call<List<Ship>> = shipService.listShip()
        shipCall.enqueue(object : Callback<List<Ship>> {
            override fun onResponse(call: Call<List<Ship>>, response: Response<List<Ship>>) {
                if(response.code() == 200) {
                    listofShips = response.body()?: mutableListOf()
                } else {
                    Toast.makeText(context, "Error : ${response.message()}", Toast.LENGTH_LONG).show()
                }
            }

            override fun onFailure(call: Call<List<Ship>>, t: Throwable) {
                Toast.makeText(context, "Error : ${t.message}", Toast.LENGTH_LONG).show()
            }
        })
        return listofShips
    }
}