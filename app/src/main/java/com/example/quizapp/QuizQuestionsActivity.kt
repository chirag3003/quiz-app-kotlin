package com.example.quizapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.core.content.ContextCompat
import eu.tutorials.quizapp.Constants
import eu.tutorials.quizapp.Question

class QuizQuestionsActivity : AppCompatActivity(), View.OnClickListener {
    //create variables for each view in the layout
    private var progressBar:ProgressBar?=null
    private var tvProgress: TextView? = null
    private var tvQuestion:TextView? = null
    private var ivImage: ImageView? = null
    private lateinit var tvOptionOne:TextView
    private lateinit var tvOptionTwo:TextView
    private lateinit var tvOptionThree:TextView
    private lateinit var tvOptionFour:TextView
    private lateinit var buttonSubmit:Button


    private var mCurrentPosition: Int = 1 // Default and the first question position
    private var mQuestionsList: ArrayList<Question>? = null
    private var mCorrectAnswers: Int = 0
    private var mUserName: String? = null
    private var mSelectedOptionPosition: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)


        progressBar=findViewById(R.id.progressBar)
        tvProgress = findViewById(R.id.tv_progress)
        tvQuestion = findViewById(R.id.tv_question)
        ivImage = findViewById(R.id.iv_image)
        tvOptionOne = findViewById(R.id.tv_option_one)
        tvOptionTwo = findViewById(R.id.tv_option_two)
        tvOptionThree = findViewById(R.id.tv_option_three)
        tvOptionFour = findViewById(R.id.tv_option_four)
        buttonSubmit = findViewById(R.id.btn_submit)
        mQuestionsList = Constants.getQuestions()

        setQuestion()

    }

    private fun setQuestion() {
        val question = mQuestionsList!![mCurrentPosition-1]
        ivImage?.setImageResource(question.image)
        tvOptionOne.text = question.optionOne;
        tvOptionTwo.text = question.optionTwo;
        tvOptionThree.text = question.optionThree
        tvOptionFour.text = question.optionFour

        tvOptionOne.setOnClickListener(this)
        tvOptionTwo.setOnClickListener(this)
        tvOptionThree.setOnClickListener(this)
        tvOptionFour.setOnClickListener(this)

        buttonSubmit.text  = if (mCurrentPosition == mQuestionsList!!.size) "FINISH" else "Submit"

    }

    private fun defaultOptionsView(){
        val options = arrayListOf<TextView>(tvOptionOne,tvOptionTwo,tvOptionThree,tvOptionFour)

        for(option in options){
            option.setTextColor(Color.parseColor("#FF0000"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(this,R.drawable.default_option_border_bg)
        }
    }

    fun selectedOptionView(tv:TextView,selectionOption:Int){
        defaultOptionsView()
        mSelectedOptionPosition = selectionOption
        tv.setTextColor(Color.parseColor("#3634a3"))
        tv.setTypeface(tv.typeface,Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(this,R.drawable.selected_option_border_bg)
    }

    override fun onClick(view: View?) {
        when(view?.id){
            R.id.tv_option_one -> selectedOptionView(tvOptionOne,1)
            R.id.tv_option_two -> selectedOptionView(tvOptionTwo,1)
            R.id.tv_option_three -> selectedOptionView(tvOptionThree,1)
            R.id.tv_option_four -> selectedOptionView(tvOptionFour,1)
        }
    }

}