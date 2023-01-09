package com.example.truecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    void hideVisibility(TextView text, TextView text11, TextView text22){
        text.setVisibility(View.VISIBLE);
        text11.setVisibility(View.GONE);
        text22.setVisibility(View.GONE);
    }
    void hideVisibility1(TextView text, TextView text11, TextView text22){
        text.setVisibility(View.GONE);
        text11.setVisibility(View.GONE);
        text22.setVisibility(View.VISIBLE);
    }
    void hideVisibility2(TextView text, TextView text11, TextView text22){
        text.setVisibility(View.GONE);
        text11.setVisibility(View.VISIBLE);
        text22.setVisibility(View.GONE);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText number1 = findViewById(R.id.editTextNumber);
        EditText number2 = findViewById(R.id.editTextNumber5);
        EditText op = findViewById(R.id.editTextNumber6);
        Button btn = findViewById(R.id.button);
        TextView text = findViewById(R.id.textView2);
        TextView text11 = findViewById(R.id.textView3);
        TextView text22 = findViewById(R.id.textView4);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text1 = number1.getText().toString();
                String text2 = number2.getText().toString();
                String text3 = op.getText().toString();

                if(!text1.isEmpty()&&!text2.isEmpty()&&!text3.isEmpty()){
                    double number1 = Integer.parseInt(text1);
                    double number2 = Integer.parseInt(text2);
                    double sum;
                    if(text3.equals("-")){
                        sum = number1 - number2;
                        String m = String.valueOf(sum);
                        hideVisibility(text,text11,text22);
                        text.setText(m);
                    }else if(text3.equals("+")){
                        sum = number1 + number2;
                        String m = String.valueOf(sum);
                        hideVisibility(text,text11,text22);
                        text.setText(m);
                    }else if(text3.equals("*")){
                        sum = number1 * number2;
                        String m = String.valueOf(sum);
                        hideVisibility(text,text11,text22);
                        text.setText(m);
                    } else if(text3.equals("/")){
                        sum = number1 / number2;
                        String m = String.valueOf(sum);
                        hideVisibility(text,text11,text22);
                        text.setText(m);
                    }else {
                        hideVisibility1(text,text11,text22);
                    }
                } else{
                    hideVisibility2(text,text11,text22);
                }
            }
        });
    }
}