//Project: Little Calculator
//Purpose: A little calculator app that can add, multiply, divide, or subtract two numbers
//Author: Elisa Aldridge

package com.example.littlecalculator

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        Toast.makeText(this.applicationContext,
            getString(R.string.welcome_to_little_calculator), Toast.LENGTH_LONG).show()

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
        val soluDeci = textViewSoluOutput.text.toString().toDoubleOrNull()

        if (numDeci != null) {
            val solu = calculateSolution(numDeci, soluDeci)
            textViewSoluOutput.text = solu.toString()
        } else {
            textViewSoluOutput.text = getString(R.string.invalid_input)
        }
    }

    private fun calculateSolution(numDeci: Double?, soluDeci: Double?): Double {
        val plusRadioButton = findViewById<RadioButton>(R.id.plusRadioButton)
        val minusRadioButton = findViewById<RadioButton>(R.id.minusRadioButton)
        val multiplyRadioButton = findViewById<RadioButton>(R.id.multiplyRadioButton)
        val divideRadioButton = findViewById<RadioButton>(R.id.divideRadioButton)

        var solu = numDeci!!

        if (plusRadioButton.isChecked) {
            solu = soluDeci!! + numDeci
        } else if (minusRadioButton.isChecked) {
            solu = soluDeci!! - numDeci
        } else if (multiplyRadioButton.isChecked) {
            solu = soluDeci!! * numDeci
        } else if (divideRadioButton.isChecked) {
            solu = soluDeci!! / numDeci
        }
        return solu
    }

    fun handleClearButton(view: View) {
        val x = findViewById<RadioGroup>(R.id.radioGroup)
        x.clearCheck()
        val y = findViewById<EditText>(R.id.editTextNumDeci)
        y.text.clear()
        val z = findViewById<TextView>(R.id.textViewSoluOutput)
        z.text = getString(R.string.initializedSolutionOutputText)
    }
}
