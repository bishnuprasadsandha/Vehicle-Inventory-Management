package com.example.vehicleinventorymanagement.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

data class Brand(val name: String)
data class FuelType(val name: String)

class FilterViewModel : ViewModel() {

    // Sample data - replace with real data from repository
    private val _brands = MutableLiveData<List<Brand>>(listOf(
        Brand("Tata"), Brand("Honda"), Brand("Hero"), Brand("Bajaj"), Brand("Yamaha"), Brand("Other")
    ))
    val brands: LiveData<List<Brand>> = _brands

    private val _fuelTypes = MutableLiveData<List<FuelType>>(listOf(
        FuelType("Petrol"), FuelType("Electric"), FuelType("Diesel"), FuelType("CNG")
    ))
    val fuelTypes: LiveData<List<FuelType>> = _fuelTypes
}