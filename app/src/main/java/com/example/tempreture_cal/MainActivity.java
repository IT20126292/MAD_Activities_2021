package com.example.tempreture_cal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText Temp_iNPUT;
    RadioButton rd_Celcius;
    RadioButton rd_Faren;
    Button btn_Cal;
    TextView tview_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Temp_iNPUT = findViewById(R.id.Temp_iNPUT);
        rd_Celcius = findViewById(R.id.rd_Celcius);
        rd_Faren = findViewById(R.id.rd_Faren);
        btn_Cal = findViewById(R.id.btn_Cal);
        tview_result = findViewById(R.id.tview_result);

    }

    @Override
    protected void onResume() {
         super.onResume();
         btn_Cal.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 calculateAnswer();
             }
         });
    }

    public void calculateAnswer() {
        Calculations cal = new Calculations();
        String value = Temp_iNPUT.getText().toString();

        if(TextUtils.isEmpty(value)){
            Toast.makeText(this, "Enter the tempreture", Toast.LENGTH_SHORT).show();

        }else{
            Float inValue = Float.parseFloat(value);
            if(rd_Celcius.isChecked()){
                inValue = cal.convertCelciusToFahrenheit(inValue);

            }else if(rd_Faren.isChecked()){
                inValue = cal.convertFahrenheitToCelcius(inValue);

            }else{
                Toast.makeText(this, "Please select radio button!!", Toast.LENGTH_SHORT).show();
                inValue = 0.0f;
            }

            tview_result.setText(new Float(inValue).toString());
        }
    }
}