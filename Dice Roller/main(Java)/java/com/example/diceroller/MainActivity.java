package com.example.diceroller;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    ImageView imgDice;
    Button btnRoll;
    int num;

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

        //Id find
        imgDice=findViewById(R.id.imgDice);
        btnRoll=findViewById(R.id.btnRoll);

        //All work depend on this num variable, each button click num variable get a random value from the Random method then according that value
        //set the image of dice.

       btnRoll.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               num= new Random().nextInt(6);
               num++;
               if (num==1){
                   imgDice.setImageResource(R.drawable.dice_1);
               }else if(num==2){
                   imgDice.setImageResource(R.drawable.dice_2);
               }else if(num==3){
                   imgDice.setImageResource(R.drawable.dice_3);
               }else if(num==4){
                   imgDice.setImageResource(R.drawable.dice_4);
               }else if(num==5){
                   imgDice.setImageResource(R.drawable.dice_5);
               }else{
                   imgDice.setImageResource(R.drawable.dice_6);
               }
           }
       });



    }
}