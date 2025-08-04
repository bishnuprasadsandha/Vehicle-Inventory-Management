package com.example.vehicleinventorymanagement.ui.viewmodel.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.RadioButton
import android.widget.TextView
import com.example.vehicleinventorymanagement.R
import com.example.vehicleinventorymanagement.data.model.FuelType

class FuelTypeAdapter(
    context: Context,
    private val fuelTypes: List<FuelType>
) : ArrayAdapter<FuelType>(context, 0, fuelTypes) {

    var selectedPosition = -1

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = LayoutInflater.from(context).inflate(android.R.layout.simple_spinner_item, parent, false)
        val textView = view.findViewById<TextView>(android.R.id.text1)
        textView.text = fuelTypes[position].name
        return view
    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = LayoutInflater.from(context).inflate(R.layout.dropdown_item, parent, false)
        val text = view.findViewById<TextView>(R.id.text)
        val radio = view.findViewById<RadioButton>(R.id.radio)

        text.text = fuelTypes[position].name
        radio.isChecked = position == selectedPosition

        return view
    }
}