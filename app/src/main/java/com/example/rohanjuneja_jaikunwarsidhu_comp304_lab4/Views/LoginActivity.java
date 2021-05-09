package com.example.rohanjuneja_jaikunwarsidhu_comp304_lab4.Views;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import com.example.rohanjuneja_jaikunwarsidhu_comp304_lab4.Models.Nurse;
import com.example.rohanjuneja_jaikunwarsidhu_comp304_lab4.R;
import com.example.rohanjuneja_jaikunwarsidhu_comp304_lab4.ViewModels.NurseViewModel;

import java.util.List;

public class LoginActivity extends AppCompatActivity {
    private EditText nurseId;
    private EditText nursePassword;
    private NurseViewModel nurseViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setTitle("Login Page");
        nurseId=findViewById(R.id.editTextNurseId);
        nursePassword=findViewById(R.id.editTextNursePassword);

        nurseViewModel= new ViewModelProvider(this).get(NurseViewModel.class);
        nurseViewModel.allNurses().observe(this, new Observer<List<Nurse>>() {
            @Override
            public void onChanged(List<Nurse> nurses) {
            }
        });
    }
    public void registerNurse(View view){
        Intent intent=new Intent(this,NurseRegistrationActivity.class);
        startActivity(intent);
    }

    public void signIn(View view){
        if(nurseViewModel.checkLogin(Integer.valueOf(nurseId.getText().toString()), nursePassword.getText().toString()))
        {
            SharedPreferences sharedPreferences= getSharedPreferences("NurseID",MODE_PRIVATE);
            SharedPreferences.Editor editor =sharedPreferences.edit();
            editor.putString("NurseID", nurseId.getText().toString());
            editor.commit();
            Intent intent=new Intent(this,PatientActivity.class);
            startActivity(intent);
        }
        else
        {
            Toast.makeText(this,"This record doesn't exist", Toast.LENGTH_LONG).show();
        }
    }

}
