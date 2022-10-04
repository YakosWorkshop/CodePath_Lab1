package com.example.flashcardapp

import android.content.Intent
import android.media.Image
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi

class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val flashQuestion = findViewById<TextView>(R.id.flashcard_question)
        val flashBack = findViewById<TextView>(R.id.flashcard_backside)
        val flashAnswer1 = findViewById<View>(R.id.flashcard_answer1)
        val flashAnswer2 = findViewById<View>(R.id.flashcard_answer2)
        val flashAnswer3 = findViewById<View>(R.id.flashcard_answer3)
        val visibleEye = findViewById<ImageView>(R.id.toggle_choices_visibility)
        val invisibleEye = findViewById<ImageView>(R.id.toggle_choices_invisibility)
        val background = findViewById<RelativeLayout>(R.id.background)
        val addButton = findViewById<ImageView>(R.id.add_icon)


        flashQuestion.setOnClickListener {

            flashBack.visibility = View.VISIBLE
            flashQuestion.visibility = View.INVISIBLE
        }
        flashBack.setOnClickListener {

            flashBack.visibility = View.INVISIBLE
            flashQuestion.visibility = View.VISIBLE
        }
        visibleEye.setOnClickListener {

            flashAnswer1.visibility = View.VISIBLE
            flashAnswer2.visibility = View.VISIBLE
            flashAnswer3.visibility = View.VISIBLE
            visibleEye.visibility = View.INVISIBLE
            invisibleEye.visibility = View.VISIBLE


        }

        invisibleEye.setOnClickListener {

            flashAnswer1.visibility = View.INVISIBLE
            flashAnswer2.visibility = View.INVISIBLE
            flashAnswer3.visibility = View.INVISIBLE
            visibleEye.visibility = View.VISIBLE
            invisibleEye.visibility = View.INVISIBLE

        }

        flashAnswer1.setOnClickListener {

            flashAnswer1.setBackgroundColor(getResources().getColor(R.color.red, null))
            flashAnswer3.setBackgroundColor(getResources().getColor(R.color.green, null))

        }
        flashAnswer2.setOnClickListener {

            flashAnswer2.setBackgroundColor(getResources().getColor(R.color.red, null))
            flashAnswer3.setBackgroundColor(getResources().getColor(R.color.green, null))
        }
        flashAnswer3.setOnClickListener {

            flashAnswer3.setBackgroundColor(getResources().getColor(R.color.green, null))

        }
        background.setOnClickListener {
            flashAnswer1.setBackgroundColor(getResources().getColor(R.color.light_orange))
            flashAnswer2.setBackgroundColor(getResources().getColor(R.color.light_orange))
            flashAnswer3.setBackgroundColor(getResources().getColor(R.color.light_orange))
        }

        val resultLauncher =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->

                val data: Intent? = result.data
                if (data != null) {
                    val questionString = data.getStringExtra("QUESTION_KEY")
                    val answerString = data.getStringExtra("ANSWER_KEY")

                    Log.i("Jacob: MainActivity", "question: $questionString")
                    Log.i("Jacob: MainActivity", "answer: $answerString")
                    flashQuestion.text = questionString
                    flashBack.text = answerString

                } else {
                    Log.i("MainActivity", "Returned null data from AddCardActivity")
                }
            }

        addButton.setOnClickListener {

            val intent = Intent(this, AddCardActivity::class.java)
            resultLauncher.launch(intent)
        }
    }

}

