package com.victor_ledda.quizzcapitals

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

var quizs = ArrayList<Quiz>()
var numberOfGoodAnswers: Int = 0
var currentQuizIndex: Int = 0


class QuizzActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quizz)
        quizs.add(Quiz("Quelle est la capitale de la France", "Alger","Paris","Milan","Mexico",1 ,2))
        quizs.add(Quiz("Quelle est la capitale de l'Angleterre", "Paris","Londres","Sydney","Sao Paulo",2,2))
        quizs.add(Quiz("Quelle est la capitale de l'Allemagne", "Moscou","Paris","Berlin","Los Angeles",5,3))
        quizs.add(Quiz("Quelle est la capitale du Brésil", "Brasilia","Berlin","Turin","Constantinople",6, 1 ))
   showQuestion(quizs.get(currentQuizIndex))
    }


    fun showQuestion(quiz: Quiz) {
        val txtQuestion: TextView = findViewById(R.id.txtQuestion)
        val answer1: TextView = findViewById(R.id.answer1)
        val answer2: TextView = findViewById(R.id.answer2)
        val answer3: TextView = findViewById(R.id.answer3)
        val answer4: TextView = findViewById(R.id.answer4)
        val imageHome: ImageView = findViewById(R.id.image);
        txtQuestion.setText(quiz.question)
        imageHome.setImageResource(quiz.imageHome)
        answer1.setText(quiz.answer1)
        answer2.setText(quiz.answer2)
        answer3.setText(quiz.answer3)
        answer4.setText(quiz.answer4)
    }
fun handleAnswer(answerID: Int){
    val quiz = quizs.get(currentQuizIndex)

    if(quiz.isCorrect(answerID)){
        numberOfGoodAnswers++
        Toast.makeText( this, "+1", Toast.LENGTH_SHORT).show()
    }else{
        Toast.makeText( this, "+0", Toast.LENGTH_SHORT).show()
    }
    currentQuizIndex++
    if(currentQuizIndex>= quizs.size){
    var alert = AlertDialog.Builder(this )
        alert.setTitle("Partie terminée")
        alert.setMessage("Tu as eu : " + numberOfGoodAnswers + "de bonnes réponses")
        alert.setPositiveButton("OK"){
            dialogInterface: DialogInterface?, i: Int -> finish()
        }
        alert.show()
    }else{
        showQuestion(quizs.get(currentQuizIndex))
    }
}
    fun onClickAnswer1(view: View){
        handleAnswer(1)
    }
    fun onClickAnswer2(view: View){
        handleAnswer(2)
    }
    fun onClickAnswer3(view: View){
        handleAnswer(3)
    }
    fun onClickAnswer4(view: View){
        handleAnswer(4)
    }
}


