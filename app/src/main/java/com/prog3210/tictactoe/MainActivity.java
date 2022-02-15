package com.prog3210.tictactoe;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

//import java.io.Console;
import java.util.Objects;

public class MainActivity extends AppCompatActivity
    implements View.OnClickListener {
    boolean isXturn = true;
    TextView statusTxtView;
    Button[][] buttonArrays;
    Button newGameButton;
    boolean isGameOn = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Objects.requireNonNull(getSupportActionBar()).setDisplayUseLogoEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        //getSupportActionBar().setBackgroundDrawable(R.);
        getSupportActionBar().setLogo(R.drawable.logo);
        setContentView(R.layout.activity_main);
//        updateStatus();

        statusTxtView = findViewById(R.id.GameStatus);
        newGameButton  = findViewById(R.id.NewGameBtn);
        buttonArrays= new Button[3][3];
        buttonArrays[0][0] = findViewById(R.id.button00);
        buttonArrays[0][1] = findViewById(R.id.button01);
        buttonArrays[0][2] = findViewById(R.id.button02);
        buttonArrays[1][0] = findViewById(R.id.button10);
        buttonArrays[1][1] = findViewById(R.id.button11);
        buttonArrays[1][2] = findViewById(R.id.button12);
        buttonArrays[2][0] = findViewById(R.id.button20);
        buttonArrays[2][1] = findViewById(R.id.button21);
        buttonArrays[2][2] = findViewById(R.id.button22);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttonArrays[i][j].setOnClickListener(this);
                buttonArrays[i][j].setBackgroundColor(getColor(R.color.black));
            }
        }
        newGameButton.setOnClickListener(this);
    }
    /*@Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        // Save UI state changes to the savedInstanceState.
        // This bundle will be passed to onCreate if the process is
        // killed and restarted.
        savedInstanceState.putBoolean("isXTurnKey", true);
        savedInstanceState.putBoolean("isGameOnKey", true);
        savedInstanceState.putBinder("textViewKey", (IBinder) statusTxtView);
    }
    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        // Restore UI state from the savedInstanceState.
        // This bundle has also been passed to onCreate.
        TextView statusTxtView = (TextView) savedInstanceState.getBinder("textViewKey");
//        double myDouble = savedInstanceState.getDouble("myDouble");
//        int myInt = savedInstanceState.getInt("MyInt");
//        String myString = savedInstanceState.getString("MyString");
    }*/

    protected void ChangeTurn() {
        isXturn = !isXturn;
    }

    protected void updateStatus() {
        if (isXturn) {
            statusTxtView.setText(R.string.OTurn);

        } else {
            statusTxtView.setText(R.string.XTurn);
        }
    }

    protected void drawButton(Button btn) {
        btn.setTextSize(60);
        if (isXturn) {
            btn.setText("X");

        } else {
            btn.setText("O");
        }
    }
    protected  void RestartGame(){
        isXturn = true;
        isGameOn = true;
        statusTxtView.setText(R.string.XTurn);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttonArrays[i][j].setText("");
                buttonArrays[i][j].setClickable(true);
            }
        }
    }
    protected  void TieCheck(){
        int count = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(buttonArrays[i][j].getText() != "") {
                    count++;
                }
            }
        }
        if(count == 9 && isGameOn){
            isGameOn = false;
            statusTxtView.setText(R.string.Tie);
        }
    }
    protected void validateGame(){
        CharSequence value00 = buttonArrays[0][0].getText();
        CharSequence value01 = buttonArrays[0][1].getText();
        CharSequence value02 = buttonArrays[0][2].getText();
        CharSequence value10 = buttonArrays[1][0].getText();
        CharSequence value11 = buttonArrays[1][1].getText();
        CharSequence value12 = buttonArrays[1][2].getText();
        CharSequence value20 = buttonArrays[2][0].getText();
        CharSequence value21 = buttonArrays[2][1].getText();
        CharSequence value22 = buttonArrays[2][2].getText();

        //Horizontal Lines
        if((value00 == value02) && (value01 == value02) && (value00 != ""))
        {
            if(value00 == "X"){
                statusTxtView.setText(R.string.XWin);
            }
            else{
                statusTxtView.setText(R.string.YWin);
            }
            isGameOn = false;
        }
        else if  ((value11 == value12) && (value10 == value12)&& (value10 != ""))
        {
            if(value10 == "X"){
                statusTxtView.setText(R.string.XWin);
            }
            else{
                statusTxtView.setText(R.string.YWin);
            }
            isGameOn = false;
        }
        else if  ((value21 == value22) && (value22 == value20)&& (value20 != ""))
        {
            if(value20 == "X"){
                statusTxtView.setText(R.string.XWin);
            }
            else{
                statusTxtView.setText(R.string.YWin);
            }
            isGameOn = false;
        }


        //Vertical Lines
        if((value00 == value10) && (value10 == value20) && (value00 != ""))
        {
            if(value00 == "X"){
                statusTxtView.setText(R.string.XWin);
            }
            else{
                statusTxtView.setText(R.string.YWin);
            }
            isGameOn = false;
        }
        else if  ((value01 == value11) && (value01 == value21)&& (value01 != ""))
        {
            if(value01 == "X"){
                statusTxtView.setText(R.string.XWin);
            }
            else{
                statusTxtView.setText(R.string.YWin);
            }
            isGameOn = false;
        }
        else if  ((value02 == value12) && (value22 == value12)&& (value02 != ""))
        {
            if(value02 == "X"){
                statusTxtView.setText(R.string.XWin);
            }
            else{
                statusTxtView.setText(R.string.YWin);
            }
            isGameOn = false;
        }

        //Diagonal Lines
        if((value00 == value11) && (value00 == value22) && (value00 != ""))
        {
            if(value00 == "X"){
                statusTxtView.setText(R.string.XWin);
            }
            else{
                statusTxtView.setText(R.string.YWin);
            }
            isGameOn = false;
        }
        else if  ((value02 == value11) && (value02 == value20)&& (value02 != ""))
        {
            if(value02 == "X"){
                statusTxtView.setText(R.string.XWin);
            }
            else{
                statusTxtView.setText(R.string.YWin);
            }
            isGameOn = false;
        }
    }
    @Override
    public void onClick(@NonNull View view) {
        if(view.getId() == R.id.NewGameBtn){
            RestartGame();
        }
        else if (view.isClickable()) {
            if(isGameOn){
                Toast.makeText(this, "Button Clicked", Toast.LENGTH_SHORT).show();
                drawButton((Button) view);
                updateStatus();
                ChangeTurn();
                view.setClickable(false);
                validateGame();
                TieCheck();
            }
        }
    }
}