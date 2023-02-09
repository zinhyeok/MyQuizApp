package com.example.myquizapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import kotlinx.coroutines.processNextEventInCurrentThread

class QuizQustionsActivity : AppCompatActivity() {
    private var progressBar: ProgressBar? = null
    private var tvProgress: TextView? = null
    private var tvQuestion: TextView? = null
    private var ivImage : ImageView? = null
    private var tvOption1: TextView? = null
    private var tvOption2: TextView? = null
    private var tvOption3: TextView? = null
    private var tvOption4: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_qustions)
        progressBar = findViewById(R.id.progressBar)
        tvProgress = findViewById(R.id.tv_progress)
        tvQuestion = findViewById(R.id.tv_question)
        ivImage = findViewById(R.id.iv_image)
        tvOption1 = findViewById(R.id.tv_option1)
        tvOption2 = findViewById(R.id.tv_option2)
        tvOption3 = findViewById(R.id.tv_option3)
        tvOption4 = findViewById(R.id.tv_option4)
        val questionList = Constants.getQuestions()
//        Log.i("Question size", "${questionList.size}")
//        for(i in questionList){
//            Log.e("Question", i.question)
//        }
        var currentPosition = 1
        val question:Question = questionList[currentPosition-1]
        progressBar?.progress = currentPosition
        tvProgress?.text = "$currentPosition/${progressBar?.max}"
        tvQuestion?.text = "${question.question}"
        tvOption1?.text = "${question.optionOne}"
        tvOption2?.text = "${question.optionTwo}"
        tvOption3?.text = "${question.optionThree}"
        tvOption4?.text = "${question.optionFour}"
        ivImage?.setImageResource(question.image)
    }
}