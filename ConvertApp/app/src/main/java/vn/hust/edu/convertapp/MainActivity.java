package vn.hust.edu.convertapp;


import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;



public class MainActivity extends AppCompatActivity {

    int len;
    Button convert;
    TextView number, resultText;
    String from = "", to = "";
    protected String numberValue = "", currentDigit = "", result = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner fromSpinner = (Spinner) findViewById(R.id.fromSpinner);

        final ArrayList<String> listItem1 = new ArrayList<String>();
        listItem1.add("Binary");
        listItem1.add("Decimal");
        listItem1.add("Octal");
        listItem1.add("Hexadecimal");

        ArrayAdapter adapter1 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, listItem1);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        fromSpinner.setAdapter(adapter1);
        fromSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                from = parent.getItemAtPosition(position).toString();
                Toast.makeText(parent.getContext(), "Converted from " + from, Toast.LENGTH_LONG).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        Spinner toSpinner = (Spinner) findViewById(R.id.toSpinner);

        final ArrayList<String> listItem2 = new ArrayList<String>();
        listItem2.add("Binary");
        listItem2.add("Decimal");
        listItem2.add("Octal");
        listItem2.add("Hexadecimal");

        ArrayAdapter adapter2 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, listItem2);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        toSpinner.setAdapter(adapter2);
        toSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                to = parent.getItemAtPosition(position).toString();
                Toast.makeText(parent.getContext(), "Convert to " + to, Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                //
            }
        });

        number = findViewById(R.id.number);
        resultText = findViewById(R.id.result);
        number.setFocusable(true);
        number.setEnabled(false);
        number.setCursorVisible(false);
        convert = this.findViewById(R.id.convert);

    }



    public void getDigit(View view) {
        len = numberValue.length();
        number = findViewById(R.id.number);
        if (len <= 14) {
            GetNumber getNumber = new GetNumber(view);
            String digit = getNumber.getD();
            currentDigit = digit;
            ValidityChecker validityChecker = new ValidityChecker(digit, from, to);
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


    public void deleteDigit(View view) {
        try {
            len = numberValue.length() - 1;

            if (len >= 0) {
                numberValue = numberValue.substring(0, len);
                number.setText(numberValue);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void clear(View view) {
        numberValue = "";
        number.setText(numberValue);
    }

    public void convert(View view) {
        Log.i("num", String.valueOf(numberValue));
        try {
            Conversion c = new Conversion(numberValue, from, to);
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

}

