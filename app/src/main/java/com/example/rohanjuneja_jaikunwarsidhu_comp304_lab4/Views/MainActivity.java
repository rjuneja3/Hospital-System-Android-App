package com.example.rohanjuneja_jaikunwarsidhu_comp304_lab4.Views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.rohanjuneja_jaikunwarsidhu_comp304_lab4.R;

public class MainActivity extends AppCompatActivity {

    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnLogin=findViewById(R.id.loginBtn);
        setTitle("Hospital System");
    }
    public void sendToSecondScreen(View view){
        Intent intent=new Intent(this,LoginActivity.class);
        startActivity(intent);

    }
}