package com.example.vehicleinventorymanagement

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.vehicleinventorymanagement.data.model.Vehicle
import com.example.vehicleinventorymanagement.databinding.ActivityMainBinding
import com.example.vehicleinventorymanagement.ui.viewmodel.adapter.VehicleAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var vehicleAdapter: VehicleAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Enable edge-to-edge layout
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        setupRecyclerView()

        binding.btnFilter.setOnClickListener {
            val filterBottomSheet = FilterBottomSheet()
            filterBottomSheet.show(supportFragmentManager, "FilterBottomSheet")
        }

        binding.fabAddVehicle.setOnClickListener {
            val intent = Intent(this, AddVehicleActivity::class.java)
            startActivity(intent)
        }
    }

    private fun setupRecyclerView() {
        val sampleVehicles = listOf(
            Vehicle("Activa 4G", "Honda", "KA 01 AA 0007", "Petrol", 2018, "Rahul"),
            Vehicle("Nexon XM", "Tata", "KA 10 AM 2323", "Petrol", 2021, "Amit"),
            Vehicle("Activa 125", "Honda", "DL 8 CAF 9876", "Petrol", 2020, "Sneha"),
            Vehicle("City VX", "Honda", "TN 22 CZ 3344", "Petrol", 2022, "Vikram"),
            Vehicle("Pulsar 150", "Bajaj", "UP 32 KT 1098", "Petrol", 2022, "Anjali")
        )

        vehicleAdapter = VehicleAdapter(sampleVehicles)

        binding.rvVehicles.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = vehicleAdapter
        }
    }
}