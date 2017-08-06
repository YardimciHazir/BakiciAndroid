package com.merveyanar.ilkprojeyardimcim;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterBakiciActivity extends AppCompatActivity {
    private EditText bakiciFirstName,bakiciLastName,dateofBirth,email,password,passwordconfirm;
    private Button buttonRegisterB;
    private FirebaseAuth mAuth;
    private String userFirstName;
    private String userLastName;
    private String userdateofbirth;
    private String useremail;
    private String userpassword;
    private String userpasswordconfirm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_bakici);

        bakiciFirstName = (EditText)findViewById(R.id.bakiciFirstName);
        bakiciLastName = (EditText)findViewById(R.id.bakiciLastName);
        dateofBirth = (EditText)findViewById(R.id.dateofBirth);
        email = (EditText)findViewById(R.id.email);
        password = (EditText)findViewById(R.id.password);
        passwordconfirm = (EditText)findViewById(R.id.passwordconfirm);
        buttonRegisterB = (Button)findViewById(R.id.buttonRegisterB);

        mAuth = FirebaseAuth.getInstance();

        // register buton tiklaninca
        buttonRegisterB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Fragment fragment = null;
                userFirstName = bakiciFirstName.getText().toString();
                userLastName = bakiciLastName.getText().toString();
                userdateofbirth = dateofBirth.getText().toString();
                useremail = email.getText().toString();
                userpassword = password.getText().toString();
                userpasswordconfirm = passwordconfirm.getText().toString();

                if(userFirstName.isEmpty() || userLastName.isEmpty() || userdateofbirth.isEmpty() || useremail.isEmpty() || userpassword.isEmpty() || userpasswordconfirm.isEmpty()){

                    Toast.makeText(getApplicationContext(),"Lütfen gerekli alanları doldurunuz!",Toast.LENGTH_SHORT).show();

                }else{
                    FragmentManager fragmentManager = getSupportFragmentManager();
                    fragmentManager.beginTransaction().replace(R.id.fragment, fragment).commit();
                }

            }
        });
    }

}



