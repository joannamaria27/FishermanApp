package com.example.fishermanapp;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class FishRepository {

    private FishDao fishDao;
    private LiveData<List<Fish>> fishes;


    FishRepository(Application application)
    {
        FishDatabase database = FishDatabase.getDatabase(application);
        fishDao=database.fishDao();
        fishes=fishDao.findAll();
    }

    LiveData<List<Fish>> findAllFishes()
    {
        return fishes;
    }

    void insert (Fish fish)
    {
        FishDatabase.databaseWriteExecutor.execute(()->
        {
            fishDao.insert(fish);
        });
    }
    void update (Fish fish)
    {
        FishDatabase.databaseWriteExecutor.execute(()->
        {
            fishDao.update(fish);
        });
    }
    void delete (Fish fish)
    {
        FishDatabase.databaseWriteExecutor.execute(()->
        {
            fishDao.delete(fish);
        });
    }

    List<Fish> findFish(String s){
        return fishDao.findFish(s);
    }

    List<Fish> findFishWithNazwa(String nazwa)
    {
        return fishDao.findFishWithNazwa(nazwa);
    }

}
