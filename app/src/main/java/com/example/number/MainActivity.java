package com.example.number;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView tvInfo;
    EditText etInput;
    Button bControl;

    public static int minValue = 1;
    public static int maxValue = 100;

    public static int currentValue;

    public static int randomValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvInfo = findViewById(R.id.textView);
        etInput = findViewById(R.id.editText);
        bControl = findViewById(R.id.button);

        MainActivity.randomValue = (int) (Math.random() * MainActivity.maxValue);
    }

    public void onClick(View view) {
            Toast toast;
            final EditText editText = (EditText) findViewById(R.id.editText);

            try {
                MainActivity.currentValue = Integer.parseInt(editText.getText().toString());
            } catch (NumberFormatException e) {
                toast = Toast.makeText(getApplicationContext(),
                        "Введено не число", Toast.LENGTH_SHORT);
                toast.show();
                return;
            }

            if (MainActivity.currentValue < MainActivity.minValue || MainActivity.currentValue > MainActivity.maxValue) {
                toast = Toast.makeText(getApplicationContext(),
                        "Число не в интервале", Toast.LENGTH_SHORT);
                toast.show();
                return;
            }

            if (MainActivity.currentValue == MainActivity.randomValue) {
                toast = Toast.makeText(getApplicationContext(),
                        "Вы угадали! Новое число загадано.", Toast.LENGTH_SHORT);
                toast.show();

                MainActivity.randomValue = (int) (Math.random() * MainActivity.maxValue);
            } else if (MainActivity.currentValue < MainActivity.randomValue) {
                toast = Toast.makeText(getApplicationContext(),
                        "Значение больше", Toast.LENGTH_SHORT);
                toast.show();
            } else if (MainActivity.currentValue > MainActivity.randomValue) {
                toast = Toast.makeText(getApplicationContext(),
                        "Значение меньше", Toast.LENGTH_SHORT);
                toast.show();
            }
        }
    }

