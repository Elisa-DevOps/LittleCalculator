package com.example.littlecalculator

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun handleButton(view: View) {
        val editTextNumDeci = findViewById<EditText>(R.id.editTextNumDeci)
        val textViewSoluOutput = findViewById<TextView>(R.id.textViewSoluOutput)

        val numDeci = editTextNumDeci.text.toString().toDoubleOrNull()
        if (numDeci != null) {
            val solu = calculateSolution(numDeci)
            textViewSoluOutput.text = solu.toString()
        } else {
            textViewSoluOutput.text = "Invalid input"
        }

    }

    private fun calculateSolution(numDeci: Double): Any {
        var solu = 0.0
        for (i in 1..numDeci.toInt()) {
            solu += 1.0 / i
        }
        return solu
    }
}
