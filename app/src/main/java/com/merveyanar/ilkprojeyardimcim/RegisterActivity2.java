package com.merveyanar.ilkprojeyardimcim;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class RegisterActivity2 extends AppCompatActivity {

    private Spinner ailespinnergender, ailespinnermarital, ailespinnereducation, ailespinnercity;
    private EditText ailetelefon;
    private String gender,marital,education,experience,city,telephone;
    private Button buttonRegisterA2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register2);

        ailespinnergender = (Spinner) findViewById(R.id.ailespinnerGender);
        ailespinnermarital = (Spinner) findViewById(R.id.ailespinnerMarital);
        ailespinnereducation = (Spinner) findViewById(R.id.ailespinnerEducation);
        ailespinnercity = (Spinner) findViewById(R.id.ailespinnerCity);
        ailetelefon = (EditText) findViewById(R.id.aileTelephone);
        buttonRegisterA2 = (Button) findViewById(R.id.buttonRegisterA2);

        buttonRegisterA2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gender = ailespinnergender.getSelectedItem().toString();
                marital = ailespinnermarital.getSelectedItem().toString();
                education = ailespinnereducation.getSelectedItem().toString();
                city = ailespinnercity.getSelectedItem().toString();
                telephone = ailetelefon.getText().toString();

                if(gender.isEmpty() || marital.isEmpty() || education.isEmpty() || city.isEmpty() || telephone.isEmpty()){

                    Toast.makeText(getApplicationContext(),"Lütfen gerekli alanları doldurunuz!",Toast.LENGTH_SHORT).show();

                }else{
//                    String mail = useremail;
                    Bundle extras = getIntent().getExtras();
                    final String mail = extras.getString("email");
                    final String sifre = extras.getString("sifre");
                    final String ad = extras.getString("ad");
                    final String soyad = extras.getString("soyad");
                    final String sifretekrar = extras.getString("sifretekrar");
                    final String adres = extras.getString("adres");
                    String cinsiyet = gender;
                    String medenidurum = marital;
                    String egitim = education;
                    String sehir = city;
                    String telefon = telephone;
                    Intent i = new Intent(getApplicationContext(), RegisterActivity3.class);
                    i.putExtra("cinsiyet",cinsiyet);
                    i.putExtra("medeni",medenidurum);
                    i.putExtra("egitim",egitim);
                    i.putExtra("sehir",sehir);
                    i.putExtra("telefon",telefon);
                    i.putExtra("email",mail);
                    i.putExtra("sifre",sifre);
                    i.putExtra("ad",ad);
                    i.putExtra("soyad",soyad);
                    i.putExtra("adres",adres);
                    i.putExtra("sifretekrar",sifretekrar);
                    startActivity(i);
                    finish();

                }
            }
        });
    }
}
