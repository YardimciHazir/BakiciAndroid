package com.merveyanar.ilkprojeyardimcim;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class BakiciAraAileFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    ArrayList<BakiciModel> bakiciList;
    ListView listView;

    private FirebaseAuth mAuth;
    private FirebaseDatabase database;
    private DatabaseReference databaseReference;
    private DatabaseReference databaseReferenceAile;

    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public BakiciAraAileFragment() {
    }
    public static BakiciAraAileFragment newInstance(String param1, String param2) {
        BakiciAraAileFragment fragment = new BakiciAraAileFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_kisisel_bilgi_aile, container, false);

        bakiciList=new ArrayList<BakiciModel>();
        listView= (ListView) view.findViewById(R.id.listView);
        database= FirebaseDatabase.getInstance();

        final DatabaseReference dbRef=database.getReference("bakici");

        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                for (DataSnapshot ds:dataSnapshot.getChildren()){
                    String bakiciAd = ds.child("ad").getValue().toString();
                    String bakiciSoyad = ds.child("soyad").getValue().toString();
                    String bakiciDogumTarihi=ds.child("dogumTarihi").getValue().toString();
                    String bakiciAdres = ds.child("adres").getValue().toString();
                    String bakiciEmail= ds.child("email").getValue().toString();
                    String bakiciMedeniDurumu=ds.child("medeniDurum").getValue().toString();
                    String bakiciEgitimDurumu=ds.child("egitimDurumu").getValue().toString();
                    String bakiciCinsiyet= ds.child("cinsiyet").getValue().toString();
                    String bakiciBakimTercihi=ds.child("bakimTercihi").getValue().toString();
                    String bakiciIlSecim=ds.child("ilSecim").getValue().toString();


                    bakiciList.add(new BakiciModel(bakiciAd,bakiciSoyad,bakiciDogumTarihi,bakiciAdres,
                            bakiciEmail,bakiciMedeniDurumu,bakiciEgitimDurumu
                    ,bakiciCinsiyet,bakiciBakimTercihi,bakiciIlSecim));
                }
                CustomAdapterBakiciAra adapter=new CustomAdapterBakiciAra(getActivity(),bakiciList);
                listView.setAdapter(adapter);
                dbRef.removeEventListener(this);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }
}
