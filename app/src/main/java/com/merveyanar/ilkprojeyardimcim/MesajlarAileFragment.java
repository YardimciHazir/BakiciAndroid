package com.merveyanar.ilkprojeyardimcim;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class MesajlarAileFragment extends Fragment {
    Button telefon,mesaj,email,websitesi;
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public MesajlarAileFragment() {

    }

    public static MesajlarAileFragment newInstance(String param1, String param2) {
        MesajlarAileFragment fragment = new MesajlarAileFragment();
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
       View view=inflater.inflate(R.layout.fragment_mesajlar_aile, container, false);
        telefon = (Button)view.findViewById(R.id.button1);//Butonları uygulamaya tanıtıyoruz
        mesaj = (Button)view.findViewById(R.id.button2);//Butonları uygulamaya tanıtıyoruz
        email = (Button)view.findViewById(R.id.button3);//Butonları uygulamaya tanıtıyoruz
        websitesi = (Button)view.findViewById(R.id.button4);//Butonları uygulamaya tanıtıyoruz
        telefon.setOnClickListener(new View.OnClickListener() {//Telefon aç butonu tıklanınca

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:1234567"));
                startActivity(intent);
            }
        });

        mesaj.setOnClickListener(new View.OnClickListener() {//mesaj at butonu tıklanınca

            @Override
            public void onClick(View v) {

                String telNo = "5321111111";//mesaj gönderilecek numara
                String mesaj = "Bu mesaj mobilhanem.com tarafından gönderilmiştir."; //mesaj

                //Bu kısım mesaj application açmak için.Yani sms uygulaması açılır. Numara kısmı ve mesaj kısmı otomatik doldurulur.

                Intent mesajGonder = new Intent(Intent.ACTION_VIEW);
                mesajGonder.setData(Uri.parse("sms:"+ telNo));
                mesajGonder.putExtra("sms_body", mesaj);
                startActivity(mesajGonder);


			/*		Bu kısım direk mesaj atmak için	.Herhangi bir uygulama açmaz direk mesaj atar.Bunun yerine üsteki daha sağlıklı
				SmsManager smsManager = SmsManager.getDefault();
				smsManager.sendTextMessage(telNo, null, mesaj, null, null);
			*/
            }
        });

        email.setOnClickListener(new View.OnClickListener() {//Email at butonu tıklanınca

            @Override
            public void onClick(View v) {

                Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);
                emailIntent.setType("plain/text");
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Konu");//Email konusu
                emailIntent.putExtra(Intent.EXTRA_TEXT, "Bu Mail mobilhanem.com tarafından gönderilmiştir.");//Email içeriği
                startActivity(Intent.createChooser(emailIntent, "E-mail Göndermek için Seçiniz:")); //birden fazla email uygulaması varsa seçmek için
                String aEmailList[] = { "bilgi@mobilhanem.com" };  //Mail gönderielecek kişi.Birden fazla ise virgülle ayırarak yazılır
                emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, aEmailList);
                startActivity(emailIntent);
            }
        });

        websitesi.setOnClickListener(new View.OnClickListener() { //Web Sitesi aç butonu

            @Override
            public void onClick(View v) {//Web sitesini tarayıcıda açar

                String url = "http://www.mobilhanem.com";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });
        return  view;
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
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
