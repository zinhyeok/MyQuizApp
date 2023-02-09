package com.example.myquizapp

import android.content.Context
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.content.ContextCompat
import kotlinx.coroutines.processNextEventInCurrentThread

class QuizQustionsActivity : AppCompatActivity(), View.OnClickListener {

    private var mCurrentPosition: Int = 1
    private var mQuestionsList:ArrayList<Question>? = null
    private var mSelectedOptionPosition :Int = 0

    private var progressBar: ProgressBar? = null
    private var tvProgress: TextView? = null
    private var tvQuestion: TextView? = null
    private var ivImage : ImageView? = null
    private var tvOption1: TextView? = null
    private var tvOption2: TextView? = null
    private var tvOption3: TextView? = null
    private var tvOption4: TextView? = null
    private var btnSubmit: Button? = null
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
        btnSubmit = findViewById(R.id.btn_submit)
        mQuestionsList = Constants.getQuestions()

        tvOption1?.setOnClickListener(this)
        tvOption2?.setOnClickListener(this)
        tvOption3?.setOnClickListener(this)
        tvOption4?.setOnClickListener(this)
        btnSubmit?.setOnClickListener(this)
        setQuestion()
    }

    private fun setQuestion() {
        val question: Question = mQuestionsList!![mCurrentPosition - 1]
        progressBar?.progress = mCurrentPosition
        tvProgress?.text = "$mCurrentPosition/${progressBar?.max}"
        tvQuestion?.text = "${question.question}"
        tvOption1?.text = "${question.optionOne}"
        tvOption2?.text = "${question.optionTwo}"
        tvOption3?.text = "${question.optionThree}"
        tvOption4?.text = "${question.optionFour}"
        ivImage?.setImageResource(question.image)

        if(mCurrentPosition == mQuestionsList!!.size){
            btnSubmit?.text = "FINSIH"
        }
        else{
            btnSubmit?.text = "SUBMIT"
        }
    }
    private fun defaultOptionsView(){
        val options = ArrayList<TextView>()
        tvOption1?.let{
            options.add(0, it)
        }
        tvOption2?.let{
            options.add(1, it)
        }
        tvOption3?.let{
            options.add(2, it)
        }
        tvOption4?.let{
            options.add(3, it)
        }
        for(option in options){
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(
                this,
                R.drawable.default_option_border_bg
            )
        }
    }
    private fun selectedOptionView(tv:TextView, selectedOptionNum: Int){
        defaultOptionsView()
        mSelectedOptionPosition = selectedOptionNum
        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background =ContextCompat.getDrawable(
            this,
            R.drawable.selected_option_border_bg
        )
    }
    override fun onClick(v: View?) {
        when(v?.id){
            R.id.tv_option1 -> {
                tvOption1?.let {
                    selectedOptionView(it, 1)
                }
            }
            R.id.tv_option2 -> {
                tvOption2?.let {
                    selectedOptionView(it, 2)
                }
            }
            R.id.tv_option3 -> {
                tvOption3?.let {
                    selectedOptionView(it, 3)
                }
            }
            R.id.tv_option4 -> {
                tvOption4?.let {
                    selectedOptionView(it, 4)
                }
            }
            R.id.btn_submit ->{
                // TODO "implement submit fun"
            }
        }
    }
}