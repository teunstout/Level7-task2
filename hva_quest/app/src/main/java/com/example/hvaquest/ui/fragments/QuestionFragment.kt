package com.example.hvaquest.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioButton
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.hvaquest.R
import com.example.hvaquest.ui.Quest
import com.example.hvaquest.ui.viewmodel.QuestViewModel
import kotlinx.android.synthetic.main.fragment_question.*

class QuestionFragment : Fragment() {
    private val questViewModel: QuestViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_question, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView() {
        val buttonQuest = activity?.findViewById<Button>(R.id.btnQuest)
        val question = questViewModel.getQuestion()
        val trackerText = "${questViewModel.getWhichQuestion()}/${questViewModel.getQuestionSize()}"

        buttonQuest?.text = getString(R.string.clue_btn_next)
        txtQuestionTracker.text = trackerText
        txtQuestion.text = question.question
        initRadioButtons(question.choices)
        buttonQuest?.text = getString(R.string.question_btn_text)

        buttonQuest?.setOnClickListener {
            if (checkIfCorrectAnswer(question.correctAnswer)) {
                questViewModel.nextQuestion()
                if (questViewModel.checkNoMoreQuestions()) {
                    findNavController().navigate(R.id.questCompleted)
                } else {
                    findNavController().navigate(R.id.locationClueFragment)
                }
            }
        }
    }

    private fun checkIfCorrectAnswer(correctAnswer: String): Boolean {
        val selectedView = radioGroup.findViewById<RadioButton>(radioGroup.checkedRadioButtonId)
        if (selectedView.text == correctAnswer) return true

        Toast.makeText(this.context, R.string.wrong_answer, Toast.LENGTH_SHORT).show()
        return false
    }

    private fun initRadioButtons(choices: Array<String>) {
        choices.forEach { choice ->
            val rdbtn = RadioButton(this.context)
            rdbtn.text = choice
            radioGroup.addView(rdbtn)
        }
    }
}
