package com.example.tehtava6;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    MyTableDao dao;
    TextView textView;
    ListView listView;
    Button Button;
    Entit entit;
    ArrayAdapter<Entit> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.teksti);
        Button = findViewById(R.id.Button);
        listView = findViewById(R.id.lista);
        Entit entit = new Entit();
        ArrayList list = new ArrayList();
        adapter = new Adapteri(this,R.id.lista,list);
        listView.setAdapter(adapter);

        final Databeissi databeissi = Room.databaseBuilder(getApplicationContext(), Databeissi.class, "Name").allowMainThreadQueries()
                .fallbackToDestructiveMigration().build();
        this.dao = databeissi.tableDao();
        adapter.addAll(dao.DescendingOrder());

        Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Entit entit = new Entit();
                String aika = Calendar.getInstance().getTime().toString();
                entit.aika = aika;
                entit.tekst = textView.getText().toString();
                dao.InsertEntity(entit);
                adapter.clear();
                adapter.addAll(dao.DescendingOrder());

            }
        });
    }
}
