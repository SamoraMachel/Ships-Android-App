package com.example.cruisebookingapp.ui.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.cruisebookingapp.data.model.Ship
import com.example.cruisebookingapp.data.repository.ShipRepository

class HomeFragmentViewModel(context : Context) : ViewModel() {

    var shipList : List<Ship> = ShipRepository(context).getShips()
}