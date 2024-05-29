package com.example.lemonade;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    ImageView img;
    TextView txt;
    int count;

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

        //View id find
        img=findViewById(R.id.img);
        txt =findViewById(R.id.txt);

       count=1;


        //When user click on the image, according the count value image,image description and text will change, also count variable will be updated
        // we can use if-else or switch


        //Using if-else
        img.setOnClickListener(v -> {
            count++;
            if(count==1) {
                img.setImageResource(R.drawable.lemon_tree);
                img.setContentDescription(getString(R.string.lemonTree));
                txt.setText(R.string.tapLemonTree);
            } else if(count==2 || count==3 || count==4) {
                img.setImageResource(R.drawable.lemon_squeeze);
                img.setContentDescription(getString(R.string.lemon));
                txt.setText(R.string.tapSqueeze);
            } else if(count==5) {
                img.setImageResource(R.drawable.lemon_drink);
                img.setContentDescription(getString(R.string.lemonGlass));
                txt.setText(R.string.tapLemonadeDrink);
            } else {
                img.setImageResource(R.drawable.lemon_restart);
                img.setContentDescription(getString(R.string.emptyGlass));
                txt.setText(R.string.tapEmptyGlass);
                count=0;
            }

        });

        //using switch
//        img.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                  count++;
//                switch (count){
//                    case  1: {
//                        img.setImageResource(R.drawable.lemon_tree);
//                        img.setContentDescription(getString(R.string.lemonTree));
//                        txt.setText(R.string.tapLemonTree);
//                        break;
//                    }
//
//                    case 2 : {
//                        img.setImageResource(R.drawable.lemon_squeeze);
//                        img.setContentDescription(getString(R.string.lemon));
//                        txt.setText(R.string.tapSqueeze);
//                        break;
//                    }
//                    case 3 : {
//                        img.setImageResource(R.drawable.lemon_squeeze);
//                        img.setContentDescription(getString(R.string.lemon));
//                        txt.setText(R.string.tapSqueeze);
//                        break;
//                    }
//                    case 4 : {
//                        img.setImageResource(R.drawable.lemon_squeeze);
//                        img.setContentDescription(getString(R.string.lemon));
//                        txt.setText(R.string.tapSqueeze);
//                        break;
//                    }
//
//                    case 5 : {
//                        img.setImageResource(R.drawable.lemon_drink);
//                        img.setContentDescription(getString(R.string.lemonGlass));
//                        txt.setText(R.string.tapLemonadeDrink);
//                        break;
//                    }
//
//                    default:{
//                        img.setImageResource(R.drawable.lemon_restart);
//                        img.setContentDescription(getString(R.string.emptyGlass));
//                        txt.setText(R.string.tapEmptyGlass);
//                        count=0;
//                    }
//                }
//            }
//        });




    }
}