package com.anushabhattacharya.numbersystemconverterandcalculator;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.text.InputType;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class Calculator extends AppCompatActivity {
    private Vibrator myVib;

    int fn=1;
    protected String result = "",num1,num2;
    TextView resultText,bin,dec,hex,oct;
    EditText firstText,secondText;
    int type=-1;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        super.onOptionsItemSelected(item);


        if (item.getItemId() == R.id.share){
            Intent sharingIntent = new Intent(Intent.ACTION_SEND);
            sharingIntent.setType("text/plain");
            String shareBody = "Check it out";
            sharingIntent.putExtra(Intent.EXTRA_SUBJECT, "Subject");
            sharingIntent.putExtra(Intent.EXTRA_TEXT, shareBody);
            startActivity(Intent.createChooser(sharingIntent, "Share via"));
        }
        if (item.getItemId()==R.id.exit){
            finish();
            System.exit(0);
        }
        return true;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);


        myVib = (Vibrator) this.getSystemService(VIBRATOR_SERVICE);



        bin=findViewById(R.id.bin);
        dec=findViewById(R.id.dec);
        oct=findViewById(R.id.oct);
        hex=findViewById(R.id.hex);


        firstText=findViewById(R.id.firstnum);
        secondText=findViewById(R.id.secondnum);
        resultText=findViewById(R.id.result);

    }









        public void add (View view){
            if(type==-1)
            {
                Toast.makeText(this, "Select the number system first!", Toast.LENGTH_SHORT).show();
                return;
            }
            fn=1;
            myVib.vibrate(50);
            try {
                num1 = firstText.getText().toString();
                num2 = secondText.getText().toString();
                if(num1.length()>10 || num2.length()>10){
                    Toast.makeText(this, "Input is limited to 10 digits!", Toast.LENGTH_SHORT).show();
                    return;
                } else if (num1.contains(".") || num2.contains(".")){
                    Toast.makeText(this, "Fractional numbers aren't available yet!", Toast.LENGTH_SHORT).show();
                    return;
                }
                Addition addition = new Addition(num1, num2, type, fn);
                result = addition.getResultText();
                resultText.setText(result);
            }
            catch(Exception e)
            {
                e.printStackTrace();
                Toast.makeText(this, "Error! Please check your input", Toast.LENGTH_SHORT).show();
            }
        }

        public void subtract (View view){
            if(type==-1)
            {
                Toast.makeText(this, "Select the number system first!", Toast.LENGTH_SHORT).show();
                return;
            }
            fn=2;
            myVib.vibrate(30);
            try {
            num1=firstText.getText().toString();
            num2=secondText.getText().toString();

            if(num1.length()>10 || num2.length()>10){
                Toast.makeText(this, "Input is limited to 10 digits!", Toast.LENGTH_SHORT).show();
                return;
            } else if (num1.contains(".") || num2.contains(".")){
                Toast.makeText(this, "Fractional numbers aren't available yet!", Toast.LENGTH_SHORT).show();
                return;
            }
            Addition addition=new Addition(num1, num2,type,fn);
            result=addition.getResultText();
            resultText.setText(result);
            }
            catch(Exception e)
            {
                e.printStackTrace();
                Toast.makeText(this, "Error! Please check your input", Toast.LENGTH_SHORT).show();
            }

        }

        public void multiply (View view){
            if(type==-1)
            {
                Toast.makeText(this, "Select the number system first!", Toast.LENGTH_SHORT).show();
                return;
            }
            fn=3;
            myVib.vibrate(30);
            try {
            num1=firstText.getText().toString();
            num2=secondText.getText().toString();
                if(num1.length()>10 || num2.length()>10){
                    Toast.makeText(this, "Input is limited to 10 digits!", Toast.LENGTH_SHORT).show();
                    return;
                } else if (num1.contains(".") || num2.contains(".")){
                    Toast.makeText(this, "Fractional numbers aren't available yet!", Toast.LENGTH_SHORT).show();
                    return;
                }
            Addition addition=new Addition(num1, num2,type,fn);
            result=addition.getResultText();
            resultText.setText(result);
            }
            catch(Exception e)
            {
                e.printStackTrace();
                Toast.makeText(this, "Error! Please check your input", Toast.LENGTH_SHORT).show();
            }
        }

        public void Divide (View view){
            if(type==-1)
            {
                Toast.makeText(this, "Select the number system first!", Toast.LENGTH_SHORT).show();
                return;
            }
            fn=4;
            myVib.vibrate(30);
            try {
            num1=firstText.getText().toString();
            num2=secondText.getText().toString();
                if(num1.length()>10 || num2.length()>10){
                    Toast.makeText(this, "Input is limited to 10 digits!", Toast.LENGTH_SHORT).show();
                    return;
                } else if (num1.contains(".") || num2.contains(".")){
                    Toast.makeText(this, "Fractional numbers aren't available yet!", Toast.LENGTH_SHORT).show();
                    return;
                }
            Addition addition=new Addition(num1, num2,type, fn);
            result=addition.getResultText();
            resultText.setText(result);
            }
            catch(Exception e)
            {
                e.printStackTrace();
                Toast.makeText(this, "Error! Please check your input", Toast.LENGTH_SHORT).show();
            }
        }


        public void copyToClipboard (View view){

            android.content.ClipboardManager clipboard = (android.content.ClipboardManager) this.getSystemService(Context.CLIPBOARD_SERVICE);
            android.content.ClipData clip = android.content.ClipData.newPlainText("Copied Text", result);
            Toast.makeText(this, "Result copied to Clipboard", Toast.LENGTH_SHORT).show();
            clipboard.setPrimaryClip(clip);
        }


    public void bin(View view) {
        firstText.setInputType(InputType.TYPE_CLASS_NUMBER);
        secondText.setInputType(InputType.TYPE_CLASS_NUMBER);
        myVib.vibrate(50);
        type=1;
        bin.setTextColor(getResources().getColor(R.color.white));
        hex.setTextColor(getResources().getColor(R.color.buttonColor));
        dec.setTextColor(getResources().getColor(R.color.buttonColor));
        oct.setTextColor(getResources().getColor(R.color.buttonColor));
        bin.setBackgroundResource(R.drawable.rounded_button);
        dec.setBackgroundResource(R.drawable.rounded_button_white);
        oct.setBackgroundResource(R.drawable.rounded_button_white);
        hex.setBackgroundResource(R.drawable.rounded_button_white);

    }

    public void oct(View view) {
        firstText.setInputType(InputType.TYPE_CLASS_NUMBER);
        secondText.setInputType(InputType.TYPE_CLASS_NUMBER);
        type=3;
        myVib.vibrate(50);
        oct.setTextColor(getResources().getColor(R.color.white));
        bin.setTextColor(getResources().getColor(R.color.buttonColor));
        dec.setTextColor(getResources().getColor(R.color.buttonColor));
        hex.setTextColor(getResources().getColor(R.color.buttonColor));
        oct.setBackgroundResource(R.drawable.rounded_button);
        dec.setBackgroundResource(R.drawable.rounded_button_white);
        bin.setBackgroundResource(R.drawable.rounded_button_white);
        hex.setBackgroundResource(R.drawable.rounded_button_white);


    }

    public void dec(View view) {
        firstText.setInputType(InputType.TYPE_CLASS_NUMBER);
        secondText.setInputType(InputType.TYPE_CLASS_NUMBER);
        type=2;
        myVib.vibrate(50);
        dec.setTextColor(getResources().getColor(R.color.white));
        oct.setTextColor(getResources().getColor(R.color.buttonColor));
        bin.setTextColor(getResources().getColor(R.color.buttonColor));
        hex.setTextColor(getResources().getColor(R.color.buttonColor));
        dec.setBackgroundResource(R.drawable.rounded_button);
        bin.setBackgroundResource(R.drawable.rounded_button_white);
        oct.setBackgroundResource(R.drawable.rounded_button_white);
        hex.setBackgroundResource(R.drawable.rounded_button_white);

    }

    public void hex(View view) {
        firstText.setInputType(InputType.TYPE_CLASS_TEXT);
        secondText.setInputType(InputType.TYPE_CLASS_TEXT);
        type=4;
        myVib.vibrate(50);
        hex.setTextColor(getResources().getColor(R.color.white));
        bin.setTextColor(getResources().getColor(R.color.buttonColor));
        dec.setTextColor(getResources().getColor(R.color.buttonColor));
        oct.setTextColor(getResources().getColor(R.color.buttonColor));
        hex.setBackgroundResource(R.drawable.rounded_button);
        dec.setBackgroundResource(R.drawable.rounded_button_white);
        oct.setBackgroundResource(R.drawable.rounded_button_white);
        bin.setBackgroundResource(R.drawable.rounded_button_white);

    }

    public void Mod(View view) {
        if(type==-1)
        {
            Toast.makeText(this, "Select the number system first!", Toast.LENGTH_SHORT).show();
            return;
        }
        fn=5;
        myVib.vibrate(30);
        try {
        num1=firstText.getText().toString();
        num2=secondText.getText().toString();
            if(num1.length()>10 || num2.length()>10){
                Toast.makeText(this, "Input is limited to 10 digits!", Toast.LENGTH_SHORT).show();
                return;
            } else if (num1.contains(".") || num2.contains(".")){
                Toast.makeText(this, "Fractional numbers aren't available yet!", Toast.LENGTH_SHORT).show();
                return;
            }
        Addition addition=new Addition(num1, num2,type, fn);
        result=addition.getResultText();
        resultText.setText(result);
        }
        catch(Exception e)
        {
            e.printStackTrace();
            Toast.makeText(this, "Error! Please check your input", Toast.LENGTH_SHORT).show();
        }

    }
}

