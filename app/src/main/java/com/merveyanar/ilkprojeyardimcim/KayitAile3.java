package com.merveyanar.ilkprojeyardimcim;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class KayitAile3 extends AppCompatActivity {

    private EditText hastaAd,hastaSoyad,hastaDogumTarihi;
    private Spinner hastaspinnergender,hastaspinnercare;
    private String had,hsoyad,hdogumtarihi,hgender,hcare;
    private Button buttonRegisterA3;
    private FirebaseAuth mAuth;
    private FirebaseDatabase database;
    private DatabaseReference databaseReference;
    private DatabaseReference databaseReferenceAile;
    private TextView ailemail, ailesifre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register3);

        hastaAd = (EditText) findViewById(R.id.hastaAd);
        hastaSoyad = (EditText) findViewById(R.id.hastaSoyad);
        hastaDogumTarihi = (EditText) findViewById(R.id.hastaDogumTarihi);
        hastaspinnergender = (Spinner) findViewById(R.id.hastaspinnerGender);
        hastaspinnercare = (Spinner) findViewById(R.id.hastaspinnerCare);
        buttonRegisterA3 = (Button) findViewById(R.id.buttonRegisterA3);
        ailemail = (TextView) findViewById(R.id.txtailemail);
        ailesifre = (TextView) findViewById(R.id.txtailesifre);

        mAuth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();
        databaseReference = FirebaseDatabase.getInstance().getReference("aile");

        buttonRegisterA3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                had = hastaAd.getText().toString();
                hsoyad = hastaSoyad.getText().toString();
                hdogumtarihi = hastaDogumTarihi.getText().toString();
                hgender = hastaspinnergender.getSelectedItem().toString();
                hcare = hastaspinnercare.getSelectedItem().toString();

                if(hgender.isEmpty() || had.isEmpty() || hsoyad.isEmpty() || hdogumtarihi.isEmpty() || hcare.isEmpty()){

                    Toast.makeText(getApplicationContext(),"Lütfen gerekli alanları doldurunuz!",Toast.LENGTH_SHORT).show();

                }else{
                    registerFunction();
                }
            }
        });
    }

    private void registerFunction() {

        FirebaseUser user = mAuth.getCurrentUser();

        Bundle extras = getIntent().getExtras();
        final String mail = extras.getString("email");
        final String sifre = extras.getString("sifre");
        final String ad = extras.getString("ad");
        final String soyad = extras.getString("soyad");
        final String sifretekrar = extras.getString("sifretekrar");
        final String adres = extras.getString("adres");
        final String cinsiyet = extras.getString("cinsiyet");
        final String medenidurum = extras.getString("medeni");
        final String egitim = extras.getString("egitim");
        final String sehir = extras.getString("sehir");
        final String telefon = extras.getString("telefon");

        mAuth.createUserWithEmailAndPassword(mail,sifre)
                .addOnCompleteListener(KayitAile3.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(Task<AuthResult> task) {
                        if (!task.isSuccessful()) {
                            Toast.makeText(KayitAile3.this, "Yetkilendirme Hatası",
                                    Toast.LENGTH_SHORT).show();
                        }

                        else {

                            databaseReferenceAile = FirebaseDatabase.getInstance().getReference("aile/"+FirebaseAuth.getInstance().getCurrentUser().getUid());
                            AileModel aileModel = new AileModel(ad,soyad,adres,mail,sifre,sifretekrar,telefon,medenidurum,egitim,cinsiyet,sehir,had,hsoyad,hgender,hcare,hdogumtarihi,"");
                            databaseReferenceAile.setValue(aileModel);
                            startActivity(new Intent(KayitAile3.this, AileNavDrawer.class));
                            finish();
                        }
                    }
                });

    }
}
