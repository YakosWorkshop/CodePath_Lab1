package com.example.flashcardapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val flashQuestion = findViewById<View>(R.id.flashcard_question)
        val flashAnswer1 = findViewById<View>(R.id.flashcard_answer1)
        val flashAnswer2 = findViewById<View>(R.id.flashcard_answer2)
        val flashAnswer3 = findViewById<View>(R.id.flashcard_answer3)
        

        findViewById<View>(R.id.flashcard_answer1). setOnClickListener {

            flashAnswer1.setBackgroundColor(getResources().getColor(R.color.red, null))
            flashAnswer3.setBackgroundColor(getResources().getColor(R.color.green, null))

        }
        findViewById<View>(R.id.flashcard_answer2). setOnClickListener {

            flashAnswer2.setBackgroundColor(getResources().getColor(R.color.red, null))
            flashAnswer3.setBackgroundColor(getResources().getColor(R.color.green, null))
        }
        findViewById<View>(R.id.flashcard_answer3). setOnClickListener {

            flashAnswer3.setBackgroundColor(getResources().getColor(R.color.green, null))

        }
    }
}