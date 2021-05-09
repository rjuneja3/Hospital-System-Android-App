package com.example.rohanjuneja_jaikunwarsidhu_comp304_lab4.ViewModels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.example.rohanjuneja_jaikunwarsidhu_comp304_lab4.Models.Patient;
import com.example.rohanjuneja_jaikunwarsidhu_comp304_lab4.Models.PatientRepository;

import java.util.List;

public class PatientViewModel extends AndroidViewModel {
    private PatientRepository patientRepository;
    public PatientViewModel(@NonNull Application application) {
        super(application);
        this.patientRepository = new PatientRepository(application);
    }

    public void insert(Patient patient){
        patientRepository.insert(patient);
    }
    public void update(Patient patient){
        patientRepository.update(patient);
    }
    public void delete(Patient patient){
        patientRepository.delete(patient);
    }
    public List<Patient> allPatients(){
        return patientRepository.AllPatients();
    }
    public Patient getPatientById(int patientId) { return patientRepository.getPatientById(patientId); }
}
