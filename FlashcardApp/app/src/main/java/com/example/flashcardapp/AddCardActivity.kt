package com.example.flashcardapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast

class AddCardActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_card)

        val returnButton = findViewById<ImageView>(R.id.cancel_button)
        val saveButton = findViewById<ImageView>(R.id.save_button)
        val questionEditText = findViewById<EditText>(R.id.flashcard_question_edittext)
        val answerEditText = findViewById<EditText>(R.id.flashcard_answer_edittext)


        returnButton.setOnClickListener {
            finish()

        }
        saveButton.setOnClickListener {

            val questionString = questionEditText.text.toString()
            val answerString = answerEditText.text.toString()

            val data = Intent()
            data.putExtra("QUESTION_KEY",questionString)
            data.putExtra("ANSWER_KEY",answerString)

            setResult(RESULT_OK, data)
            finish()
        }





    }
}