package com.example.programp

import QuestionFragment
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.category_math_button).setOnClickListener {
            startGameWithCategory("Matemáticas")
        }

        findViewById<Button>(R.id.category_general_button).setOnClickListener {
            startGameWithCategory("Cultura General")
        }

        findViewById<Button>(R.id.category_history_button).setOnClickListener {
            startGameWithCategory("Historia")
        }
    }

    private fun startGameWithCategory(category: String) {
        findViewById<TextView>(R.id.welcome_message).visibility = View.GONE
        findViewById<Button>(R.id.category_math_button).visibility = View.GONE
        findViewById<Button>(R.id.category_general_button).visibility = View.GONE
        findViewById<Button>(R.id.category_history_button).visibility = View.GONE

        val questionFragment = QuestionFragment.newInstance(category)
        supportFragmentManager.beginTransaction()
            .replace(R.id.main_layout, questionFragment)
            .addToBackStack(null)
            .commit()
    }
}