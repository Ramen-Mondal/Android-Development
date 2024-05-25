package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.random.Random

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
        //Id find
        val imgDice = findViewById<ImageView>(R.id.imgDice)
        val button: Button =findViewById(R.id.btnRoll)

        //Random value generate on button click then according that value change the image.
        var num=1
        button.setOnClickListener() {
            num = (1..6).random()

            when (num) {
                1 -> imgDice.setImageResource(R.drawable.dice_1)
                2 -> imgDice.setImageResource(R.drawable.dice_2)
                3 -> imgDice.setImageResource(R.drawable.dice_3)
                4 -> imgDice.setImageResource(R.drawable.dice_4)
                5 -> imgDice.setImageResource(R.drawable.dice_5)
                6 -> imgDice.setImageResource(R.drawable.dice_6)
            }
        }



    }
}