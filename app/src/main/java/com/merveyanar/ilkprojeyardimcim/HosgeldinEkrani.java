package com.merveyanar.ilkprojeyardimcim;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class HosgeldinEkrani extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hosgeldin_ekrani);

        Thread zamanlayici=new Thread(){
            public void run(){
                try {
                    sleep(4000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    Intent intent=new Intent("com.merveyanar.ilkprojeyardimcim.GIRISSECIMACTIVITY");
                    startActivity(intent);
                }
            }
        };
        zamanlayici.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
    }

