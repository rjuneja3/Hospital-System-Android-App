package com.example.rohanjuneja_jaikunwarsidhu_comp304_lab4.Views;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import com.example.rohanjuneja_jaikunwarsidhu_comp304_lab4.Models.Nurse;
import com.example.rohanjuneja_jaikunwarsidhu_comp304_lab4.R;
import com.example.rohanjuneja_jaikunwarsidhu_comp304_lab4.ViewModels.NurseViewModel;

public class NurseRegistrationActivity extends AppCompatActivity {
    private EditText nurseIdEt,firstNameEt,lastNameEt,departmentNameEt,passwordEt;
    private NurseViewModel nurseViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Nurse registration");
        setContentView(R.layout.activity_nurse_registration);
        nurseIdEt=findViewById(R.id.nurseIDEt);
        firstNameEt=findViewById(R.id.firstNameEt);
        lastNameEt=findViewById(R.id.lastNameEt);
        departmentNameEt=findViewById(R.id.departmentEt);
        passwordEt=findViewById(R.id.passwordEt);
        nurseViewModel= ViewModelProviders.of(this).get(NurseViewModel.class);
    }


    public void registerNurse(View view){
        try {
            Nurse nurse = new Nurse();

            nurse.setNurseId(Integer.valueOf(nurseIdEt.getText().toString()));
            nurse.setFirstName(firstNameEt.getText().toString());
            nurse.setLastname(lastNameEt.getText().toString());
            nurse.setDepartment(departmentNameEt.getText().toString());
            nurse.setPassword(passwordEt.getText().toString());
            nurseViewModel.insert(nurse);
            Toast.makeText(this,"Nurse account created!", Toast.LENGTH_LONG).show();
            Intent intent=new Intent(this, LoginActivity.class);
            startActivity(intent);
        }
        catch(Exception ex){
            Toast.makeText(this,ex.getMessage().toString(), Toast.LENGTH_LONG).show();
        }
    }
}
