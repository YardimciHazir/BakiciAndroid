package com.merveyanar.ilkprojeyardimcim;

import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class SifreDegistirAileFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private Button changePasswordBttn;
    private String str;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private FirebaseAuth auth;
    private FirebaseUser firebaseUser;
    private FirebaseAuth.AuthStateListener authListener;

    private OnFragmentInteractionListener mListener;

    public SifreDegistirAileFragment() {

    }



    public static SifreDegistirAileFragment newInstance(String param1, String param2) {
        SifreDegistirAileFragment fragment = new SifreDegistirAileFragment();
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
        View view=inflater.inflate(R.layout.fragment_sifre_degistir_aile, container, false);
        changePasswordBttn = (Button)view.findViewById(R.id.changePasswordBttn);
        changePasswordBttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                str = "Lütfen yeni şifreyi giriniz.";
                changeEmailOrPasswordFunc(str,false);
            }

            private void changeEmailOrPasswordFunc(String title, final boolean option) {
                AlertDialog.Builder builder = new AlertDialog.Builder(
                        getContext());
                final EditText edit = new EditText(getContext());
                builder.setPositiveButton(getString(R.string.change_txt), null);
                builder.setNegativeButton(getString(R.string.close_txt), null);
                LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.MATCH_PARENT);
                edit.setLayoutParams(lp);
                if(!option){  // password type
                    edit.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                }
                builder.setTitle(title);
                builder.setView(edit);

                final AlertDialog mAlertDialog = builder.create();
                mAlertDialog.setOnShowListener(new DialogInterface.OnShowListener() {

                    @Override
                    public void onShow(DialogInterface dialog) {

                        Button b = mAlertDialog.getButton(AlertDialog.BUTTON_POSITIVE);
                        b.setOnClickListener(new View.OnClickListener() {

                            @Override
                            public void onClick(View view) {

                                if(edit.getText().toString().isEmpty()){

                                    edit.setError("Lütfen ilgili alanı doldurunuz!");

                                }else{

                                    if(option){ // email change

                                        changeEmail();

                                    }else{  // password change

                                        changePassword();

                                    }
                                }

                            }
                        });
                    }

                    private void changePassword() {

                        firebaseUser.updatePassword(edit.getText().toString())
                                .addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        if (task.isSuccessful()) {
                                            Toast.makeText(getContext(), "Şifre değiştirildi.", Toast.LENGTH_LONG).show();
                                            signOutFunc();
                                        } else {
                                            edit.setText("");
                                            Toast.makeText(getContext(), task.getException().getMessage(), Toast.LENGTH_LONG).show();
                                        }
                                    }

                                    private void signOutFunc() {
                                        auth.signOut();
                                    }
                                });
                    }

                    private void changeEmail() {

                        firebaseUser.updateEmail(edit.getText().toString().trim())
                                .addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(Task<Void> task) {
                                        if (task.isSuccessful()) {
                                            Toast.makeText(getContext(), "E-posta değiştirildi.", Toast.LENGTH_LONG).show();
                                            signOutFunc();

                                        } else {
                                            edit.setText("");
                                            Toast.makeText(getContext(), task.getException().getMessage(), Toast.LENGTH_LONG).show();
                                        }
                                    }

                                    private void signOutFunc() {
                                        auth.signOut();
                                    }
                                });
                    }
                });
                mAlertDialog.show();
            }
        });
        return view;
    }


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
