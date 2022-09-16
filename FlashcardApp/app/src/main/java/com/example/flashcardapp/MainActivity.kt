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
        val flashAnswer = findViewById<View>(R.id.flashcard_answer)

        findViewById<View>(R.id.flashcard_question). setOnClickListener {
            flashQuestion.visibility = View.INVISIBLE
            flashAnswer.visibility = View.VISIBLE

            Toast.makeText(this, "Question button was clicked", Toast.LENGTH_SHORT).show()

            Log.i("Jacob", "Question button was clicked")
        }
        findViewById<View>(R.id.flashcard_answer). setOnClickListener {
            flashAnswer.visibility = View.INVISIBLE
            flashQuestion.visibility = View.VISIBLE
        }
    }
}