package com.example.vehicleinventorymanagement.data.model

data class FilterOption(
    val name: String,
    val iconRes: Int,
    var isSelected: Boolean = false
)