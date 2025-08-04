package com.example.vehicleinventorymanagement.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.CompoundButton
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.vehicleinventorymanagement.data.model.FilterOption
import com.example.vehicleinventorymanagement.databinding.ItemFilterOptionBinding

class FilterOptionAdapter(
    private val onCheckedChange: (FilterOption, Boolean) -> Unit
) : ListAdapter<FilterOption, FilterOptionAdapter.FilterOptionViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilterOptionViewHolder {
        val binding = ItemFilterOptionBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FilterOptionViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FilterOptionViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    fun clearSelections() {
        currentList.forEach { it.isSelected = false }
        notifyDataSetChanged()
    }

    inner class FilterOptionViewHolder(private val binding: ItemFilterOptionBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(option: FilterOption) {
            binding.tvOptionName.text = option.name   // set text to TextView
            binding.checkbox.setOnCheckedChangeListener(null)
            binding.checkbox.isChecked = option.isSelected
            binding.checkbox.setOnCheckedChangeListener { _: CompoundButton, isChecked: Boolean ->
                option.isSelected = isChecked
                onCheckedChange(option, isChecked)
            }
        }
    }

    class DiffCallback : DiffUtil.ItemCallback<FilterOption>() {
        override fun areItemsTheSame(oldItem: FilterOption, newItem: FilterOption): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: FilterOption, newItem: FilterOption): Boolean {
            return oldItem == newItem
        }
    }
}
