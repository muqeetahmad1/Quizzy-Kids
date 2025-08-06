package com.example.firstapp

import android.graphics.Color
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.firstapp.databinding.ActivityMain2Binding
import com.example.firstapp.databinding.ScoreDialogBinding

class MainActivity2 : AppCompatActivity(),View.OnClickListener {
    companion object {
        var questionModelList: List<questionModel> = listOf()
        var time:String=""
    }
var currentQuestionIndex = 0
    var selectedAnswer=""
    var score=0;
    private var countDownTimer: CountDownTimer? = null
    lateinit var binding: ActivityMain2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.apply {
          option1.setOnClickListener(this@MainActivity2)
          option2.setOnClickListener(this@MainActivity2)
          option3.setOnClickListener(this@MainActivity2)
          option4.setOnClickListener(this@MainActivity2)
          nextOption.setOnClickListener(this@MainActivity2)
        }
        loadQuestions()
        startTimer()
         
    }
    private fun startTimer() {
        if (time.isBlank() || time.toIntOrNull() == null) {
            Toast.makeText(this, "Invalid timer value", Toast.LENGTH_SHORT).show()
            return
        }
        val totalTimeInMillis = time.toInt() * 60 * 1000L
        countDownTimer = object : CountDownTimer(totalTimeInMillis, 1000L) {
            override fun onTick(millisUntilFinished: Long) {
                val seconds = millisUntilFinished / 1000
                val minutes = seconds / 60
                val remainingSeconds = seconds % 60
                binding.timeIdText.text = String.format("%02d:%02d", minutes, remainingSeconds)
            }

            override fun onFinish() {
                Toast.makeText(applicationContext, "Time's up!", Toast.LENGTH_SHORT).show()
                finishQuiz() // Automatically finish the quiz when time is up
            }
        }.start()
    }


            private fun loadQuestions(){
        selectedAnswer=""
        if (currentQuestionIndex== questionModelList.size){
            finishQuiz()
            return
        }

        binding.apply {

    questionIndicator.text=" Question ${currentQuestionIndex+1}/ ${questionModelList.size}"
    progressIndicator.progress= (currentQuestionIndex.toFloat()/ questionModelList.size.toFloat()*100).toInt()
            question.text= questionModelList[currentQuestionIndex].question
            option1.text= questionModelList[currentQuestionIndex].options[0]
            option2.text= questionModelList[currentQuestionIndex].options[1]
            option3.text= questionModelList[currentQuestionIndex].options[2]
            option4.text= questionModelList[currentQuestionIndex].options[3]
        }
    }

    override fun onClick(v: View?) {

        binding.apply {
            option1.setBackgroundColor(getColor(R.color.black))
            option2.setBackgroundColor(getColor(R.color.black))
            option3.setBackgroundColor(getColor(R.color.black))
            option4.setBackgroundColor(getColor(R.color.black))
        }

        val clickedButton= v as Button
        if (clickedButton.id==R.id.next_option){
      //next button is clicked
            if (selectedAnswer.isEmpty()){
                Toast.makeText(applicationContext,"Please select any option to contunue",Toast.LENGTH_SHORT).show()
                return;
            }
            if (selectedAnswer== questionModelList[currentQuestionIndex].correct){
                score++
                Log.i("score of quiz", score.toString())
            }
           currentQuestionIndex++
            loadQuestions()
        }else{
            selectedAnswer=clickedButton.text.toString()
            clickedButton.setBackgroundColor(getColor(com.google.android.material.R.color.m3_chip_background_color))
    }

}
    private fun finishQuiz(){
        countDownTimer?.cancel() // Cancel the timer when the quiz is finished
        val totalQuestions= questionModelList.size
        val percentage= ((score.toFloat()/totalQuestions.toFloat())*100).toInt()

        val dialogBinding= ScoreDialogBinding.inflate(LayoutInflater.from(this))
        dialogBinding.apply {
            circularProgressIndicator.progress=percentage
            indicatorScore.text="$percentage %"
            if (percentage>60){
                scoreTitle.text="Congratulations! You are passed"
                scoreTitle.setTextColor(Color.BLACK)
            }else{
                scoreTitle.text="Oops! You are failed"
                scoreTitle.setTextColor(Color.RED)
            }
        correctQuestions.text= "$score out of $totalQuestions are correct"
            FinsihButton.setOnClickListener{
                finish()
            }
        }
        AlertDialog.Builder(this)
            .setView(dialogBinding.root)
            .setCancelable(false)
            .show()

    }
}