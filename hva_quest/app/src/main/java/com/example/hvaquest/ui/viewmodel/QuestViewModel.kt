package com.example.hvaquest.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.hvaquest.model.Question
import com.example.hvaquest.repository.QuestRepository

class QuestViewModel: ViewModel() {
    private val questRepository = QuestRepository()
    private val questions = questRepository.getHvaQuest() as ArrayList<Question>
    private var index = 0

    fun checkNoMoreQuestions() = index > questions.size

    fun getIndexOfQuestion() = index

    fun getQuestion() = questions[index]

    fun nextQuestion() =  ++index

    fun previousQuestion() =  --index

    fun getQuestionSize() = questions.size
}