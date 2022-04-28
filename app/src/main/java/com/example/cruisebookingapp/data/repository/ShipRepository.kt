package com.example.cruisebookingapp.data.repository

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.liveData
import com.example.cruisebookingapp.data.model.Ship
import com.example.cruisebookingapp.data.network.ServiceBuilder
import com.example.cruisebookingapp.data.network.ShipService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Singleton

@Singleton
class ShipRepository(val context : Context) {
    @Singleton
    val shipService : ShipService = ServiceBuilder<ShipService>().buildService(ShipService::class.java)

    fun getShips(): LiveData<List<Ship>> {
        val listofShips : MutableLiveData<List<Ship>> = MutableLiveData()
        val shipCall: Call<List<Ship>> = shipService.listShip()
        shipCall.enqueue(object : Callback<List<Ship>> {
            override fun onResponse(call: Call<List<Ship>>, response: Response<List<Ship>>) {
                if(response.code() == 200) {
                    listofShips.value = response.body() ?: listOf()
                } else {
                    Toast.makeText(context, "WARNING : ${response.message()}", Toast.LENGTH_LONG).show()
                }
            }
            override fun onFailure(call: Call<List<Ship>>, t: Throwable) {
                Toast.makeText(context, "Error : ${t.message}", Toast.LENGTH_LONG).show()
            }

        })
        return listofShips
    }

    fun getShipById(id : String) : LiveData<Ship?> {
        val _ship : MutableLiveData<Ship?> = MutableLiveData()
        val shipCall : Call<Ship> = shipService.getShip(id)
        shipCall.enqueue(object : Callback<Ship> {
            override fun onResponse(call: Call<Ship>, response: Response<Ship>) {
                if(response.code() == 200) {
                    _ship.value = response.body()
                } else {
                    Toast.makeText(context, "WARNING : ${response.message()}", Toast.LENGTH_LONG).show()
                }
            }

            override fun onFailure(call: Call<Ship>, t: Throwable) {
                Toast.makeText(context, "Error : ${t.message}", Toast.LENGTH_LONG).show()
            }
        })
        return _ship
    }
}