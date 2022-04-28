package com.example.cruisebookingapp.ui.viewmodel

import android.app.Application
import android.content.Context
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.cruisebookingapp.data.model.Ship
import com.example.cruisebookingapp.data.repository.ShipRepository

class HomeFragmentViewModel : ViewModel() {

    fun getShipList(context : Context) : LiveData<List<Ship>> {
        Toast.makeText(context, "API called", Toast.LENGTH_LONG).show()
        return ShipRepository(context).getShips()
    }
}
