package com.example.learnandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class CaculateActivity extends AppCompatActivity {

    TextView textViewLog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_caculate);

        textViewLog = findViewById(R.id.text_log);

        Intent intent = getIntent();
        int param1 = intent.getIntExtra("param1", 0);
        int param2 = intent.getIntExtra("param2", 0);

        int result = param1 + param2;
        intent.putExtra("result", result);
        setResult(Activity.RESULT_OK, intent);

        textViewLog.setText("Param 1" + param1 + "\nParam2" + param2 + "\nResult " + result);
        findViewById(R.id.button_finish).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}