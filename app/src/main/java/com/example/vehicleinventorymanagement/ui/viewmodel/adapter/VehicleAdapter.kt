package com.example.vehicleinventorymanagement.ui.viewmodel.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.vehicleinventorymanagement.R
import com.example.vehicleinventorymanagement.data.model.Vehicle
import java.util.Calendar

class VehicleAdapter(private var vehicles: List<Vehicle>) :
    RecyclerView.Adapter<VehicleAdapter.VehicleViewHolder>() {

    // Update the list and notify adapter
    fun updateVehicles(newVehicles: List<Vehicle>) {
        vehicles = newVehicles
        notifyDataSetChanged()
    }

    class VehicleViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvModel: TextView = view.findViewById(R.id.tvModel)
        val tvBrand: TextView = view.findViewById(R.id.tvBrand)
        val tvVehicleNumber: TextView = view.findViewById(R.id.tvVehicleNumber)
        val tvFuelType: TextView = view.findViewById(R.id.tvFuelType)
        val tvYear: TextView = view.findViewById(R.id.tvYear)
        val tvDuration: TextView = view.findViewById(R.id.tvDuration)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VehicleViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_vehicle, parent, false)
        return VehicleViewHolder(view)
    }

    override fun onBindViewHolder(holder: VehicleViewHolder, position: Int) {
        val v = vehicles[position]
        holder.tvModel.text = v.model
        holder.tvBrand.text = v.brand
        holder.tvVehicleNumber.text = v.vehicleNumber
        holder.tvFuelType.text = v.fuelType
        holder.tvYear.text = v.purchaseYear.toString()
        holder.tvDuration.text = getDurationText(v.purchaseYear)
    }

    override fun getItemCount(): Int = vehicles.size

    private fun getDurationText(purchaseYear: Int): String {
        val now = Calendar.getInstance()
        val currentYear = now.get(Calendar.YEAR)
        val yearDiff = currentYear - purchaseYear
        return "$yearDiff years"
    }
}