package com.example.fishermanapp;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName="fish")
public class Fish {


    @PrimaryKey(autoGenerate = true)
    private int id;
//    private String nazwa;
    private String waga;
//    private String data;
    private String wielkosc;
//    private String jezioro;

    public Fish(String nazwa, String data, String wielkosc, String waga, String jezioro) {
        this.nazwa = nazwa;
        this.data = data;
        this.wielkosc=wielkosc;
        this.waga=waga;
        this.jezioro=jezioro;
    }
    @ColumnInfo(name = "nazwa")
    private String nazwa;
    @ColumnInfo(name = "data")
    private String data;
    @ColumnInfo(name = "jezioro")
    private String jezioro;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getWaga() {
        return waga;
    }

    public void setWaga(String waga) {
        this.waga = waga;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getWielkosc() {
        return wielkosc;
    }

    public void setWielkosc(String wielkosc) {
        this.wielkosc = wielkosc;
    }

    public String getJezioro() {
        return jezioro;
    }

    public void setJezioro(String jezioro) {
        this.jezioro = jezioro;
    }
}
