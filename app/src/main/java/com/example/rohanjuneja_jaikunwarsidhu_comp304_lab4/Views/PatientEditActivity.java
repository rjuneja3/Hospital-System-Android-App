package com.example.rohanjuneja_jaikunwarsidhu_comp304_lab4.Views;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import com.example.rohanjuneja_jaikunwarsidhu_comp304_lab4.Models.Patient;
import com.example.rohanjuneja_jaikunwarsidhu_comp304_lab4.R;
import com.example.rohanjuneja_jaikunwarsidhu_comp304_lab4.ViewModels.PatientViewModel;

public class PatientEditActivity extends AppCompatActivity {
    private EditText etPatientId, etfirstName, etlastName, etdepartment, etroom, etnurseId;
    private Patient patient;
    private PatientViewModel patientViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Edit Patient");
        setContentView(R.layout.activity_patient_edit);
        etlastName=findViewById(R.id.editTextPatientLastName);
        etfirstName=findViewById(R.id.textPatientFirstName);
        etdepartment=findViewById(R.id.editTextPatientDepartment);
        etroom=findViewById(R.id.editTextPatientRoom);

        int patientId = getIntent().getIntExtra("patientId", 0);
        Log.i("Patient", "Entered in PatientEditActivity class and patient is "+ String.valueOf(patientId));

        patientViewModel = ViewModelProviders.of(this).get(PatientViewModel.class);

        patient = patientViewModel.getPatientById(patientId);
        Log.i("Patient", "Entered in PatientEditActivity class and patientId is "+ patient.toString());

        etfirstName.setText(patient.getFirstName());
        etlastName.setText(patient.getLastname());
        etdepartment.setText(patient.getDepartment());
        etroom.setText(String.valueOf(patient.getRoom()));



    }

    public void savePatient(View view)
    {
        patient.setFirstName(etfirstName.getText().toString());
        patient.setLastname(etlastName.getText().toString());
        patient.setDepartment(etdepartment.getText().toString());
        patient.setRoom(Integer.valueOf(etroom.getText().toString()));
        patientViewModel.update(patient);
        Toast.makeText(this, "Patient Updated Successfully.", Toast.LENGTH_LONG).show();

        Intent intent = new Intent(this,PatientHistoryActivity.class);
        intent.putExtra("patientId", patient.getPatientId());
        startActivity(intent);
    }

}
