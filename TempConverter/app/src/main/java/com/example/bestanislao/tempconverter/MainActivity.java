package com.example.bestanislao.tempconverter;

import android.support.annotation.StringDef;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView showMeResult;
    private EditText editText;
    private Button celBtn;
    private Button FahrenheitBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showMeResult = (TextView) findViewById(R.id.textView2);
        editText = (EditText) findViewById(R.id.editText);
        celBtn = (Button) findViewById(R.id.button);
        FahrenheitBtn = (Button) findViewById(R.id.button2);

        celBtn.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {



                String editTextVal = editText.getText().toString();
                if(editTextVal.isEmpty()) {
                    Toast.makeText(getApplicationContext(),"Kindly enter temperature.",Toast.LENGTH_LONG ).show();
                } else {

                 double dEditText =Double.parseDouble(editTextVal);
                 double convertedValue = convertToCelsius(dEditText);

                 double finalresult = Math.round(convertedValue * 100.0)/100.0;
                    String result = String.valueOf(finalresult);
                    showMeResult.setText(result);
                }
            }
        });

        FahrenheitBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                String editTextVal = editText.getText().toString();
                if(editTextVal.isEmpty()) {
                    Toast.makeText(getApplicationContext(),"Kindly enter temperature.",Toast.LENGTH_LONG ).show();
                } else {

                    double dEditText =Double.parseDouble(editTextVal);
                    double convertedValue = convertToFahrenheit(dEditText);

                    double finalresult = Math.round(convertedValue * 100.0)/100.0;
                    String result = String.valueOf(convertedValue);
                    showMeResult.setText(result);
                }
            }
        });
    }

    public double convertToCelsius (double farVal) {

        double resultVal;
        resultVal = (farVal - 32)* 5/9;
        return resultVal;

    }
    public double convertToFahrenheit (double celVal) {

        double resultVal;
        resultVal = celVal * 9/5 +32;
        return resultVal;
    }
}
