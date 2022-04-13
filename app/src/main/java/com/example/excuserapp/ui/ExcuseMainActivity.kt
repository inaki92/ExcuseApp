package com.example.excuserapp.ui

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.excuserapp.R
import com.example.excuserapp.databinding.ActivityExcuseMainBinding

class ExcuseMainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityExcuseMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityExcuseMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_excuse_main)
        navView.setupWithNavController(navController)
    }
}