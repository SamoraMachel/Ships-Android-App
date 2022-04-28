package com.example.cruisebookingapp.ui.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.cruisebookingapp.data.model.Ship
import com.example.cruisebookingapp.data.repository.ShipRepository

class BottomFragmentViewModel : ViewModel() {

    fun getShip(context : Context, id : String) : LiveData<Ship?> = ShipRepository(context).getShipById(id)
}