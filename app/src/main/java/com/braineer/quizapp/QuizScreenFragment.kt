package com.braineer.quizapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.braineer.quizapp.databinding.FragmentQuizScreenBinding

class QuizScreenFragment : Fragment(),View.OnClickListener {
    private lateinit var quizBinding:FragmentQuizScreenBinding
    private lateinit var questionList: List<QuestionSet>
    private var count = 0
    private var score = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        quizBinding = FragmentQuizScreenBinding.inflate(inflater,container,false)

        quizBinding.answerLayout.visibility = View.GONE
        quizBinding.questionLayout.visibility = View.VISIBLE

        quizBinding.option1.setOnClickListener(this)
        quizBinding.option2.setOnClickListener(this)
        quizBinding.option3.setOnClickListener(this)
        quizBinding.option4.setOnClickListener(this)

        questionList = listOf(
            QuestionSet("What is Android?", listOf("Mobile","Computer","OS","Bike"),"OS"),
            QuestionSet("Android is based on which of the following language?", listOf("Java","C++","Python","Ruby"),"Java"),
            QuestionSet("APK stands for -", listOf("Android Phone Kit","Android Page Kit","Android Package Kit","None of the above"),"Android Package Kit"),
            QuestionSet("Which of the following kernel is used in Android?", listOf("MAC","Windows","Linux","Redhat"),"Linux"),
            QuestionSet("Does android support other languages than java?", listOf("Yes","No","May be","Can't Say"),"Yes")
        )

        startQuiz()

        quizBinding.reAttempt.setOnClickListener{
            count=0
            score = 0
            startQuiz()
            quizBinding.answerLayout.visibility = View.GONE
            quizBinding.questionLayout.visibility = View.VISIBLE
        }


        return quizBinding.root
    }

    private fun startQuiz() {


        if(count<5) {
            quizBinding.question.text = questionList[this.count].question
            quizBinding.option1.text = questionList[this.count].option[0]
            quizBinding.option2.text = questionList[this.count].option[1]
            quizBinding.option3.text = questionList[this.count].option[2]
            quizBinding.option4.text = questionList[this.count].option[3]
        }else{
            quizBinding.score.text = "You have got $score out of 5"
            quizBinding.answerLayout.visibility = View.VISIBLE
            quizBinding.questionLayout.visibility = View.GONE

        }


    }

    data class QuestionSet (
        val question : String,
        val option : List<String>,
        val answer : String
            ){


    }

    override fun onClick(view: View?) {

            when(view?.id) {
                R.id.option1 -> {
                    if (quizBinding.option1.text.toString().equals(questionList[count].answer)){
                        score++
                    }
                    count++
                    startQuiz()
                }
                R.id.option2 -> {
                    if (quizBinding.option2.text.toString().equals(questionList[count].answer)){
                        score++
                    }
                    count++
                    startQuiz()
                }
                R.id.option3 -> {
                    if (quizBinding.option3.text.toString().equals(questionList[count].answer)){
                        score++
                    }
                    count++
                    startQuiz()
                }
                R.id.option4 -> {
                    if (quizBinding.option4.text.toString().equals(questionList[count].answer)){
                        score++
                    }
                    count++
                    startQuiz()
                }
            }

        }


}