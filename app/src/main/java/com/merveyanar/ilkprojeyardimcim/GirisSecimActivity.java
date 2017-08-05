package com.merveyanar.ilkprojeyardimcim;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class GirisSecimActivity extends AppCompatActivity {
    private Button buttonAile,buttonGonullu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_giris_secim);

        buttonGonullu=(Button)findViewById(R.id.buttonGonullu);
        buttonAile=(Button)findViewById(R.id.buttonAile);

        buttonAile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getBaseContext(), MainActivity.class);//Aile Giriş işlemlerine götürür..

                startActivity(i);

                finish();// Eğer sayfa açıldıktan sonra bu sayfaya tekrar Back butonu ile dönülmesini istemiyorsak finish() metodu ile Activty'i sonlandırıyoruz.

            }
        });
        buttonGonullu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getBaseContext(), MainGonulluActivity.class);//Bakıcı Giriş işlemlerine götürür.

                startActivity(i);

                finish();// Eğer sayfa açıldıktan sonra bu sayfaya tekrar Back butonu ile dönülmesini istemiyorsak finish() metodu ile Activty'i sonlandırıyoruz.

            }
        });
    }
}
