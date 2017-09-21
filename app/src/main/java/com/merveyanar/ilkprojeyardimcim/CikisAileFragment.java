package com.merveyanar.ilkprojeyardimcim;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class CikisAileFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private Button signOutBttn;
    private FirebaseAuth auth;
    private FirebaseUser firebaseUser;
    private FirebaseAuth.AuthStateListener authListener;
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public CikisAileFragment() {

    }


    public static CikisAileFragment newInstance(String param1, String param2) {
        CikisAileFragment fragment = new CikisAileFragment();
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
        View view = inflater.inflate(R.layout.fragment_cikis_aile, container, false);
        signOutBttn = (Button) view.findViewById(R.id.signOutBttn);
        signOutBttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signOutFunc(); // sign out
            }

            private void signOutFunc() {
                auth.signOut();
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
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
