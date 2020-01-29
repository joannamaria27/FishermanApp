package com.example.fishermanapp;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface FishDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Fish fish);

    @Update
    public void update(Fish fish);

    @Delete
    public void delete(Fish fish);

    @Query("DELETE FROM fish")
    public void deleteAll();

    @Query("SELECT * FROM fish ORDER BY nazwa")
    public LiveData<List<Fish>> findAll();

    @Query("SELECT * FROM fish WHERE nazwa LIKE :nazwa")
    public List<Fish> findFishWithNazwa(String nazwa);

    @Query("SELECT * FROM fish WHERE data LIKE :s OR nazwa LIKE :s OR jezioro LIKE :s")
    List<Fish>  findFishes(String s);
    @Query("SELECT * FROM fish")
    List<Fish> findFishesAny();

}
