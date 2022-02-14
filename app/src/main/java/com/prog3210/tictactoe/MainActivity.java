package com.prog3210.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
getSupportActionBar().setDisplayShowHomeEnabled(true);
//getSupportActionBar().setBackgroundDrawable(R.);
        getSupportActionBar().setLogo(R.drawable.logo);
        setContentView(R.layout.activity_main);

        Button[][] buttonArrays = new Button[3][3];
        buttonArrays[0][0] = findViewById(R.id.button00);
        buttonArrays[0][1] = findViewById(R.id.button01);
        buttonArrays[0][2] = findViewById(R.id.button02);
        buttonArrays[1][0] = findViewById(R.id.button10);
        buttonArrays[1][1] = findViewById(R.id.button11);
        buttonArrays[1][2] = findViewById(R.id.button12);
        buttonArrays[2][0] = findViewById(R.id.button20);
        buttonArrays[2][1] = findViewById(R.id.button21);
        buttonArrays[2][2] = findViewById(R.id.button22);

        for(int i = 0; i<3; i++){
            for (int j = 0; j <3; j++){
                buttonArrays[i][j].setOnClickListener(this);
//                buttonArrays[i][j].(100);
//                buttonArrays[i][j].setHeight(100);
                buttonArrays[i][j].setBackgroundColor(getColor(R.color.black));
            }
        }

    }

    @Override
    public void onClick(View view) {
        Toast.makeText(this, "Button Clicked", Toast.LENGTH_SHORT).show();

    }
}