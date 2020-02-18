package com.example.tehtava6;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface MyTableDao {
    @Query("SELECT * FROM Entit ORDER BY id DESC")
    List<Entit> DescendingOrder();
    @Insert
    void InsertEntity(Entit entit);
}