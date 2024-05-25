package com.example.myapplication;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //We can set the text through java or xml.Now decide which way you want to set the text.


        //This the java section.....First find the id of the text view.Then set the text with setText() method.
             txt=findViewById(R.id.txt);
        //Hard Code (Directly put string into the text)
                      String text="Hi, I am Ramen Mondal.\nI am creating android application with java more than a year." +
                        "\nThis is for you, if you curious about how to make same thing with java.";
                        txt.setText(text);

                        //        OR           \\

         //Soft Code (First we add the text in the string file which is located in values folder in res.Then we call that string R.string.txt)
                 txt.setText(R.string.txt);


    }
}