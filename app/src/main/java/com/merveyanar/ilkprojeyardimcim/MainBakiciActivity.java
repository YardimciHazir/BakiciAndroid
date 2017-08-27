package com.merveyanar.ilkprojeyardimcim;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainBakiciActivity extends AppCompatActivity {
    private EditText editTextUserName;
    private EditText editTextUserPassword;
    private Button buttonLoginBakici;
    private Button buttonRegisterBakici;
    private FirebaseAuth mAuth;
    private FirebaseUser firebaseUser;
    private String userName;
    private String userPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_bakici);


        editTextUserName = (EditText)findViewById(R.id.editTextUserName);
        editTextUserPassword = (EditText)findViewById(R.id.editTextUserPassword);
        buttonLoginBakici = (Button) findViewById(R.id.buttonLoginBakici);
        buttonRegisterBakici = (Button) findViewById(R.id.buttonRegisterBakici);

        mAuth = FirebaseAuth.getInstance();
        firebaseUser = mAuth.getCurrentUser(); // authenticated user

        if(firebaseUser != null){ // check user session

            Intent i = new Intent(MainBakiciActivity.this,ProfileBakiciActivity.class);
            startActivity(i);
            finish();
        }

        buttonLoginBakici.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                userName = editTextUserName.getText().toString();
                userPassword = editTextUserPassword.getText().toString();
                if(userName.isEmpty() || userPassword.isEmpty()){

                    Toast.makeText(getApplicationContext(),"Lütfen gerekli alanları doldurunuz!",Toast.LENGTH_SHORT).show();

                }else{

                    loginFunc();
                }
            }
        });

        buttonRegisterBakici.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainBakiciActivity.this,RegisterBakiciActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void loginFunc() {

        mAuth.signInWithEmailAndPassword(userName,userPassword).addOnCompleteListener(MainBakiciActivity.this,
                new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){

                            Intent i = new Intent(MainBakiciActivity.this,ProfileBakiciActivity.class);
                            startActivity(i);
                            finish();

                        }
                        else{
                            // hata
                            Toast.makeText(getApplicationContext(),task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                        }
                    }

                });
    }

}

