package com.gabrielmartins.app_mario_bros_advinhe_o_numero

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.gabrielmartins.app_mario_bros_advinhe_o_numero.databinding.ActivityGameOverBinding
import com.gabrielmartins.app_mario_bros_advinhe_o_numero.databinding.ActivityMainBinding

class GameOver : AppCompatActivity() {

    private lateinit var binding: ActivityGameOverBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGameOverBinding.inflate(layoutInflater)
        setContentView(binding.root)

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN //Esconder StatusBar do app

        binding.btReset.setOnClickListener{
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}