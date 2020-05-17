package com.example.hvaquest.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.hvaquest.R


/**
 * A simple [Fragment] subclass.
 * Use the [QuestCompleted.newInstance] factory method to
 * create an instance of this fragment.
 */
class QuestCompleted : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        initView()

        return inflater.inflate(R.layout.fragment_quest_completed, container, false)
    }

    private fun initView() {

    }

}
