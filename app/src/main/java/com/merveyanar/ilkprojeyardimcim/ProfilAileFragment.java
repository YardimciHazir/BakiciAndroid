package com.merveyanar.ilkprojeyardimcim;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ProfilAileFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ProfilAileFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProfilAileFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private Button kisiselbilgi_btn;
    private Button iletisimbilgi_btn;
    private Button ihtiyacsahibibilgi_btn;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public ProfilAileFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ProfilAileFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ProfilAileFragment newInstance(String param1, String param2) {
        ProfilAileFragment fragment = new ProfilAileFragment();
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
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_profil_aile, container, false);

        View rootView = inflater.inflate(R.layout.fragment_profil_aile, container, false);


        kisiselbilgi_btn = (Button) rootView.findViewById(R.id.kisiselbilgi);
        iletisimbilgi_btn = (Button) rootView.findViewById(R.id.iletisimbilgi);
        ihtiyacsahibibilgi_btn = (Button) rootView.findViewById(R.id.ihtiyacsahibibilgi);


        kisiselbilgi_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //getFragmentManager().beginTransaction().add(R.id.container, new KisiselBilgiAileFragment(), "KisiselBilgiAileFragment").addToBackStack("KisiselBilgiAileFragment").commit();

                //getFragmentManager().beginTransaction().replace(R.id.container,new KisiselBilgiAileFragment()).commit();

                getFragmentManager().beginTransaction().add(R.id.container, new KisiselBilgiAileFragment(), "KisiselBilgiAileFragment")
                        .addToBackStack("KisiselBilgiAileFragment").commit();


            }
        });

        iletisimbilgi_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                getFragmentManager().beginTransaction().add(R.id.container, new IletisimBilgiAileFragment(), "IletisimBilgiAileFragment")
                        .addToBackStack("IletisimBilgiAileFragment").commit();

            }
        });

        ihtiyacsahibibilgi_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                getFragmentManager().beginTransaction().add(R.id.container, new IhtiyacSahibiBilgiAileFragment(), "IhtiyacSahibiBilgiAileFragment")
                        .addToBackStack("IhtiyacSahibiBilgiAileFragment").commit();

            }
        });

        return rootView;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

//    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//        if (context instanceof OnFragmentInteractionListener) {
//            mListener = (OnFragmentInteractionListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
//    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
