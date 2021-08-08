package com.gigi.mytempappwe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn=findViewById(R.id.btnCalculate);
    }
    @Override
    protected void onResume() {
        super.onResume();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateAnswer();
            }
        });
    }
    private void calculateAnswer()
    {
        EditText et=findViewById(R.id.etTemp);
        String s=et.getText().toString();
        if(s.equals("")){
                    Toast.makeText(this, "Please add a value", Toast.LENGTH_LONG).show();
        }
        else{
            Float f=0.0f;
            Boolean error=Boolean.FALSE;
            try {
                f=Float.parseFloat(s);
            }
            catch(NumberFormatException e)
            {
                Toast.makeText(this, "Invalid value", Toast.LENGTH_LONG).show();
                error=Boolean.TRUE;
            }
            if(!error) {
                RadioGroup rg=findViewById(R.id.rgTemp);
                int i=rg.getCheckedRadioButtonId();
                Float ans=0.0f;

                if (i==R.id.rbCelcius) {
                    ans=convertFahrenheitToCelcius(f);


                } else {
                    ans=convertCelciusToFahrenheit(f);
                }


                TextView tv=findViewById(R.id.tvResults);
                tv.setText(ans+"");
            }

        }




    }
    protected float convertCelciusToFahrenheit(Float value) { Float ans = (value - 32) * 5/9;
        return ans;
    }
    protected float convertFahrenheitToCelcius(Float value) { Float ans = (value * 9/5) + 32;
        return ans;
    }


}