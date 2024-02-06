package com.miu.gardeningjournal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI

class MainActivity : AppCompatActivity() {

    // Declare Navigation Controller Object
    private lateinit var mnavController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Find the Toolbar by its ID
        val toolbar = findViewById<Toolbar>(R.id.toolbar)

        // Set the Toolbar as the support ActionBar
        setSupportActionBar(toolbar)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        mnavController = navHostFragment.navController
        // Code to link the navigation controller to the app bar
        NavigationUI.setupActionBarWithNavController(this, mnavController)
    }

    // override the onSupportNavigateUp() method to call  navigateUp() in the navigation controller
    override fun onSupportNavigateUp(): Boolean {
        return mnavController.navigateUp()
    }
}

