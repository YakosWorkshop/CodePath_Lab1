package com.example.flashcardapp

import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val flashQuestion = findViewById<View>(R.id.flashcard_question)
        val flashAnswer1 = findViewById<View>(R.id.flashcard_answer1)
        val flashAnswer2 = findViewById<View>(R.id.flashcard_answer2)
        val flashAnswer3 = findViewById<View>(R.id.flashcard_answer3)
        val visibleEye = findViewById<ImageView>(R.id.toggle_choices_visibility)
        val invisibleEye = findViewById<ImageView>(R.id.toggle_choices_invisibility)

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

        flashAnswer1. setOnClickListener {

            flashAnswer1.setBackgroundColor(getResources().getColor(R.color.red, null))
            flashAnswer3.setBackgroundColor(getResources().getColor(R.color.green, null))

        }
        flashAnswer2. setOnClickListener {

            flashAnswer2.setBackgroundColor(getResources().getColor(R.color.red, null))
            flashAnswer3.setBackgroundColor(getResources().getColor(R.color.green, null))
        }
        flashAnswer3. setOnClickListener {

            flashAnswer3.setBackgroundColor(getResources().getColor(R.color.green, null))

        }
        flashQuestion.setOnClickListener {
            flashAnswer1.setBackgroundColor(getResources().getColor(R.color.light_orange))
            flashAnswer2.setBackgroundColor(getResources().getColor(R.color.light_orange))
            flashAnswer3.setBackgroundColor(getResources().getColor(R.color.light_orange))
        }
    }
}