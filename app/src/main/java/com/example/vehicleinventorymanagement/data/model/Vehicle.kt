package com.example.vehicleinventorymanagement.data.model


data class Vehicle(
    val model: String,
    val brand: String,
    val vehicleNumber: String,
    val fuelType: String,
    val purchaseYear: Int,
    val ownerName: String
)