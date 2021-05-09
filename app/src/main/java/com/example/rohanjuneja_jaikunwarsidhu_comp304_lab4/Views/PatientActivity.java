package com.example.rohanjuneja_jaikunwarsidhu_comp304_lab4.Views;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import com.example.rohanjuneja_jaikunwarsidhu_comp304_lab4.Models.Patient;
import com.example.rohanjuneja_jaikunwarsidhu_comp304_lab4.R;
import com.example.rohanjuneja_jaikunwarsidhu_comp304_lab4.ViewModels.PatientViewModel;

import java.util.ArrayList;
import java.util.List;

public class PatientActivity extends AppCompatActivity {

    private PatientViewModel patientViewModel;
    private List<Patient> patientList;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Patient Activity");
        setContentView(R.layout.activity_patient);
        patientList = new ArrayList<Patient>();
        patientViewModel = new ViewModelProvider(this).get(PatientViewModel.class);
        patientList = patientViewModel.allPatients();
        ArrayAdapter arrayAdapter=new ArrayAdapter(this,android.R.layout.simple_list_item_2, android.R.id.text1, patientList)
        {
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View view = super.getView(position, convertView, parent);
                TextView patientName = view.findViewById(android.R.id.text1);
                TextView patientInfo = view.findViewById(android.R.id.text2);
                patientName.setTextSize(16);
                patientName.setText(patientList.get(position).getPatientId()+" - "+patientList.get(position).getFirstName()+" "+patientList.get(position).getLastname());
                patientInfo.setText("Department: "+patientList.get(position).getDepartment()+" - Room: "+patientList.get(position).getRoom()+" - NurseId: "+patientList.get(position).getNurseId());
                return view;
            }
        };
        listView = findViewById(R.id.listViewPatient);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                TextView textView = view.findViewById(android.R.id.text1);
                String[] str = textView.getText().toString().split("-");
                int patientId = Integer.valueOf(str[0].trim());

                Intent intent = new Intent(getApplicationContext(),PatientHistoryActivity.class);
                intent.putExtra("patientId", patientId);
                startActivity(intent);
            }
        });
    }

    public void AddPatient(View view) {
        Intent intent = new Intent(this, PatientAddActivity.class);
        startActivity(intent);

    }

}
