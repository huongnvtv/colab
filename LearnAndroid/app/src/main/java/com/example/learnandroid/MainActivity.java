package com.example.learnandroid;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_open_second).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.setData(Uri.parse("http://www.hust.edu.vn"));
                intent.putExtra("int_value", 123);
                intent.putExtra("double_value", 3.14);
                intent.putExtra("string_value", "hello_word");
                Bundle bundle = new Bundle();
                bundle.putInt("param1",1234);
                bundle.putString("param2", "demo");
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        findViewById(R.id.button_calculate).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText editParam1 = findViewById(R.id.edit_param_1);
                EditText editParam2 = findViewById(R.id.edit_param_2);

                Intent intent = new Intent(MainActivity.this, CaculateActivity.class);
                intent.putExtra("param1", Integer.parseInt(editParam1.getText().toString()));
                intent.putExtra("param2", Integer.parseInt(editParam2.getText().toString()));

                startActivityForResult(intent, 123);

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 123){
            if(resultCode == Activity.RESULT_OK){
                int result = data.getIntExtra("result", 0);
                TextView textView = findViewById(R.id.textView);
                textView.setText(String.valueOf(result));
            }
        }
    }
}