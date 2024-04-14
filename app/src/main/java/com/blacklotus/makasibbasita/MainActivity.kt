package com.blacklotus.makasibbasita

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.navigation.ActivityNavigator
import androidx.navigation.Navigator
import com.blacklotus.makasibbasita.auth.authActivity
import com.blacklotus.makasibbasita.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    @SuppressLint("RestrictedApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val navController = findNavController(R.id.nav_host_fragment_content_main)

        binding.bottomNavigation.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.menu_home -> {
                    // Handle home menu item click

                   var name= navController.currentDestination!!.displayName.replace("com.blacklotus.makasibbasita:id/", "")
                    if (name!= "FirstFragment") {
                        navController.navigate(R.id.action_SecondFragment_to_FirstFragment)

                    }
                    true
                }
                R.id.menu_cart -> {
                    // Handle cart menu item click
                    var name= navController.currentDestination!!.displayName.replace("com.blacklotus.makasibbasita:id/", "")
                    if (name!= "SecondFragment") {
                        navController.navigate(R.id.action_FirstFragment_to_SecondFragment)

                    }
                    true
                }
                R.id.menu_profile -> {
                    var name= navController.currentDestination!!.displayName.replace("com.blacklotus.makasibbasita:id/", "")
                    if (name!= "SecondFragment") {
//                        navController.navigate(R.id.action_FirstFragment_to_SecondFragment)
                        intent = Intent(this, authActivity::class.java)
                        startActivity(intent)

                    }
                    // Handle profile menu item click
                    true
                }
                else -> {
                    false
                }
            }
        }
    }


}