package com.merveyanar.ilkprojeyardimcim;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class RegisterBakiciActivity extends AppCompatActivity {
    private EditText bakiciFirstName,bakiciLastName,dateofBirth,email,password,passwordconfirm;
    private Button buttonRegisterB;
    private String userFirstName,userLastName,userdateofbirth,useremail,userpassword,userpasswordconfirm;
    private FirebaseAuth mAuth;
    private FirebaseDatabase database;
    private DatabaseReference databaseReference;
    private DatabaseReference databaseReferenceBakici;
//    String ad ;
//    String soyad ;
//    String dogumTarihi;
//    String eMail;
//    String sifre;
//    String sifretekrar;
//    ArrayList<BakiciModel> list;

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
        database = FirebaseDatabase.getInstance();
        databaseReference = FirebaseDatabase.getInstance().getReference("bakici");

        // register buton tiklaninca
        buttonRegisterB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                userFirstName = bakiciFirstName.getText().toString();
                userLastName = bakiciLastName.getText().toString();
                userdateofbirth = dateofBirth.getText().toString();
                useremail = email.getText().toString();
                userpassword = password.getText().toString();
                userpasswordconfirm = passwordconfirm.getText().toString();

                if(userFirstName.isEmpty() || userLastName.isEmpty() || userdateofbirth.isEmpty() || useremail.isEmpty() || userpassword.isEmpty() || userpasswordconfirm.isEmpty()){

                    Toast.makeText(getApplicationContext(),"Lütfen gerekli alanları doldurunuz!",Toast.LENGTH_SHORT).show();

                }else{
//                    registerFunction();

                    String mail = useremail;
                    String sifre = userpassword;
                    String ad = userFirstName;
                    String soyad = userLastName;
                    String dogumtarihi = userdateofbirth;
                    String sifretekrar = userpasswordconfirm;
                    Intent i = new Intent(getApplicationContext(), RegisterBakiciActivity2.class);
                    i.putExtra("email",mail);
                    i.putExtra("sifre",sifre);
                    i.putExtra("ad",ad);
                    i.putExtra("soyad",soyad);
                    i.putExtra("dogumtarihi",dogumtarihi);
                    i.putExtra("sifretekrar",sifretekrar);
                    startActivity(i);
                    finish();
                }

            }
        });
    }

    private void registerFunction() {

//         ad = bakiciFirstName.getText().toString();
//         soyad = bakiciLastName.getText().toString();
//         dogumTarihi = dateofBirth.getText().toString();
//         eMail = email.getText().toString();
//         sifre = password.getText().toString();
//        sifretekrar=passwordconfirm.getText().toString();

        FirebaseUser user = mAuth.getCurrentUser();
//        long msTime = System.currentTimeMillis();
//        Date birthdate = new Date(msTime);
//        SimpleDateFormat formatter = new SimpleDateFormat("dd'/'MM'/'y");
//        String dateTime = formatter.format(birthdate);

        //BakiciModel bakiciModel = new BakiciModel(ad,soyad,dogumTarihi,eMail,sifre,passwordconfirm.getText().toString());
        //databaseReference.push().setValue(bakiciModel);

        //databaseReference.setValue(bakiciModel);

//        if(TextUtils.isEmpty(email)){
//            Toast.makeText(getApplicationContext(),"Lütfen emailinizi giriniz",Toast.LENGTH_SHORT).show();
//            return;
//        }
//        if(TextUtils.isEmpty(parola)){
//            Toast.makeText(getApplicationContext(),"Lütfen parolanızı giriniz",Toast.LENGTH_SHORT).show();
//        }
//        if (parola.length()<6){
//            Toast.makeText(getApplicationContext(),"Parola en az 6 haneli olmalıdır", Toast.LENGTH_SHORT).show();
//        }

        mAuth.createUserWithEmailAndPassword(useremail,userpassword)
                .addOnCompleteListener(RegisterBakiciActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(Task<AuthResult> task) {

                        if (!task.isSuccessful()) {
                            Toast.makeText(RegisterBakiciActivity.this, "Yetkilendirme Hatası",
                                    Toast.LENGTH_SHORT).show();
                        }

                        else {
//                            Bundle bundlepro = new Bundle();
//                            bundlepro.putString("name", email.getText().toString());
//                            bundlepro.putString("password", password.getText().toString());
                            databaseReferenceBakici = FirebaseDatabase.getInstance().getReference("bakici/"+FirebaseAuth.getInstance().getCurrentUser().getUid());
                            BakiciModel bakiciModel = new BakiciModel(userFirstName,userLastName,userdateofbirth,"",useremail,userpassword,userpasswordconfirm,"","","","","","","","","");
                            databaseReferenceBakici.setValue(bakiciModel);
                            String mail = useremail;
                            String sifre = userpassword;
                            Intent i = new Intent(getApplicationContext(), RegisterBakiciActivity2.class);
                            i.putExtra("email",mail);
                            i.putExtra("sifre",sifre);
                            startActivity(i);
//                            startActivity(new Intent(RegisterBakiciActivity.this, RegisterBakiciActivity2.class));
                            finish();

                        }

                    }
                });



    }

}



