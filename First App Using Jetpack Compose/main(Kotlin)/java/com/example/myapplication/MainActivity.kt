package com.example.myapplication

import android.os.Bundle
import android.widget.TextView
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





        //This the Kotlin section.....First find the id of the text view.Then set the text with setText() method.
        val txt: TextView =findViewById(R.id.txt)

        //Hard Code (Directly put string into the text)
        val text="Hi, I am Ramen Mondal.\nI am learning Kotlin."
        txt.setText(text);

        //        OR           \\

        //Soft Code (First we add the text in the string file which is located in values folder in res.Then we call that getString() method
        // and pass the string id (R.string.txt))
        txt.setText(getString(R.string.txt))


    }
}