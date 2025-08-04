package com.example.vehicleinventorymanagement.data.model

data class BrandItem(val name: String, val iconResId: Int) {
    override fun toString(): String = name
}