package com.gabrielmartins.app_mario_bros_advinhe_o_numero

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.gabrielmartins.app_mario_bros_advinhe_o_numero.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val listaNumeros: MutableList<Int> = mutableListOf()
    private var progresso = 0

    private val listaImgs: MutableList<Int> = mutableListOf(
        R.drawable.n0, R.drawable.n1, R.drawable.n2, R.drawable.n3,
        R.drawable.n4, R.drawable.n5, R.drawable.n6, R.drawable.n7,
        R.drawable.n8, R.drawable.n9, R.drawable.n10, R.drawable.bloco,
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN //Esconder StatusBar do app


        binding.btPlay.setOnClickListener {view ->
            val numeroDigitado = binding.editNumero.text.toString()

            if (numeroDigitado.isEmpty()){
                mensagem(view,"Coloque um número!", "#FF0000")
            }else{
                gerarNumeroAleatorio(view,numeroDigitado.toInt())
            }

        }

        binding.btReset.setOnClickListener {view ->
            binding.editNumero.setText("")
            progresso = 0
            binding.linearProgressIndicator.setProgress(progresso, true)
        }

    }

    private fun gerarNumeroAleatorio(view: View, numeroDigitado: Int){

        for (n in 0..11){
            listaNumeros.add(n)
        }

        val numeroAleatorio: Int = Random.nextInt(11)
        Random
        val imgNumero:Int = when(numeroAleatorio){
            0 -> {
                listaImgs[0]
            }
            1 -> {
                listaImgs[1]
            }
            2 -> {
                listaImgs[2]
            }
            3 -> {
                listaImgs[3]
            }
            4 -> {
                listaImgs[4]
            }
            5 -> {
                listaImgs[5]
            }
            6 -> {
                listaImgs[6]
            }
            7 -> {
                listaImgs[7]
            }
            8 -> {
                listaImgs[8]
            }
            9 -> {
                listaImgs[9]
            }
            10 -> {
                listaImgs[10]
            }
            else -> {
                listaImgs[11]
            }
        }

        if (numeroDigitado != numeroAleatorio){
            binding.numeroSurpresa.setBackgroundResource(R.drawable.bloco)
            mensagem(view, "Você errou! tente novamente!","#FF0000")
            progresso += 30
            binding.linearProgressIndicator.setProgress(progresso, true)
        }else{
            mensagem(view, "Parabéns você acertou!","#2D9031")
            progresso -= 120
            binding.numeroSurpresa.setBackgroundResource(imgNumero)
            binding.editNumero.setText("")
            binding.linearProgressIndicator.setProgress(progresso, true)
            progresso = 0
        }

        if (progresso > 90){
            //Navegar para tela de game over
            val intent = Intent(this, GameOver::class.java)
            startActivity(intent)
        }
    }

    private fun mensagem(view: View, mensagem: String, cor: String){
        val snackbar = Snackbar.make(view,mensagem,Snackbar.LENGTH_SHORT)
        snackbar.setBackgroundTint(Color.parseColor(cor))
        snackbar.setTextColor(Color.parseColor("#FFFFFF"))
        snackbar.show()
    }
}