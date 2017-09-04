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
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link KisiselBilgiAileFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link KisiselBilgiAileFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class KisiselBilgiAileFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    //private EditText aileFirstName,aileLastName,aileAddress;

    ArrayList<AileModel> aileList;
    ListView listView;

    private FirebaseAuth mAuth;
    private FirebaseDatabase database;
    private DatabaseReference databaseReference;
    private DatabaseReference databaseReferenceAile;
    private FirebaseUser firebaseUser;

    //private DatabaseReference databaseReference;

    public KisiselBilgiAileFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment KisiselBilgiAileFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static KisiselBilgiAileFragment newInstance(String param1, String param2) {
        KisiselBilgiAileFragment fragment = new KisiselBilgiAileFragment();
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
        //return inflater.inflate(R.layout.fragment_kisisel_bilgi_aile, container, false);

        View view = inflater.inflate(R.layout.fragment_kisisel_bilgi_aile, container, false);

        aileList=new ArrayList<AileModel>();
        listView= (ListView) view.findViewById(R.id.listView);
        database= FirebaseDatabase.getInstance();
        final FirebaseAuth mAuth=FirebaseAuth.getInstance();
        firebaseUser = mAuth.getCurrentUser();
        //databaseReferenceAile = FirebaseDatabase.getInstance().getReference("aile");
//        final DatabaseReference dbRef=database.getReference("aile");

        final DatabaseReference dbRef = database.getReference("aile").child(
                firebaseUser.getUid());

        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                aileList.clear();
//                for (DataSnapshot ds:dataSnapshot.getChildren()){
                    AileModel aileModel = dataSnapshot.getValue(AileModel.class);
//                    String aileAd = ds.child("aileAd").getValue().toString();
//                    String aileSoyad = ds.child("aileSoyad").getValue().toString();
//                    String aileMail = ds.child("aileMail").getValue().toString();
                    aileList.add(new AileModel(aileModel.getAileAd(),aileModel.getAileSoyad(),aileModel.getAileMail()));
//                }
                CustomAdapterAile adapter=new CustomAdapterAile(getActivity(),aileList);
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
