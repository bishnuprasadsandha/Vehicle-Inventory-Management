package com.example.vehicleinventorymanagement.ui.viewmodel.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.vehicleinventorymanagement.R
import com.example.vehicleinventorymanagement.data.model.FilterOption

class VehicleBrandAdapter(
    private val items: List<FilterOption>,
    private val onItemSelected: (FilterOption) -> Unit
) : RecyclerView.Adapter<VehicleBrandAdapter.BrandViewHolder>() {

    private var selectedPosition = RecyclerView.NO_POSITION

    inner class BrandViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val icon: ImageView = view.findViewById(R.id.brandIcon)
        val name: TextView = view.findViewById(R.id.brandName)

        init {
            view.setOnClickListener {
                val previousPosition = selectedPosition
                selectedPosition = adapterPosition
                notifyItemChanged(previousPosition)
                notifyItemChanged(selectedPosition)

                onItemSelected(items[selectedPosition])
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BrandViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_vehicle_brand, parent, false)
        return BrandViewHolder(view)
    }

    override fun onBindViewHolder(holder: BrandViewHolder, position: Int) {
        val item = items[position]
        holder.name.text = item.name
        holder.icon.setImageResource(item.iconRes) // iconRes is an Int resource id in FilterOption

        // Highlight selected item background (optional)
        holder.itemView.isSelected = (position == selectedPosition)
    }

    override fun getItemCount(): Int = items.size
}