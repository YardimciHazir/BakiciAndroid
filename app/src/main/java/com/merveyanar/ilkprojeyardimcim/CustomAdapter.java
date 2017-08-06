package com.merveyanar.ilkprojeyardimcim;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by ASLI on 6.08.2017.
 */

public class CustomAdapter extends ArrayAdapter<BakiciModel> {

    public CustomAdapter(Context context, ArrayList<BakiciModel> chatlist) {
        super(context, 0, chatlist);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){//ilk oluşturulduğunda null oluyo row unu belirleyip onu al diyoruz
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.row_item, parent, false);
        }

        return convertView;
    }
}
