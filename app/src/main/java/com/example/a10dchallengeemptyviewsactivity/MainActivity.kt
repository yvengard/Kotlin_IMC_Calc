package com.example.a10dchallengeemptyviewsactivity

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
    val edtPeso: EditText = findViewById(R.id.edtPeso)
    val edtAltura: EditText = findViewById(R.id.edtAltura)

    btnCalcular.setOnClickListener {

        val alturaStr = edtAltura.text.toString()
        val pesoStr = edtPeso.text.toString()

        if(alturaStr.isNotEmpty() && pesoStr.isNotEmpty()) {
            val altura: Float = alturaStr.toFloat()
            val peso: Float = pesoStr.toFloat()


        var result: Float = peso / (altura * altura)

        val intent = Intent(this,ResultActivity::class.java) //intent explicita daqui (this) pra Result
            .apply{
                putExtra("EXTRA_RESULT", result) //EXTRA_RESULT é uma chave pra recuperar na próxima página (tipo ID)
            }
        startActivity(intent)
        }else{
            Toast.makeText(this, "Preencher todos os campos", Toast.LENGTH_SHORT).show()
        }
    }
    }
}
