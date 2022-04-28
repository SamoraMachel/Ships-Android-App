package com.example.cruisebookingapp.data.model

data class Ship (
    val ship_id : String,
    val ship_name : String,
    val ship_model : String?,
    val ship_type : String,
    val roles : List<String>,
    val active : Boolean,
    val weight_kg : Int,
    val home_port : String,
    val year_built : Int,
    val image : String,
) {}