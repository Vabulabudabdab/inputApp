package com.example.inputapp;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    private EditText textIn;
    private TextView textOut;

    private static HashMap<String, String> ruEn = new HashMap<>();
    private static HashMap<String, String> enRu = new HashMap<>();

    private String radioValue = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dataInfo();

        textIn = findViewById(R.id.textIn); //input
        textOut = findViewById(R.id.textOut); //output
        RadioButton btnRuEn = findViewById(R.id.radioButtonEnRu);
        RadioButton btnEnRu = findViewById(R.id.radioButtonRuEn);
        Button btn = findViewById(R.id.button);//translate button

        //Listeners
        btnRuEn.setOnClickListener(listenerRadio);
        btnEnRu.setOnClickListener(listenerRadio);
        btn.setOnClickListener(listener);

        }


        private View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String dataIn = "";

                dataIn = textIn.getText().toString();

                switch (radioValue) {
                    case "ru":
                        textOut.setText(ruEn.get(dataIn));
                        if (ruEn.get(dataIn) == null) {
                            textOut.setText("Не найдено");
                        }
                        break;
                    case "en":
                        textOut.setText(enRu.get(dataIn));
                        if (enRu.get(dataIn) == null) {
                            textOut.setText("В словаре такого не нашлось");
                        }
                        break;
                    default:
                        textOut.setText("Вы не выбрали настройку");
                }
            }
        };


    private View.OnClickListener listenerRadio = new View.OnClickListener()  {

        @Override
        public void onClick(View v) {
            RadioButton radioBtn = (RadioButton) v;

            switch (radioBtn.getId()) {

                case R.id.radioButtonRuEn:
                    radioValue = "ru";
                    break;
                case R.id.radioButtonEnRu:
                    radioValue = "en";
                    break;
                default:
                    radioValue = "empty";
                    break;
            }
        }
    };


        public static void dataInfo() {
        //Русско-Англ
        ruEn.put("я","i");
        ruEn.put("ты","you");
        ruEn.put("он","he");
        ruEn.put("она","she");
        ruEn.put("мы","we");
        ruEn.put("они","they");
        ruEn.put("оно","it");
        //Англо-Русск
        enRu.put("i","я");
        enRu.put("you","ты");
        enRu.put("he","он");
        enRu.put("she","она");
        enRu.put("we","мы");
        enRu.put("they","они");
        enRu.put("it","оно");
        }

    }