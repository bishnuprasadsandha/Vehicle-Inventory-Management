package com.example.vehicleinventorymanagement.ui.viewmodel.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.example.vehicleinventorymanagement.R
import com.example.vehicleinventorymanagement.data.model.BrandItem

class BrandAdapter(
    context: Context,
    private val brands: List<BrandItem>
) : ArrayAdapter<BrandItem>(context, 0, brands) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        return createItemView(position, convertView, parent)
    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
        return createItemView(position, convertView, parent)
    }

    private fun createItemView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = convertView ?: LayoutInflater.from(context).inflate(R.layout.dropdown_item, parent, false)

        val icon = view.findViewById<ImageView>(R.id.icon)
        val text = view.findViewById<TextView>(R.id.text)
        val radio = view.findViewById<RadioButton>(R.id.radio)

        val brand = brands[position]
        icon.setImageResource(brand.iconResId)
        text.text = brand.name
        radio.visibility = View.GONE // optional

        return view
    }
}