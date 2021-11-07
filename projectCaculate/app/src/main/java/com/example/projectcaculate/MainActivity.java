package com.example.projectcaculate;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

public class MainActivity extends AppCompatActivity {


    Button btn_ce, btn_c, btn_7, btn_8, btn_9, btn_4, btn_5, btn_6, btn_1, btn_2, btn_3, btn_switch, btn_0;
    ImageButton btn_backspace, btn_devide, btn_mul, btn_minus, btn_add, btn_dot, btn_equal;

    TextView inputData, outPutData;

    String data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputData = findViewById(R.id.caculateOperator);
        outPutData = findViewById(R.id.showCaculate);

        btn_0 = findViewById(R.id.btn_0);
        btn_1 = findViewById(R.id.btn_1);
        btn_2 = findViewById(R.id.btn_2);
        btn_3 = findViewById(R.id.btn_3);
        btn_4 = findViewById(R.id.btn_4);
        btn_5 = findViewById(R.id.btn_5);
        btn_6 = findViewById(R.id.btn_6);
        btn_7 = findViewById(R.id.btn_7);
        btn_8 = findViewById(R.id.btn_8);
        btn_9 = findViewById(R.id.btn_9);

        btn_dot = findViewById(R.id.btn_dot);
        btn_equal = findViewById(R.id.btn_equal);
        btn_ce = findViewById(R.id.btn_ce);
        btn_c = findViewById(R.id.btn_c);
        btn_add = findViewById(R.id.btn_add);
        btn_minus = findViewById(R.id.btn_minus);
        btn_mul = findViewById(R.id.btn_mul);
        btn_switch = findViewById(R.id.btn_switch);
        btn_backspace = findViewById(R.id.btn_clear);
        btn_devide = findViewById(R.id.btn_div);

        btn_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = inputData.getText().toString();
                inputData.setText(data + "0");
            }
        });
        btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = inputData.getText().toString();
                inputData.setText(data + "1");
            }
        });
        btn_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = inputData.getText().toString();
                inputData.setText(data + "2");
            }
        });
        btn_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = inputData.getText().toString();
                inputData.setText(data + "3");
            }
        });
        btn_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = inputData.getText().toString();
                inputData.setText(data + "4");
            }
        });
        btn_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = inputData.getText().toString();
                inputData.setText(data + "5");
            }
        });
        btn_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = inputData.getText().toString();
                inputData.setText(data + "6");
            }
        });
        btn_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = inputData.getText().toString();
                inputData.setText(data + "7");
            }
        });
        btn_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = inputData.getText().toString();
                inputData.setText(data + "8");
            }
        });
        btn_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = inputData.getText().toString();
                inputData.setText(data + "9");
            }
        });
        btn_c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputData.setText("");
                outPutData.setText("");
            }
        });
        btn_dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = inputData.getText().toString();
                inputData.setText(data + ".");
            }
        });

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = inputData.getText().toString();
                inputData.setText(data + "+");
            }
        });
        btn_mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = inputData.getText().toString();
                inputData.setText(data + "X");
            }
        });

        btn_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = inputData.getText().toString();
                inputData.setText(data + "-");
            }
        });

        btn_equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = inputData.getText().toString();

                data=data.replaceAll("x","*");
                data=data.replaceAll("%","/100");
                data=data.replaceAll("÷","/");

                org.mozilla.javascript.Context rhino= Context.enter();
                rhino.setOptimizationLevel(-1);

                String finalResult="";

                Scriptable scriptable=rhino.initStandardObjects();
                finalResult=rhino.evaluateString(scriptable,data,"Javsscript",1,null).toString();

                outPutData.setText(finalResult);

            }
        });


    }

}