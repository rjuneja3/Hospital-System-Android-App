package com.example.rohanjuneja_jaikunwarsidhu_comp304_lab4.Models;

import android.content.Context;

import androidx.lifecycle.LiveData;

import java.util.List;

//we create this class to access the database using a separate thread
public class NurseRepository {

    private NurseDao nurseDao;
    //private LiveData<List<Nurse>> allNurses;
    private LiveData<List<Nurse>> allNurses;

    public LiveData<List<Nurse>> allNurses(){
        return allNurses;
    }

    //constructor
    public NurseRepository(Context context) {
        MedicalDB db = MedicalDB.getInstance(context);
        nurseDao = db.nurseDao();
        allNurses = nurseDao.getAllNurses();
    }


    public void delete(final Nurse nurse){
        new Thread(new Runnable() {
            @Override
            public void run() {
                nurseDao.delete(nurse);
            }
        }).start();
    }


    public void update(final Nurse nurse){
        new Thread(new Runnable() {
            @Override
            public void run() {
                nurseDao.update(nurse);
            }
        }).start();
    }


    public void insert(final Nurse nurse){
        new Thread(new Runnable() {
            @Override
            public void run() {
                nurseDao.insert(nurse);
            }
        }).start();
    }



}
