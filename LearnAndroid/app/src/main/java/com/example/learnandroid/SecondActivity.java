package com.example.learnandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Intent intent =  getIntent();
        Log.v("TAG",intent.getData().toString());
        Log.v("TAG",String.valueOf(intent.getIntExtra("int_value", 0)));
        Log.v("TAG", intent.getStringExtra("string_value"));

        Bundle bundle = new Bundle();
        Log.v("TAG",String.valueOf(bundle.getInt("param1")));
    }
}