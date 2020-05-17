package com.example.hvaquest.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import com.example.hvaquest.R
import com.example.hvaquest.ui.viewmodel.QuestViewModel
import kotlinx.android.synthetic.main.activity_quest.*
import kotlinx.android.synthetic.main.fragment_question.*

class QuestionFragment : Fragment() {
    private lateinit var questViewModel: QuestViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        questViewModel = ViewModelProviders.of(this).get(QuestViewModel::class.java)
        return inflater.inflate(R.layout.fragment_question, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView() {
        val question = questViewModel.getQuestion()
        txtQuestionTracker.text = getString(
            R.string.question_index,
            questViewModel.getIndexOfQuestion(),
            questViewModel.getQuestionSize()
        )
        txtQuestion.text = question.question
        initRadioButtons(question.choices)
        btnQuest.text = getString(R.string.question_btn_text)

        btnQuest.setOnClickListener { checkIfCorrectAnswer(question.correctAnswer) }
    }

    private fun checkIfCorrectAnswer(correctAnswer: String): Boolean {
        val selectedView = radioGroup.findViewById<RadioButton>(radioGroup.checkedRadioButtonId)
        if (selectedView.text == correctAnswer) {
            Toast.makeText(this.context, R.string.wrong_answer, Toast.LENGTH_SHORT).show()
        }
        return false
    }

    private fun initRadioButtons(choices: Array<String>) {
        var indexForName = 0
        choices.forEach { choice ->
            val rdbtn = RadioButton(this.context)
            rdbtn.text = choice
            radioGroup.addView(rdbtn)
        }
    }
}
