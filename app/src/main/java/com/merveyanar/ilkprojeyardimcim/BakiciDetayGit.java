package com.merveyanar.ilkprojeyardimcim;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class BakiciDetayGit extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bakici_detay_git);

        TextView txt = (TextView)findViewById(R.id.name);

        BakiciModel bakiciModel = (BakiciModel)getIntent().getSerializableExtra("bakici");
        txt.setText(bakiciModel.getAd());

    }
}
