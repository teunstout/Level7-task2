package com.example.hvaquest.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI

import com.example.hvaquest.R
import com.example.hvaquest.ui.viewmodel.QuestViewModel

class Quest : AppCompatActivity() {
    private val questViewModel: QuestViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quest)
        actionBar?.setDisplayHomeAsUpEnabled(true)
        initNavigation()
    }

    private fun initNavigation() {
        // The NavController
        val navigation = findNavController(R.id.navHostFragment)

        // Connect the navHostFragment with the ActionBar.
        val appBarConfiguration = AppBarConfiguration(navigation.graph)
        NavigationUI.setupActionBarWithNavController(this, navigation, appBarConfiguration)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        val navController = findNavController(R.id.navHostFragment)
        return when (item?.itemId) {
            android.R.id.home -> {
                if (questViewModel.getIndex() == 0) {
                    AlertDialog.Builder(this)
                        .setTitle("Do you want to quit?")
                        .setMessage("Do you want to quit and go back to the home screen?")
                        .setPositiveButton("Yes") { dialog, which ->
                            finish()
                        }
                        .setNegativeButton("No", null)
                        .show()
                } else {
                    questViewModel.previousQuestion()
                    navController.navigateUp()
                }
                return false // true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

}
