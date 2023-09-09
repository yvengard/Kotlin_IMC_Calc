package com.example.a10dchallengeemptyviewsactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        //habilito botão de voltar
        supportActionBar?.setHomeButtonEnabled(true)
        //mostro o botão de voltar no display
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val txvResult = findViewById<TextView>(R.id.txvResult)
        val tvClassificacao = findViewById<TextView>(R.id.tvClasse)
        val result = intent.getFloatExtra("EXTRA_RESULT",0.1f)

        txvResult.text = result.toString()

        var classificacao = if(result < 18.5f) {
            "ABAIXO DO PESO"
        } else if(result in 18.5f..24.9f){
            "NORMAL"
        } else if(result>=25.0f && result<=29.9f){
            "SOBREPESO"
        } else if(result>=30.0f && result <=39.9f){
            "OBESIDADE"
        } else {
            "OBESIDADE GRAVE"
        }

        tvClassificacao.text = getString(R.string.message_classfiicacao, classificacao)
    }
// função para dar interação ao botão voltar criado
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        finish() //fecha a tela atual e exibe a tela anterior
        return super.onOptionsItemSelected(item)
    }
}