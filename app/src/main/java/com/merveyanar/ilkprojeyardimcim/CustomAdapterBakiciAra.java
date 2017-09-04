package com.merveyanar.ilkprojeyardimcim;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapterBakiciAra  extends BaseAdapter {
    LayoutInflater layoutInflater;

    ArrayList<BakiciModel> bakiciList;

    private Context mContext;
    private List<BakiciModel> mBakiciList;

    public CustomAdapterBakiciAra(Context mContext, List<BakiciModel> mBakiciList){
        this.mContext=mContext;
        this.mBakiciList=mBakiciList;
    }
    @Override
    public int getCount() {
        return mBakiciList.size();
    }
    @Override
    public Object getItem(int position) {
        return mBakiciList.get(position);
    }
    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View satir = View.inflate(mContext,R.layout.fragment_bakici_row,null);

        TextView bakiciAd= (TextView) satir.findViewById(R.id.bakiciAd);
        TextView bakiciSoyad= (TextView) satir.findViewById(R.id.bakiciSoyad);
        TextView bakiciDogumTarihi= (TextView) satir.findViewById(R.id.bakiciDogumTarihi);
        TextView bakiciAdres= (TextView) satir.findViewById(R.id.bakiciAdres);
        TextView bakiciEmail= (TextView) satir.findViewById(R.id.bakiciEmail);
        TextView bakiciMedeniDurumu= (TextView) satir.findViewById(R.id.bakiciMedeniDurumu);
        TextView bakiciEgitimDurumu= (TextView) satir.findViewById(R.id.bakiciEgitimDurumu);
        TextView bakiciCinsiyet= (TextView) satir.findViewById(R.id.bakiciCinsiyet);
        TextView bakiciBakimTercihi= (TextView) satir.findViewById(R.id.bakiciBakimTercihi);
        TextView bakiciIlSecim= (TextView) satir.findViewById(R.id.bakiciIlSecim);

        bakiciAd.setText(mBakiciList.get(position).getAd());
        bakiciSoyad.setText(mBakiciList.get(position).getSoyad());
        bakiciDogumTarihi.setText(mBakiciList.get(position).getDogumTarihi());
        bakiciAdres.setText(mBakiciList.get(position).getAdres());
        bakiciEmail.setText(mBakiciList.get(position).getEmail());
        bakiciMedeniDurumu.setText(mBakiciList.get(position).getMedeniDurum());
        bakiciEgitimDurumu.setText(mBakiciList.get(position).getEgitimDurumu());
        bakiciCinsiyet.setText(mBakiciList.get(position).getCinsiyet());
        bakiciBakimTercihi.setText(mBakiciList.get(position).getBakimTercihi());
        bakiciIlSecim.setText(mBakiciList.get(position).getIlSecim());

        return satir;
    }
}
