package com.example.tehtava6;
import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Entit.class},version = 1)
public abstract class Databeissi extends RoomDatabase {
        public static final  String Name = "Name";
        public abstract MyTableDao tableDao();
}
