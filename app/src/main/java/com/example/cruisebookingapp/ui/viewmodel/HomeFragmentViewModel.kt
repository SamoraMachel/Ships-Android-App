package com.example.cruisebookingapp.ui.viewmodel

import android.app.Application
import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.cruisebookingapp.data.model.Ship
import com.example.cruisebookingapp.data.repository.ShipRepository

class HomeFragmentViewModel : ViewModel() {

    fun getShipList(context : Context) : List<Ship> = ShipRepository(context).getShips()
}