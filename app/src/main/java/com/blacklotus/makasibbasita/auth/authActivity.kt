package com.blacklotus.makasibbasita.auth

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import com.blacklotus.makasibbasita.R
import com.blacklotus.makasibbasita.databinding.ActivityAuthBinding

class authActivity :AppCompatActivity() {

            private lateinit var appBarConfiguration: AppBarConfiguration
            private lateinit var binding: ActivityAuthBinding

            override fun onCreate(savedInstanceState: Bundle?) {
                WindowCompat.setDecorFitsSystemWindows(window, false)
                super.onCreate(savedInstanceState)
                binding = ActivityAuthBinding.inflate(layoutInflater)
                setContentView(binding.root)
                val navController = findNavController(R.id.nav_host_fragment_content_auth)
                appBarConfiguration = AppBarConfiguration(navController.graph)



            }

        }