package com.example.vehicleinventorymanagement

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.vehicleinventorymanagement.data.model.BrandItem
import com.example.vehicleinventorymanagement.data.model.VehicleModel
import com.example.vehicleinventorymanagement.data.model.FuelType
import com.example.vehicleinventorymanagement.ui.viewmodel.adapter.VehicleModelAdapter
import com.example.vehicleinventorymanagement.ui.viewmodel.adapter.FuelTypeAdapter
import com.example.vehicleinventorymanagement.ui.viewmodel.adapter.BrandAdapter
import com.example.vehicleinventorymanagement.databinding.ActivityAddVehicleBinding

class AddVehicleActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddVehicleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityAddVehicleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Apply system bar insets
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val brandItems = listOf(
            BrandItem("Honda", R.drawable.honda),
            BrandItem("Tata", R.drawable.tata),
            BrandItem("Bajaj", R.drawable.bajaj),
            BrandItem("Yamaha", R.drawable.yamaha),
            BrandItem("Hero", R.drawable.hero)
        )
        val brandAdapter = BrandAdapter(this, brandItems)
        binding.autoCompleteBrand.setAdapter(brandAdapter)

        val models = listOf(
            VehicleModel("Activa 4G"),
            VehicleModel("Activa 5G"),
            VehicleModel("Activa 6G"),
            VehicleModel("Activa 125"),
            VehicleModel("Activa 125 BS6"),
            VehicleModel("Activa H-Smart")
        )
        val modelAdapter = VehicleModelAdapter(this, models)
        binding.autoCompleteModel.setAdapter(modelAdapter)
        binding.autoCompleteModel.setOnItemClickListener { _, _, position, _ ->
            modelAdapter.selectedPosition = position
            modelAdapter.notifyDataSetChanged()
        }

        val fuels = listOf(
            FuelType("Petrol"),
            FuelType("Electric"),
            FuelType("Diesel"),
            FuelType("CNG")
        )
        val fuelAdapter = FuelTypeAdapter(this, fuels)
        binding.autoCompleteFuelType.setAdapter(fuelAdapter)
        binding.autoCompleteFuelType.setOnItemClickListener { _, _, position, _ ->
            fuelAdapter.selectedPosition = position
            fuelAdapter.notifyDataSetChanged()
        }

        binding.ivBack.setOnClickListener {
            finish()
        }
    }
}