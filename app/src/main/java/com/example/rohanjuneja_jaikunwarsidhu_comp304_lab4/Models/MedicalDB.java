package com.example.rohanjuneja_jaikunwarsidhu_comp304_lab4.Models;

//import android.arch.persistence.room.Database;
//import android.arch.persistence.room.RoomDatabase;
//import android.arch.persistence.room.TypeConversion;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;


@Database(entities = {Nurse.class,Patient.class,Test.class}, version=1, exportSchema = false)

public abstract class MedicalDB extends RoomDatabase {

    private static MedicalDB instance;
    private static final String DATABASE_NAME="NurseApp";

    //abstract methods
    public abstract NurseDao nurseDao();
    public abstract PatientDao patientDao();
    public abstract TestDao testDao();


    public static synchronized MedicalDB getInstance(Context context){
        if(instance==null){
            //create database object
            instance = Room.databaseBuilder(context,
                    MedicalDB.class, DATABASE_NAME).fallbackToDestructiveMigration().build();
        }
        return instance;
    }







}
