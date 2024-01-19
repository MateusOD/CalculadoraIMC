package com.example.meuprimeiroprojeto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val btnCalcular: Button = findViewById(R.id.btnCalcular)
        val edtPeso: EditText = findViewById(R.id.edittext_peso)
        val edtAltura: EditText = findViewById(R.id.edittext_altura)


        // Ação no de click
        btnCalcular.setOnClickListener {

            val alturaSTR = edtAltura.text.toString()
            val pesoSTR = edtPeso.text.toString()

            if (alturaSTR.isNotEmpty() && pesoSTR.isNotEmpty()) {


                val altura: Float = alturaSTR.toFloat()
                val alturaFinal: Float = altura * altura
                val peso: Float = pesoSTR.toFloat()
                val result: Float = peso / alturaFinal

                val intent = Intent(this, ResultActivity::class.java)
                    .apply {
                        putExtra("EXTRA_RESULT", result)
                    }
                startActivity(intent)
            }else {
            Toast.makeText(this, "Preencher todos os campos", Toast.LENGTH_SHORT).show()
            }

        }
    }
}