package com.example.fishermanapp;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class FishViewModel extends AndroidViewModel {

    private FishRepository fishRepository;
    private LiveData<List<Fish>> fishes;

    public FishViewModel(@NonNull Application application) {
        super(application);
        fishRepository=new FishRepository(application);
        fishes=fishRepository.findAllFishes();
    }

    public LiveData<List<Fish>> findAll()
    {
        return fishes;
    }

    public void insert(Fish fish)
    {
        fishRepository.insert(fish);
    }
    public void update(Fish fish)
    {
        fishRepository.update(fish);
    }
    public void delete(Fish fish)
    {
        fishRepository.delete(fish);
    }
    public void findByName(String title) {
        fishRepository.findFishWithNazwa(title);
    }

    public List<Fish> findFishes(String s){
        return fishRepository.findFish(s);
    }


}
