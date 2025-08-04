package com.example.vehicleinventorymanagement

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.vehicleinventorymanagement.data.model.FilterOption
import com.example.vehicleinventorymanagement.databinding.FilterBottomSheetBinding
import com.example.vehicleinventorymanagement.ui.adapter.FilterOptionAdapter
import com.example.vehicleinventorymanagement.ui.viewmodel.FilterViewModel
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class FilterBottomSheet : BottomSheetDialogFragment() {

    private var _binding: FilterBottomSheetBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: FilterViewModel
    private lateinit var filterOptionAdapter: FilterOptionAdapter

    private val selectedOptions = mutableSetOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Initialize ViewModel manually
        viewModel = ViewModelProvider(this).get(FilterViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FilterBottomSheetBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Close button
        binding.btnClose.setOnClickListener { dismiss() }

        // Initialize adapter with lambda for checkbox changes
        filterOptionAdapter = FilterOptionAdapter { option, isChecked ->
            if (isChecked) selectedOptions.add(option.name)
            else selectedOptions.remove(option.name)
        }


        binding.rvFilterOptions.adapter = filterOptionAdapter
        binding.rvFilterOptions.layoutManager = LinearLayoutManager(requireContext())

        // Observe brands and update adapter list by default
        viewModel.brands.observe(viewLifecycleOwner) { brands ->
            val filterOptions = brands?.map { brand ->
                FilterOption(name = brand.name, iconRes = R.drawable.ic_placeholder, isSelected = false)

            } ?: emptyList()
            filterOptionAdapter.submitList(filterOptions)
        }

        binding.tvBrand.setOnClickListener {
            val brands = viewModel.brands.value
            val filterOptions = brands?.map { brand ->
                FilterOption(name = brand.name, iconRes = R.drawable.ic_placeholder, isSelected = false)

            } ?: emptyList()
            filterOptionAdapter.submitList(filterOptions)
            highlightCategory("brand")
        }

        binding.tvFuelType.setOnClickListener {
            val fuels = viewModel.fuelTypes.value
            val filterOptions = fuels?.map { fuel ->
                FilterOption(name = fuel.name, iconRes = R.drawable.ic_placeholder, isSelected = false)
            } ?: emptyList()

            filterOptionAdapter.submitList(filterOptions)
            highlightCategory("fuel")
        }


        // Clear selections
        binding.btnClearAll.setOnClickListener {
            selectedOptions.clear()
            filterOptionAdapter.clearSelections()
        }

        // Apply selections
        binding.btnApply.setOnClickListener {
            // TODO: Pass selectedOptions back to parent fragment or activity as needed
            dismiss()
        }

        // Highlight default category tab
        highlightCategory("brand")
    }

    private fun highlightCategory(selected: String) {
        val selectedColor = ContextCompat.getColor(requireContext(), R.color.blue_1B60FF)
        val defaultColor = ContextCompat.getColor(requireContext(), android.R.color.black)

        binding.tvBrand.setTextColor(if (selected == "brand") selectedColor else defaultColor)
        binding.tvFuelType.setTextColor(if (selected == "fuel") selectedColor else defaultColor)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}