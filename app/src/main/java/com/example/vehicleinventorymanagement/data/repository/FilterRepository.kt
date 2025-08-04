package com.example.vehicleinventorymanagement.data.repository

import com.example.vehicleinventorymanagement.R
import com.example.vehicleinventorymanagement.data.model.FilterOption

class FilterRepository {

    fun getBrands(): List<FilterOption> {
        return listOf(
            FilterOption("Tata", R.drawable.tata),
            FilterOption("Honda", R.drawable.honda),
            FilterOption("Hero", R.drawable.hero),
            FilterOption("Bajaj", R.drawable.bajaj),
            FilterOption("Yamaha", R.drawable.yamaha),
            FilterOption("Other", R.drawable.ic_placeholder)
        )
    }

    fun getFuelTypes(): List<FilterOption> {
        return listOf(
            FilterOption("Petrol", R.drawable.ic_placeholder),
            FilterOption("Electric", R.drawable.ic_placeholder),
            FilterOption("Diesel", R.drawable.ic_placeholder),
            FilterOption("CNG", R.drawable.ic_placeholder)
        )
    }
}