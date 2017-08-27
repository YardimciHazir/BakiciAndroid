package com.merveyanar.ilkprojeyardimcim;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by 7 on 01.08.2017.
 */

public class RegisterActivity extends AppCompatActivity {
    private EditText aileFirstName,aileLastName,aileAddress,aileEmail,ailePassword,ailePasswordConfirm;
    private Button buttonRegisterA;
    private String userFirstName,userLastName,useraddress,useremail,userpassword,userpasswordconfirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        aileFirstName = (EditText) findViewById(R.id.aileFirstName);
        aileLastName = (EditText) findViewById(R.id.aileLastName);
        aileAddress = (EditText) findViewById(R.id.aileAddress);
        aileEmail = (EditText) findViewById(R.id.aileEmail);
        ailePassword = (EditText) findViewById(R.id.ailePassword);
        ailePasswordConfirm = (EditText) findViewById(R.id.ailePasswordConfirm);
        buttonRegisterA = (Button) findViewById(R.id.buttonRegisterA);

        buttonRegisterA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userFirstName = aileFirstName.getText().toString();
                userLastName = aileLastName.getText().toString();
                useraddress = aileAddress.getText().toString();
                useremail = aileEmail.getText().toString();
                userpassword = ailePassword.getText().toString();
                userpasswordconfirm = ailePasswordConfirm.getText().toString();

                if(userFirstName.isEmpty() || userLastName.isEmpty() || useraddress.isEmpty() || useremail.isEmpty() || userpassword.isEmpty() || userpasswordconfirm.isEmpty()){

                    Toast.makeText(getApplicationContext(),"Lütfen gerekli alanları doldurunuz!",Toast.LENGTH_SHORT).show();

                }else{
//                    registerFunction();

                    String mail = useremail;
                    String sifre = userpassword;
                    String ad = userFirstName;
                    String soyad = userLastName;
                    String adres = useraddress;
                    String sifretekrar = userpasswordconfirm;
                    Intent i = new Intent(getApplicationContext(), RegisterActivity2.class);
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
