package com.example.hvaquest.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.lifecycle.ViewModelProviders
import com.example.hvaquest.R
import com.example.hvaquest.ui.Quest
import com.example.hvaquest.ui.viewmodel.QuestViewModel
import kotlinx.android.synthetic.main.activity_quest.*

class QuestCompleted : Fragment() {
    private lateinit var questViewModel: QuestViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        questViewModel = ViewModelProviders.of(activity as Quest).get(QuestViewModel::class.java)
        return inflater.inflate(R.layout.fragment_quest_completed, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView() {
        val buttonQuest = activity?.findViewById<Button>(R.id.btnQuest)
        buttonQuest?.text = getString(R.string.completed_btn_finish)
        buttonQuest?.setOnClickListener { activity?.finish() }
    }
}
