package com.merveyanar.ilkprojeyardimcim;

import android.content.Intent;
import android.support.annotation.NonNull;
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

public class RegisterBakiciActivity2 extends AppCompatActivity {

    private Spinner spinnergender, spinnermarital, spinnereducation, spinnerexperience, spinnercity, spinnercare;
    private Button buttonregister2;
    private FirebaseAuth mAuth;
    private FirebaseDatabase database;
    private DatabaseReference databaseReference;
    private DatabaseReference databaseReferenceBakici;
    private EditText address, nationality;
    private TextView usermail, sifre;
    private String useremail;
    private String gender,marital,education,experience,city,care,adres,nation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_bakici2);

        spinnergender = (Spinner) findViewById(R.id.spinnerGender);
        spinnermarital = (Spinner) findViewById(R.id.spinnerMarital);
        spinnereducation = (Spinner) findViewById(R.id.spinnerEducation);
        spinnerexperience = (Spinner) findViewById(R.id.spinnerExperience);
        spinnercity = (Spinner) findViewById(R.id.spinnerCity);
        spinnercare = (Spinner) findViewById(R.id.spinnerCare);
        address = (EditText) findViewById(R.id.address);
        nationality = (EditText) findViewById(R.id.nationality);
        buttonregister2 = (Button) findViewById(R.id.buttonRegister2);
        usermail = (TextView) findViewById(R.id.txtmail);
        sifre = (TextView) findViewById(R.id.txtsifre);

        mAuth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();
        databaseReference = FirebaseDatabase.getInstance().getReference("bakici");

        buttonregister2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                gender = spinnergender.getSelectedItem().toString();
                marital = spinnermarital.getSelectedItem().toString();
                education = spinnereducation.getSelectedItem().toString();
                experience = spinnerexperience.getSelectedItem().toString();
                city = spinnercity.getSelectedItem().toString();
                care = spinnercare.getSelectedItem().toString();
                adres = address.getText().toString();
                nation = nationality.getText().toString();

                if(gender.isEmpty() || marital.isEmpty() || education.isEmpty() || experience.isEmpty() || city.isEmpty() || care.isEmpty() || adres.isEmpty() || nation.isEmpty()){

                    Toast.makeText(getApplicationContext(),"Lütfen gerekli alanları doldurunuz!",Toast.LENGTH_SHORT).show();

                }else{
//                    Toast.makeText(RegisterBakiciActivity2.this,
//                            "OnClickListener : " +
//                                    "\nCinsiyet : "+ String.valueOf(spinnergender.getSelectedItem()) +
//                                    "\nMedeni Durum : "+ String.valueOf(spinnermarital.getSelectedItem())+
//                                    "\nEğitim Durumu : "+ String.valueOf(spinnereducation.getSelectedItem())+
//                                    "\nDeneyim : "+ String.valueOf(spinnerexperience.getSelectedItem())+
//                                    "\nİl Tercihi : "+ String.valueOf(spinnercity.getSelectedItem())+
//                                    "\nBakım Tercihi : "+ String.valueOf(spinnercare.getSelectedItem()),
//                            Toast.LENGTH_SHORT).show();

                    register2Function();
                }
            }
        });
    }

    private void register2Function() {

        FirebaseUser user = mAuth.getCurrentUser();

        Bundle extras = getIntent().getExtras();
        final String mail = extras.getString("email");
        final String sifre = extras.getString("sifre");
        final String ad = extras.getString("ad");
        final String soyad = extras.getString("soyad");
        final String sifretekrar = extras.getString("sifretekrar");
        final String dogumtarihi = extras.getString("dogumtarihi");

        mAuth.createUserWithEmailAndPassword(mail,sifre)
                .addOnCompleteListener(RegisterBakiciActivity2.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(Task<AuthResult> task) {
                if (!task.isSuccessful()) {
                    Toast.makeText(RegisterBakiciActivity2.this, "Yetkilendirme Hatası",
                            Toast.LENGTH_SHORT).show();
                }

                else {

                    databaseReferenceBakici = FirebaseDatabase.getInstance().getReference("bakici/"+FirebaseAuth.getInstance().getCurrentUser().getUid());
                    BakiciModel bakiciModel = new BakiciModel(ad,soyad,dogumtarihi,adres,mail,sifre,sifretekrar,nation,marital,education,"","",experience,gender,care,city);
                    databaseReferenceBakici.setValue(bakiciModel);
                    startActivity(new Intent(RegisterBakiciActivity2.this, ProfileBakiciActivity.class));
                    finish();
                }
            }
        });

    }

}




//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.main);
//
//        // Spinner element
//        Spinner spinner = (Spinner) findViewById(R.id.spinner);
//
//        // Spinner click listener
//        spinner.setOnItemSelectedListener(this);
//
//        // Spinner Drop down elements
//        List<String> categories = new ArrayList<String>();
//        categories.add("Automobile");
//        categories.add("Business Services");
//        categories.add("Computers");
//        categories.add("Education");
//        categories.add("Personal");
//        categories.add("Travel");
//
//        // Creating adapter for spinner
//        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);
//
//        // Drop down layout style - list view with radio button
//        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//
//        // attaching data adapter to spinner
//        spinner.setAdapter(dataAdapter);
//    }
//
//    @Override
//    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//        // On selecting a spinner item
//        String item = parent.getItemAtPosition(position).toString();
//
//        // Showing selected spinner item
//        Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();
//    }
//    public void onNothingSelected(AdapterView<?> arg0) {
//        // TODO Auto-generated method stub
//    }
