package com.example.hvaquest.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import com.example.hvaquest.R
import com.example.hvaquest.ui.viewmodel.QuestViewModel
import kotlinx.android.synthetic.main.activity_quest.*


/**
 * A simple [Fragment] subclass.
 * Use the [QuestCompleted.newInstance] factory method to
 * create an instance of this fragment.
 */
class QuestCompleted : Fragment() {
    private lateinit var questViewModel: QuestViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        questViewModel = ViewModelProviders.of(this).get(QuestViewModel::class.java)
        return inflater.inflate(R.layout.fragment_quest_completed, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView() {
        btnQuest.text = getString(R.string.completed_btn_finish)
    }

}
