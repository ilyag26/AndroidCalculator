package com.example.truecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView text;
    String numbers1 = "";
    String operator;
    String oldNumber;
    boolean isNew = true;
    boolean change = false;
    boolean zero = false;
    char first;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = findViewById(R.id.textViewResult);
    }

    public void checkingZero() {
        if(zero==true){
            first = numbers1.charAt(0);
            if (String.valueOf(first).equals("-")) {
                numbers1 = "-" + numbers1.substring(2);
                zero = false;
            } else {
                numbers1 = "" + numbers1.substring(2);
                zero = false;
            }
        }
    }

    public void clickAC(View view) {
        text.setText("0");
        isNew = true;
    }

    public void clickNumber(View view) {
        if (isNew)
            numbers1 = "";
        isNew = false;
        switch (view.getId()) {
            case R.id.button1:
                checkingZero();
                numbers1 = numbers1 + 1;
                break;
            case R.id.button2:
                checkingZero();
                numbers1 = numbers1 + 2;
                break;
            case R.id.button3:
                checkingZero();
                numbers1 = numbers1 + 3;
                break;
            case R.id.button4:
                checkingZero();
                numbers1 = numbers1 + 4;
                break;
            case R.id.button5:
                checkingZero();
                numbers1 = numbers1 + 5;
                break;
            case R.id.button6:
                checkingZero();
                numbers1 = numbers1 + 6;
                break;
            case R.id.button7:
                checkingZero();
                numbers1 = numbers1 + 7;
                break;
            case R.id.button8:
                checkingZero();
                numbers1 = numbers1 + 8;
                break;
            case R.id.button9:
                checkingZero();
                numbers1 = numbers1 + 9;
                break;
            case R.id.button0:
                checkingZero();
                numbers1 = numbers1 + 0;
                break;
            case R.id.buttonChange:

                if (numbers1.equals("0") || numbers1.equals("")) {
                    if (!change) {
                        numbers1 = "-" + "0";
                        change = true;
                        zero = true;
                    } else {
                        numbers1 = "0";
                        change = false;
                        zero = true;
                    }
                } else {
                    if (!change) {
                        numbers1 = "-" + numbers1;
                        change = true;
                    } else {
                        numbers1 = numbers1.substring(1);
                        change = false;
                    }
                }

                break;
        }
        text.setText(numbers1);
    }

    public void clickOperarion(View view) {
        isNew = true;
        oldNumber = text.getText().toString();
        switch (view.getId()) {
            case R.id.buttonMinus:
                operator = "-";
                break;
            case R.id.buttonPlus:
                operator = "+";
                break;
            case R.id.buttonDele:
                operator = "/";
                break;
            case R.id.buttonX:
                operator = "*";
                break;
        }
    }

    public void clickResult(View view) {
        String newNumber = text.getText().toString();
        Double result = 0.0;
        switch (operator) {
            case "-":
                result = Double.parseDouble(oldNumber) - Double.parseDouble(newNumber);
                break;
            case "+":
                result = Double.parseDouble(oldNumber) + Double.parseDouble(newNumber);
                break;
            case "/":
                result = Double.parseDouble(oldNumber) / Double.parseDouble(newNumber);
                break;
            case "*":
                result = Double.parseDouble(oldNumber) * Double.parseDouble(newNumber);
                break;
        }
        text.setText(String.valueOf(result));
    }

}