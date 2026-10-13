package com.yass.mayoredad

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView // <-- Importar TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.button)
        val editText = findViewById<EditText>(R.id.editTextNumber)
        val button2 = findViewById<Button>(R.id.button2)
        val button3 = findViewById<Button>(R.id.button3)
        // Vincular el TextView de tu XML
        val textView = findViewById<TextView>(R.id.textView)

        // Opcional: vaciar el texto inicial para que no ponga "TextView" al abrir la app
        textView.text = ""

        button.setOnClickListener {
            val edadTexto = editText.text.toString()

            if (edadTexto.isNotEmpty()) {
                val age = edadTexto.toInt()

                // Cambiar los Toast por textView.text
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

        button2.setOnClickListener {
            val edadTexto = editText.text.toString()
            if (edadTexto.isNotEmpty()) {
                val age = edadTexto.toInt()
                val newAge = age - 1
                editText.setText(newAge.toString())
            } else {
                editText.setText("0")
            }
        }

        button3.setOnClickListener {
            val edadTexto = editText.text.toString()
            if (edadTexto.isNotEmpty()) {
                val age = edadTexto.toInt()
                val newAge = age + 1
                editText.setText(newAge.toString())
            } else {
                editText.setText("1")
            }
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}