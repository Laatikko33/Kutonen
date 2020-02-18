package com.example.tehtava6;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Entit {
    @PrimaryKey(autoGenerate = true)
    public int id;
    public String tekst;
    public String aika;
}
