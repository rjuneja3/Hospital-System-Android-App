package com.example.rohanjuneja_jaikunwarsidhu_comp304_lab4.Views;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.rohanjuneja_jaikunwarsidhu_comp304_lab4.Models.Test;
import com.example.rohanjuneja_jaikunwarsidhu_comp304_lab4.R;
import com.example.rohanjuneja_jaikunwarsidhu_comp304_lab4.ViewModels.TestViewModel;

public class ViewTestInfoActivity extends AppCompatActivity {
    private TestViewModel testViewModel;
    private EditText et_BPL, et_BML, et_Temperature, et_BAuscultation,et_BInspection;
    private int nurseId, patientId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Test info activity");
        SharedPreferences sharedPreferences= getSharedPreferences("NurseID",MODE_PRIVATE);
        setContentView(R.layout.activity_view_test_info);
        et_BPL=findViewById(R.id.et_BPL);
        et_BML= findViewById(R.id.et_BPM);
        nurseId = Integer.valueOf(sharedPreferences.getString("NurseID", ""));
        patientId = getIntent().getIntExtra("patientId", 0);
        et_Temperature = findViewById(R.id.et_Temperature);
        et_BAuscultation = findViewById(R.id.et_Auscultation);
        et_BInspection= findViewById(R.id.et_BInspection);
        testViewModel= new ViewModelProvider(this).get(TestViewModel.class);

    }
    public void addNewTest (View view){

        Test test= new Test();
        test.setBPL(Integer.valueOf(et_BPL.getText().toString()));
        test.setBPM(Integer.valueOf(et_BML.getText().toString()));
        test.setTemperature(Integer.valueOf(et_Temperature.getText().toString()));
        test.setAuscultation(et_BAuscultation.getText().toString());
        test.setBodyInspection(et_BInspection.getText().toString());
        test.setPatientId(patientId);
        test.setNurseId(nurseId);

        try {
            testViewModel.insert(test);
            Intent intent = new Intent(this,PatientHistoryActivity.class);
            intent.putExtra("patientId", patientId);
            startActivity(intent);
            //Toast.makeText(this, "Ok", Toast.LENGTH_LONG).show();
        }
        catch(Exception ex)
        {
            Toast.makeText(this, "Error: "+ ex.getMessage(), Toast.LENGTH_LONG).show();
        }

    }

}
