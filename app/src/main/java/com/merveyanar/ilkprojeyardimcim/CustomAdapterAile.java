package com.merveyanar.ilkprojeyardimcim;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zeynepsahin on 27.8.2017.
 */

public class CustomAdapterAile extends BaseAdapter {

    LayoutInflater layoutInflater;

    ArrayList<AileModel> aileList;

    private Context mContext;
    private List<AileModel> mAileList;

    public CustomAdapterAile(Context mContext, List<AileModel> mAileList){
        this.mContext=mContext;
        this.mAileList=mAileList;
    }
    @Override
    public int getCount() {
        return mAileList.size();
    }
    @Override
    public Object getItem(int position) {
        return mAileList.get(position);
    }
    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

       View satir = View.inflate(mContext,R.layout.custom_satir_aile,null);

        TextView aileAd= (TextView) satir.findViewById(R.id.aileAd);
        TextView aileSoyad= (TextView) satir.findViewById(R.id.aileSoyad);
        TextView aileCinsiyet= (TextView) satir.findViewById(R.id.aileCinsiyet);
        TextView aileEgitimDurumu= (TextView) satir.findViewById(R.id.aileEgitimDurumu);
        TextView aileMedeniDurum= (TextView) satir.findViewById(R.id.aileMedeniDurum);



        aileAd.setText(mAileList.get(position).getAileAd());
        aileSoyad.setText(mAileList.get(position).getAileSoyad());
        aileCinsiyet.setText(mAileList.get(position).getAileCinsiyet());
        aileEgitimDurumu.setText(mAileList.get(position).getAileEgitimDurumu());
        aileMedeniDurum.setText(mAileList.get(position).getAileMedeniDurum());



        return satir;
    }
}
