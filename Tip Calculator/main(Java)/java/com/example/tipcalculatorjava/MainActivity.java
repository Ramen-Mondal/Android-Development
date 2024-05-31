package com.example.tipcalculatorjava;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText edtMoney,edtPercent;
    SwitchCompat toggle;
    TextView txtAns;


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
        edtMoney=findViewById(R.id.edtMoney);
        edtPercent=findViewById(R.id.edtPercent);
        toggle=findViewById(R.id.toggle);
        txtAns=findViewById(R.id.txtAns);

        //on money value change set the ans to the answer text.
      edtMoney.addTextChangedListener(new TextWatcher() {
          @Override
          public void beforeTextChanged(CharSequence s, int start, int count, int after) {

          }

          @Override
          public void onTextChanged(CharSequence s, int start, int before, int count) {
              String money=s.toString();
              String percent=edtPercent.getText().toString();
              if(!money.isEmpty() && !percent.isEmpty() ){
                  double dMoney=Double.parseDouble(money);
                  double dPercent=Double.parseDouble(percent);
                  txtAns.setText(calculation(dMoney,dPercent,toggle.isChecked()));
              }else{
                  txtAns.setText(getString(R.string.tip_amount));
              }
          }

          @Override
          public void afterTextChanged(Editable s) {

          }
      });

      //If percent value change set ans to the answer text.
      edtPercent.addTextChangedListener(new TextWatcher() {
          @Override
          public void beforeTextChanged(CharSequence s, int start, int count, int after) {

          }

          @Override
          public void onTextChanged(CharSequence s, int start, int before, int count) {
              String percent=s.toString();
              String money=edtMoney.getText().toString();
              if(!money.isEmpty() && !percent.isEmpty() ){
                  double dMoney=Double.parseDouble(money);
                  double dPercent=Double.parseDouble(percent);
                  txtAns.setText(calculation(dMoney,dPercent,toggle.isChecked()));
              }else{
                  txtAns.setText(getString(R.string.tip_amount));
              }

          }

          @Override
          public void afterTextChanged(Editable s) {

          }
      });

      //on switch change set the answer text to rounded ans or not rounded ans
      toggle.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              String money=edtMoney.getText().toString();
              String percent=edtPercent.getText().toString();
              if(!money.isEmpty() && !percent.isEmpty()){
                  double dMoney=Double.parseDouble(money);
                  double dPercent=Double.parseDouble(percent);
                  if(toggle.isChecked()){
                      txtAns.setText(calculation(dMoney,dPercent,true));
                  }else{
                      txtAns.setText(calculation(dMoney,dPercent,false));
                  }
              }
          }
      });

    }

    //Tip Calculation
    public String calculation(double money,double percent,boolean roundUp){
        double ans = (percent / 100) * money;
        if(roundUp) {
           ans=Math.round(ans);
        }
        return getString(R.string.tip_amount)+ans;
    }
}