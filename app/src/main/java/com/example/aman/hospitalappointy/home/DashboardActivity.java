package com.example.aman.hospitalappointy.home;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.aman.hospitalappointy.R;
import com.example.aman.hospitalappointy.SplashActivity;

public class DashboardActivity extends AppCompatActivity {

    public static void launch(SplashActivity context) {
        Intent intent = new Intent(context, DashboardActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
    }
}