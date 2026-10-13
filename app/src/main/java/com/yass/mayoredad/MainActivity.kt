package com.yass.mayoredad

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {


    private lateinit var editText: EditText
    private lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.button)
        editText = findViewById(R.id.editTextNumber)
        val button2 = findViewById<Button>(R.id.button2)
        val button3 = findViewById<Button>(R.id.button3)
        textView = findViewById(R.id.textView)

        textView.text = ""

        button.setOnClickListener {
            comprobarEdad()
        }

        button2.setOnClickListener {
            val edadTexto = editText.text.toString()
            if (edadTexto.isNotEmpty()) {
                val age = edadTexto.toInt()
                val newAge = age - 1
                editText.setText(newAge.toString())
                comprobarEdad()
            } else {
                editText.setText("0")
                comprobarEdad()
            }
        }

        button3.setOnClickListener {
            val edadTexto = editText.text.toString()
            if (edadTexto.isNotEmpty()) {
                val age = edadTexto.toInt()
                val newAge = age + 1
                editText.setText(newAge.toString())
                comprobarEdad()
            } else {
                editText.setText("1")
                comprobarEdad()
            }
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
    private fun comprobarEdad() {
        val edadTexto = editText.text.toString()

        if (edadTexto.isNotEmpty()) {
            val age = edadTexto.toInt()

            if (age > 18) {
                textView.text = "Espabila eres mayor de edad"
            } else if (age < 18) {
                textView.text = "Eres menorsito de edad"
            } else {
                textView.text = "Tienes 18 años oleee"
            }
        } else {
            textView.text = "Pon tu edad primero"
        }
    }

}