package com.example.quizapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import eu.tutorials.quizapp.Constants

class QuizQuestionsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)

        val questions = Constants.getQuestions();


    }
}