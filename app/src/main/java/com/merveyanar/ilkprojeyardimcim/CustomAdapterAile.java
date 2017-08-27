package com.merveyanar.ilkprojeyardimcim;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;

import java.util.ArrayList;

/**
 * Created by zeynepsahin on 27.8.2017.
 */

public class CustomAdapterAile extends BaseAdapter {

    LayoutInflater layoutInflater;

    ArrayList<AileModel> aileList;

    public CustomAdapterAile(Activity activity, ArrayList<AileModel> aileList){
        layoutInflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.aileList = aileList;}
    @Override
    public int getCount() {
        return aileList.size();
    }
    @Override
    public Object getItem(int position) {
        return aileList.get(position);
    }
    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        AileModel aile = aileList.get(position);

        View satir = layoutInflater.inflate(R.layout.custom_satir_aile,null);

        EditText aileAd= (EditText) satir.findViewById(R.id.aileFirstName);
        EditText aileSoyad= (EditText) satir.findViewById(R.id.aileLastName);
        EditText aileMail= (EditText) satir.findViewById(R.id.aileEmail);

        aileAd.setText(aile.getAileAd());
        aileSoyad.setText(aile.getAileSoyad());
        aileMail.setText(aile.getAileMail());


        return satir;
    }
}
