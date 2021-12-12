package com.anushabhattacharya.numbersystemconverterandcalculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;


import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Vibrator;

import java.util.Objects;


public class MainActivity extends AppCompatActivity {

    int len;
    Button convert;
    private Vibrator myVib;
    TextView number, fromSystem, toSystem, resultText;
    int from = 1, to = 0;
    protected String numberValue = "", currentDigit = "", result = "";
    String[] listItems = {"Binary", "Decimal", "Octal", "Hexadecimal"};


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        super.onOptionsItemSelected(item);


        if (item.getItemId() == R.id.share) {
            Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
            sharingIntent.setType("text/plain");
            String shareBody = "Check it out";
            sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Subject");
            sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
            startActivity(Intent.createChooser(sharingIntent, "Share via"));
        }
        if (item.getItemId() == R.id.exit) {
            finish();
            System.exit(0);
        }
        return true;
    }


    /*------------------------------------------------Converter------------------------------------------*/
    public void convert(View view) {
        myVib.vibrate(50);
        String fromSysString = fromSystem.getText().toString();
        String toSysString = toSystem.getText().toString();
        Log.i("num", String.valueOf(numberValue));
        try {

            Conversion c = new Conversion(numberValue, fromSysString, toSysString);
            result = c.getN();
            if (!result.equals("")) {
                resultText.setText(result);
                Log.i("", result);
            } else {
                resultText.setText("");
                Toast.makeText(this, "Error! Please check your input!", Toast.LENGTH_SHORT).show();
            }
        } catch (Exception e) {
            e.printStackTrace();
            resultText.setText("");
            Toast.makeText(this, "Error! Please check your input!", Toast.LENGTH_SHORT).show();
        }
    }


    /*------------------------------------------------Get the Digit------------------------------------------*/
    public void getDigit(View view) {
        myVib.vibrate(20);
        len = numberValue.length();
        number = findViewById(R.id.number);
        if (len <= 14) {
            GetNumber getNumber = new GetNumber(view);
            String digit = getNumber.getD();
            currentDigit = digit;
            ValidityChecker validityChecker = new ValidityChecker(digit, fromSystem, toSystem);
            if (validityChecker.checked()) {
                numberValue = numberValue + digit;
                number.setText(numberValue);
            } else {
                validityChecker.makeToast(this);
            }
        } else {
            Toast.makeText(this, "Insertion limited to 14 digit!", Toast.LENGTH_SHORT).show();
        }
    }






    /*------------------------------------------------Delete Button action------------------------------------------*/

    public void deleteDigit(View view) {
        myVib.vibrate(20);
        try {
            len = numberValue.length() - 1;


            /*if (".".equals(String.valueOf(numberValue.charAt(len)))) {
                flag = 0;
            }*/


            if (len >= 0) {
                numberValue = numberValue.substring(0, len);
                number.setText(numberValue);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }









    /*------------------------------------------------Clear Button action------------------------------------------*/

    public void clear(View view) {
        myVib.vibrate(20);
        numberValue = "";
        number.setText(numberValue);
    }







    /*------------------------------------------------Point Button action------------------------------------------

    public void point(View view)
    {
        if(numberValue.length()==0)
        {
            flag=0;
        }
        if (flag==0) {
            flag=1;
            numberValue = numberValue + ".";
            number = findViewById(R.id.number);
            number.setText(numberValue);
        }

    }*/


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fromSystem = findViewById(R.id.fromSystem);
        toSystem = findViewById(R.id.toSystem);
        fromSystem.setText(listItems[from]);
        toSystem.setText(listItems[to]);
        number = findViewById(R.id.number);
        resultText = findViewById(R.id.result);
        number.setFocusable(true);
        number.setEnabled(false);
        number.setCursorVisible(false);

        myVib = (Vibrator) this.getSystemService(VIBRATOR_SERVICE);
        convert = this.findViewById(R.id.convert);


    }














    /*------------------------------------------------fromSystem------------------------------------------*/

    public void fromSys(View view) {
        myVib.vibrate(30);
        //numberValue="";
        from = (from % 4) + 1;
        //number.setText(numberValue);
        fromSystem = findViewById(R.id.fromSystem);
        fromSystem.setText(listItems[from % 4]);
        //from=(from%4)+1;
        //Log.i("from",String.valueOf(from));

    }













    /*------------------------------------------------fromSystem------------------------------------------*/

    public void toSys(View view) {
        myVib.vibrate(30);
        toSystem = findViewById(R.id.toSystem);
        toSystem.setText(listItems[to % 4]);
        to = (to % 4) + 1;
        //Log.i("to",String.valueOf(to));
    }


    public void copyToClipboard2(View view) {

        android.content.ClipboardManager clipboard = (android.content.ClipboardManager) this.getSystemService(Context.CLIPBOARD_SERVICE);
        android.content.ClipData clip = android.content.ClipData.newPlainText("Copied Text", result);
        Toast.makeText(this, "Result copied to Clipboard", Toast.LENGTH_SHORT).show();
        clipboard.setPrimaryClip(clip);
    }

    public void copyToClipboard1(View view) {
        ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
        try {
            CharSequence textToPaste = Objects.requireNonNull(clipboard.getPrimaryClip()).getItemAt(0).getText();
            number.setText(textToPaste);
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(this, "Nothing to paste!", Toast.LENGTH_SHORT).show();
        }


       /*android.content.ClipboardManager clipboard = (android.content.ClipboardManager) this.getSystemService(Context.CLIPBOARD_SERVICE);
        android.content.ClipData clip = android.content.ClipData.newPlainText("Copied Text", numberValue);
        Toast.makeText(this, "Input number copied to clipboard", Toast.LENGTH_SHORT).show();
        clipboard.setPrimaryClip(clip);*/
    }
}

