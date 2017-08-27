package com.merveyanar.ilkprojeyardimcim;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class GirisSecimActivity extends AppCompatActivity {
    private Button buttonAile,buttonBakici;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_giris_secim);

        buttonBakici = (Button)findViewById(R.id.buttonBakici);
        buttonAile = (Button)findViewById(R.id.buttonAile);

        buttonAile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(GirisSecimActivity.this, MainActivity.class);//Aile Giriş işlemlerine götürür..

                startActivity(i);

                finish();// Eğer sayfa açıldıktan sonra bu sayfaya tekrar Back butonu ile dönülmesini istemiyorsak finish() metodu ile Activty'i sonlandırıyoruz.

            }
        });
        buttonBakici.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getBaseContext(), MainBakiciActivity.class);//Bakıcı Giriş işlemlerine götürür.

                startActivity(i);

                finish();// Eğer sayfa açıldıktan sonra bu sayfaya tekrar Back butonu ile dönülmesini istemiyorsak finish() metodu ile Activty'i sonlandırıyoruz.

            }
        });
    }
}
