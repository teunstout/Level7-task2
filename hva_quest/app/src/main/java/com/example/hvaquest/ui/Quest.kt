package com.example.hvaquest.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders

import com.example.hvaquest.R
import com.example.hvaquest.ui.viewmodel.QuestViewModel

class Quest : AppCompatActivity() {
    private lateinit var questViewModel: QuestViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quest)
        questViewModel = ViewModelProviders.of(this).get(QuestViewModel::class.java)
    }
}
