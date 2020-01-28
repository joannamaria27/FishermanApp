package com.example.fishermanapp;


import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Fish.class}, version = 1, exportSchema = false)
public abstract class FishDatabase extends RoomDatabase {

    public abstract FishDao fishDao();

    private static volatile FishDatabase INSTANCE;
    public static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseWriteExecutor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    static FishDatabase getDatabase(final Context context)
    {

        if(INSTANCE == null)
        {
            synchronized (FishDatabase.class)
            {
                if(INSTANCE==null)
                {
                    //17
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),FishDatabase.class, "fish_db").addCallback(sRoomDatabaseCallback).build();
                }
            }
        }
        return INSTANCE;
    }
    private static RoomDatabase.Callback sRoomDatabaseCallback = new RoomDatabase.Callback()
    {
        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db)
        {
            super.onOpen(db);

            databaseWriteExecutor.execute(()->
            {
                FishDao dao = INSTANCE.fishDao();
                dao.deleteAll();

                Fish fish = new Fish ("Okoń", "20-20-2019", "20.3","0.5","Nidzkie");
                dao.insert(fish);
                Fish fish2 = new Fish ("Szczupak", "20-20-2019", "10","0.45","Nidzkie");
                dao.insert(fish2);
                Fish fish3 = new Fish ("Płoć", "20-20-2019", "15.8","1.5","Nidzkie");
                dao.insert(fish3);
                Fish fish4 = new Fish ("Okoń", "20-21-2019", "22","2.2","Nidzkie");
                dao.insert(fish4);
            });
        }
    };
}
