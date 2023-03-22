package com.mmm.diceapp;


import static com.mmm.diceapp.R.drawable.dice1;
import static com.mmm.diceapp.R.drawable.dice2;
import static com.mmm.diceapp.R.drawable.dice3;
import static com.mmm.diceapp.R.drawable.dice4;
import static com.mmm.diceapp.R.drawable.dice5;
import static com.mmm.diceapp.R.drawable.dice6;


import androidx.appcompat.app.AppCompatActivity;


import android.annotation.SuppressLint;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    ImageView imgdice1,imgdice2;

    Button btnroll;
    TextView txtTotal,txtnum1,txtnum2;
    int imgs[] = {dice1,dice2,dice3,dice4,dice5,dice6};

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imgdice1 = findViewById(R.id.imgdice1);
        imgdice2 = findViewById(R.id.imgdice2);
        btnroll = findViewById(R.id.btnroll);
        txtTotal = findViewById(R.id.txtTotal);
        txtnum1 = findViewById(R.id.txtnum1);
        txtnum2 = findViewById(R.id.txtnum2);

        btnroll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Random random = new Random();
                int num = random.nextInt(6);
                int num1 = random.nextInt(6);
                setDice1(num);
                setDice2(num1);
                Log.e(TAG, "onClick: =============="+num);
                Log.e(TAG, "onClick: =============="+num1);
                int Total = num+num1;
                Log.e(TAG, "onClick: =============="+Total);
                txtTotal.setText("Calculation of two dice : "+(Total+2));
            }
            private void setDice1(int num) {
                imgdice1.setImageResource(imgs[num]);
                txtnum1.setText("Dice1 number is :- "+(num+1));
            }
            private void setDice2(int num1) {
                imgdice2.setImageResource(imgs[num1]);
                txtnum2.setText("Dice2 number is :- "+(num1+1));
            }
        });
    }
}