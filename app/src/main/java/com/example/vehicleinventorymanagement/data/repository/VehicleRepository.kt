package com.example.vehicleinventorymanagement.data.repository

import com.example.vehicleinventorymanagement.data.model.Vehicle
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow

class VehicleRepository {

    private val _vehicles = MutableStateFlow<List<Vehicle>>(emptyList())

    val allVehicles: Flow<List<Vehicle>> = _vehicles

    suspend fun insert(vehicle: Vehicle) {
        val currentList = _vehicles.value.toMutableList()
        currentList.add(vehicle)
        _vehicles.value = currentList
    }
}
