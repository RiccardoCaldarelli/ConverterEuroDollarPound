package com.example.riccardocaldarelli.convertereurodollarpound;

import android.content.Context;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.nio.charset.Charset;

public class MainActivity extends AppCompatActivity {

    Button reset;
    EditText euro;
    EditText dollar;
    EditText pound;

    public class percentage{
        public static final double DOLLAR_CONVESION = 84.04;
        public static final double POUND_CONVESION = 113.43;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        reset = findViewById(R.id.reset);
        euro = findViewById(R.id.euro);
        dollar = findViewById(R.id.dollar);
        pound = findViewById(R.id.pound);
        reset.setOnClickListener(new MyOnClickListener());

        euro.addTextChangedListener(new TextWatcher(){

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                double value;
                double value2;
                double value3;

                value= Double.parseDouble(euro.getText().toString());

                if(value>0)
                {

                    value3= value * percentage.POUND_CONVESION /100;
                    value2= value * percentage.DOLLAR_CONVESION /100;
                }
                else
                {
                    value2=0.0;
                    value3=0.0;
                    value=0.0;
                }

                euro.setText(""+value);
                pound.setText(""+value3);
                dollar.setText(""+value2);
            }


            @Override
            public void afterTextChanged(Editable s) {}
        });

        dollar.addTextChangedListener(new TextWatcher(){

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                double value;
                double value2;
                double value3;

                value2= Double.parseDouble(dollar.getText().toString());

                if(value2>0)
                {
                    value= value2 * 100 /percentage.DOLLAR_CONVESION;
                    value3= value * percentage.POUND_CONVESION /100;

                }
                else
                {
                    value2=0.0;
                    value3=0.0;
                    value=0.0;
                }

                euro.setText(""+value);
                pound.setText(""+value3);
                dollar.setText(""+value2);
            }


            @Override
            public void afterTextChanged(Editable s) {}
        });

        pound.addTextChangedListener(new TextWatcher(){

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                double value;
                double value2;
                double value3;

                value3= Double.parseDouble(pound.getText().toString());

                if(value3>0)
                {
                    value = value3 * 100 / percentage.POUND_CONVESION;
                    value2= value * percentage.DOLLAR_CONVESION /100;
                }
                else
                {
                    value2=0.0;
                    value3=0.0;
                    value=0.0;
                }

                euro.setText(""+value);
                pound.setText(""+value3);
                dollar.setText(""+value2);
            }


            @Override
            public void afterTextChanged(Editable s) {}
        });
    }

    private class MyOnClickListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {

            euro.setText("");
            pound.setText("");
            dollar.setText("");


        }
    }

}
