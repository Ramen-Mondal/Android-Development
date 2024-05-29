package com.example.lemonade

import android.os.Bundle
import android.view.View
import android.widget.ImageView
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
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //View find
        val img: ImageView = findViewById(R.id.img)
        val txt: TextView = findViewById(R.id.txt)
        var count = 1

        //When user click on the image, according the count value image,image description and text will change, also count variable will be updated
        img.setOnClickListener {
		count++
            when (count) {
                1 -> {
                    img.setImageResource(R.drawable.lemon_tree)
                    img.setContentDescription(getString(R.string.lemonTree))
                    txt.setText(R.string.tapLemonTree)
                }

                2, 3, 4 -> {
                    img.setImageResource(R.drawable.lemon_squeeze)
                    img.setContentDescription(getString(R.string.lemon))
                    txt.setText(R.string.tapSqueeze)
                }

                5 -> {
                    img.setImageResource(R.drawable.lemon_drink)
                    img.setContentDescription(getString(R.string.lemonGlass))
                    txt.setText(R.string.tapLemonadeDrink)
                }

                else -> {
                    img.setImageResource(R.drawable.lemon_restart)
                    img.setContentDescription(getString(R.string.emptyGlass))
                    txt.setText(R.string.tapEmptyGlass)
                    count=0
                }
            }

        }

    }
}