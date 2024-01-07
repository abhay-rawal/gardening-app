package com.example.gardeningjournalapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI

class MainActivity : AppCompatActivity() {
    private lateinit var mnavController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        mnavController = navHostFragment.navController

        NavigationUI.setupActionBarWithNavController(this, mnavController);
    }

    override fun onSupportNavigateUp(): Boolean {
        return mnavController.navigateUp()
    }
}