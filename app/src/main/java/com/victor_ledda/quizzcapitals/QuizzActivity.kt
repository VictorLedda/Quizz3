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
        quizs.add(Quiz("Quelle est la capitale de la France ?", "Alger","Paris","Milan","Mexico" , R.drawable.paris,2))
        quizs.add(Quiz("Quelle est la capitale de l'Angleterre ?", "Paris","Londres","Sydney","Sao Paulo", R.drawable.londres, 2))
        quizs.add(Quiz("Quelle est la capitale de l'Allemagne ?", "Moscou","Paris","Los Angeles","Berlin",R.drawable.berlin, 4))
        quizs.add(Quiz("Quelle est la capitale du Brésil ?", "Brasilia","Berlin","Turin","Constantinople", R.drawable.brasilia, 1 ))
        quizs.add(Quiz("Quelle est la capitale de la Corée du nord ?", "Séoul","New Delhi","Moscou","Pyongyang" , R.drawable.coree,4))
        quizs.add(Quiz("Quelle est la capitale du Nigéria ?", "Lomé","Khartoum","Lusuka","Niger", R.drawable.nigeria, 4))
        quizs.add(Quiz("Quelle est la capitale de Mongolie ?", "Kinshasa","N'Djamena","Oulan-Batour","Dodoma",R.drawable.mongolie, 3))
        quizs.add(Quiz("Quelle est la capitale du Pérou ?", "La paz","Asuncion","Lima","Santiago", R.drawable.perou, 3 ))
        quizs.add(Quiz("Quelle est la capitale de nouvelle zélande ?", "Wellington","Sidney","Bangkok","Vientiane",R.drawable.zelande, 1))
        quizs.add(Quiz("Quelle est la capitale du Cambodge ?", "Phnom Penh","Kuala Lumpur","Jakarta","Manille", R.drawable.cambodge, 1 ))
   showQuestion(quizs.get(currentQuizIndex))
    }


    fun showQuestion(quiz: Quiz) {


        val txtQuestion: TextView = findViewById(R.id.txtQuestion)
        val answer1: TextView = findViewById(R.id.answer1)
        val answer2: TextView = findViewById(R.id.answer2)
        val answer3: TextView = findViewById(R.id.ans3)
        val answer4: TextView = findViewById(R.id.answer4)
        val imageHome: ImageView = findViewById(R.id.image)


        txtQuestion.setText(quiz.question)
        imageHome.setImageResource(quiz.imageHome);
        answer1.setText(quiz.answer1)
        answer2.setText(quiz.answer2)
        answer3.setText(quiz.answer3)
        answer4.setText(quiz.answer4)
    }
fun handleAnswer(answerID: Int){
    val quiz = quizs.get(currentQuizIndex)

    if(quiz.isCorrect(answerID)){
        numberOfGoodAnswers++
        Toast.makeText( this, "Bonne réponse", Toast.LENGTH_SHORT).show()
    }else{
        Toast.makeText( this, "Mauvaise réponse", Toast.LENGTH_SHORT).show()
    }
    currentQuizIndex++
    if(currentQuizIndex>= quizs.size){
    var alert = AlertDialog.Builder(this )
        alert.setTitle("Partie terminée")
        alert.setMessage("Tu as eu : " + numberOfGoodAnswers + "  bonnes réponses")
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




