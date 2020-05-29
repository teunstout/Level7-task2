package com.example.hvaquest.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.hvaquest.R
import com.example.hvaquest.ui.Quest
import com.example.hvaquest.ui.viewmodel.QuestViewModel
import kotlinx.android.synthetic.main.fragment_location_clue.*

class LocationClueFragment : Fragment() {
    private lateinit var questViewModel: QuestViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        questViewModel = ViewModelProvider(activity as Quest).get(QuestViewModel::class.java)

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_location_clue, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initView()
        super.onViewCreated(view, savedInstanceState)
    }

    private fun initView() {
        imgCompleted.setImageResource(questViewModel.getQuestion().clue)
        val buttonQuest = activity?.findViewById<Button>(R.id.btnQuest)
        buttonQuest?.text = getString(R.string.clue_btn_next)
        buttonQuest?.setOnClickListener {
            findNavController().navigate(R.id.questionFragment)
        }
    }
}
