package com.merveyanar.ilkprojeyardimcim;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class GirisSecimActivity extends AppCompatActivity {
    private Button buttonKullanici,buttonBakici;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_giris_secim);

        buttonBakici=(Button)findViewById(R.id.buttonBakici);
        buttonKullanici=(Button)findViewById(R.id.buttonKullanici);

        buttonKullanici.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getBaseContext(), MainActivity.class);//Aile Giriş işlemlerine götürür..

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
