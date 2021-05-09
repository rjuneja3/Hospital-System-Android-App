package com.example.rohanjuneja_jaikunwarsidhu_comp304_lab4.Views;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.rohanjuneja_jaikunwarsidhu_comp304_lab4.Models.Patient;
import com.example.rohanjuneja_jaikunwarsidhu_comp304_lab4.R;
import com.example.rohanjuneja_jaikunwarsidhu_comp304_lab4.ViewModels.PatientViewModel;

public class PatientAddActivity extends AppCompatActivity {

    private EditText etPatientId, etfirstName, etlastName, etdepartment, etroom;
    private PatientViewModel patientViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Add New Patient");
        setContentView(R.layout.activity_patient_add);
        patientViewModel = new ViewModelProvider(this).get(PatientViewModel.class);
        etfirstName = findViewById(R.id.textPatientFirstName);
        etlastName = findViewById(R.id.editTextPatientLastName);
        etdepartment = findViewById(R.id.editTextPatientDepartment);
        etroom = findViewById(R.id.editTextPatientRoom);

    }

    public void addNewPatient(View view)
    {
        Patient patient = new Patient();
        patient.setFirstName(etfirstName.getText().toString());
        patient.setLastname(etlastName.getText().toString());
        patient.setDepartment(etdepartment.getText().toString());
        patient.setRoom(Integer.valueOf(etroom.getText().toString()));
        SharedPreferences sharedPreferences = getSharedPreferences("NurseID",MODE_PRIVATE);
        patient.setNurseId(Integer.valueOf(sharedPreferences.getString("NurseID", "")));
        patientViewModel.insert(patient);
        startActivity(new Intent(this, PatientActivity.class));
    }
}
