package com.example.tehtava6;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.Room;

import java.util.ArrayList;
import java.util.List;

public class Adapteri extends ArrayAdapter<Entit> {

    private Context context;
    ArrayList<Entit> dataset;
    MyTableDao dao;

    public Adapteri(@NonNull Context context, int resource, @NonNull List objects) {
        super(context, resource, objects);
        this.context = context;
        this.dataset = (ArrayList<Entit>) objects;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.layoutti,parent,false);
        LinearLayout linearLayout = (LinearLayout) view;

        TextView textView1 = view.findViewById(R.id.teksti1);
        TextView textView2 = view.findViewById(R.id.teksti2);
        TextView textView3 = view.findViewById(R.id.teksti3);
        textView1.setText(String.valueOf(dataset.get(position).id));
        textView2.setText(dataset.get(position).tekst);
        textView3.setText(dataset.get(position).aika);
        return view;
    }
}
