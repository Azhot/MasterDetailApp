package com.example.masterdetailapp

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.example.masterdetailapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), NavController.OnDestinationChangedListener {

    // variables
    // using View Binding
    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController


    // overridden functions
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initVariables()
        navController.addOnDestinationChangedListener(this)
        setContentView(binding.root)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            // action when user clicks home button
            android.R.id.home -> onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onDestinationChanged(
        controller: NavController,
        destination: NavDestination,
        arguments: Bundle?
    ) {
        // displaying back button only in detail fragment and when in portrait configuration
        when (destination.id) {
            R.id.detailFragment -> {
                supportActionBar?.setHomeButtonEnabled(!resources.getBoolean(R.bool.isLandscape))
                supportActionBar?.setDisplayHomeAsUpEnabled(!resources.getBoolean(R.bool.isLandscape))
            }
            else -> {
                supportActionBar?.setHomeButtonEnabled(false)
                supportActionBar?.setDisplayHomeAsUpEnabled(false)
            }
        }
    }


    // functions
    private fun initVariables() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        val navHostFragment =
            supportFragmentManager.findFragmentById(binding.mainFragmentContainer.id)
                    as NavHostFragment
        navController = navHostFragment.findNavController()
    }
}