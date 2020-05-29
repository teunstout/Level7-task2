package com.example.hvaquest.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI

import com.example.hvaquest.R
import com.example.hvaquest.ui.viewmodel.QuestViewModel

class Quest : AppCompatActivity() {
    private lateinit var questViewModel: QuestViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quest)
        questViewModel = ViewModelProvider(this).get(QuestViewModel::class.java)
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
                questViewModel.previousQuestion()
                navController.navigateUp()
                return true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

}
