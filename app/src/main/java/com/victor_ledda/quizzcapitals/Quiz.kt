package com.victor_ledda.quizzcapitals

class Quiz(var question : String, var answer1: String, var answer2: String, var answer3: String,  var answer4: String,var image: Int, var correctAnswerNumber: Int) {
    fun isCorrect(answerNumber: Int) : Boolean {
        if(answerNumber == correctAnswerNumber)
            return true

        return false
    }
}