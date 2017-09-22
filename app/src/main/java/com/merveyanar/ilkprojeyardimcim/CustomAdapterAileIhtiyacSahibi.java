package com.merveyanar.ilkprojeyardimcim;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zeynepsahin on 27.8.2017.
 */

public class CustomAdapterAileIhtiyacSahibi extends BaseAdapter {

    LayoutInflater layoutInflater;

    ArrayList<AileModel> aileList;

    private Context mContext;
    private List<AileModel> mAileList;

    public CustomAdapterAileIhtiyacSahibi(Context mContext, List<AileModel> mAileList){
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

       View satir = View.inflate(mContext,R.layout.custom_satir_aile_ihtiyac_sahibi,null);

        TextView ihtiyacAdi= (TextView) satir.findViewById(R.id.ihtiyacAdi);
        TextView ihtiyacSoyadi= (TextView) satir.findViewById(R.id.ihtiyacSoyadi);
        TextView ihtiyacDogumTarihi= (TextView) satir.findViewById(R.id.ihtiyacDogumTarihi);
        TextView ihtiyacCinsiyet= (TextView) satir.findViewById(R.id.ihtiyacCinsiyet);
        TextView ihtiyacDurumu= (TextView) satir.findViewById(R.id.ihtiyacDurumu);



        ihtiyacAdi.setText(mAileList.get(position).getHastaAd());
        ihtiyacSoyadi.setText(mAileList.get(position).getHastaSoyad());
        ihtiyacDogumTarihi.setText(mAileList.get(position).getHastaDogumTarihi());
        ihtiyacCinsiyet.setText(mAileList.get(position).getHastaCinsiyet());
        ihtiyacDurumu.setText(mAileList.get(position).getHastaEngel());



        return satir;
    }
}
