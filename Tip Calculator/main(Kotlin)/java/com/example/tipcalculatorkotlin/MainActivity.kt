package com.example.tipcalculatorkotlin

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SwitchCompat
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

        //Id find
        val edtMoney: EditText=findViewById(R.id.edtMoney)
        val edtPercent: EditText=findViewById(R.id.edtPercent)
        val txtAns: TextView =findViewById(R.id.txtAns)
        val toggle: SwitchCompat=findViewById(R.id.toggle)

        //on money value change 1st calculate the ans according the value, then set the ans to the answer text.
        edtMoney.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

                val money=s.toString()
                val percent=edtPercent.getText().toString()
                if(money.isNotEmpty() && percent.isNotEmpty()){
                    val dMoney:Double=money.toDoubleOrNull()?:0.0
                    val dPercent:Double=percent.toDouble()
                    txtAns.text = calculation(dMoney,dPercent,toggle.isChecked)
                }else{
                    txtAns.text = getString(R.string.tip_amount)
                }

            }

            override fun afterTextChanged(s: Editable?) {

            }

        })


        //On percent value change 1st calculate the ans according the value, then set ans to the answer text.
        edtPercent.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                val percent=s.toString()
                val money=edtMoney.getText().toString()
                if(money.isNotEmpty() && percent.isNotEmpty()){
                    val dMoney=money.toDouble()
                    val dPercent=percent.toDouble()
                    txtAns.text = calculation(dMoney,dPercent,toggle.isChecked)
                }else{
                    txtAns.text = getString(R.string.tip_amount)
                }
            }

            override fun afterTextChanged(s: Editable?) {

            }

        })

        //on switch change 1st get the answer then set the answer text to rounded ans or not rounded ans
        toggle.setOnClickListener {
            val money=edtMoney.getText().toString()
            val percent=edtPercent.getText().toString()
            if(money.isNotEmpty() && percent.isNotEmpty()){
                val dMoney=money.toDouble()
                val dPercent=percent.toDouble()
                if(toggle.isChecked){
                    txtAns.text = calculation(dMoney,dPercent,true)
                }else{
                    txtAns.text = calculation(dMoney,dPercent,false)
                }
            }
        }

    }

    //Tip Calculation
  fun calculation(money:Double,percent:Double,roundUp:Boolean): String{
        var tip = (percent / 100) * money
        if(roundUp) {
            tip=kotlin.math.ceil(tip)
        }
        return getString(R.string.tip_amount)+tip;
    }
}