package com.merveyanar.ilkprojeyardimcim;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Spinner;

public class RegisterBakiciActivity2 extends AppCompatActivity {

    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_bakici2);

        spinner = (Spinner)findViewById(R.id.spinnerGender);
        String[] items = new String[]{"Erkek", "Kadın"};
    }
}
