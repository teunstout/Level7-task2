package com.example.hvaquest.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.hvaquest.model.Question
import com.example.hvaquest.repository.QuestRepository

class QuestViewModel: ViewModel() {
    private val questRepository = QuestRepository()
    private val questions = questRepository.getHvaQuest() as ArrayList<Question>
    private var index = 0

    // Returns boolean if there is a next question
    fun checkNoMoreQuestions() = (index >= questions.size)

    // Returns the questions place. So index 0 = question 1
    fun getWhichQuestion() = index + 1

    // Get the question on index
    fun getQuestion() = questions[index]

    // Increment question so next time you call getQuestion it is the next question
    fun nextQuestion() =  ++index

    // decrement question so next time you call getQuestion it is the previous question
    fun previousQuestion() =  --index

    // Get the size of the question list
    fun getQuestionSize() = questions.size

}