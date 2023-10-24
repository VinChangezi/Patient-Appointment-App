package com.example.aman.hospitalappointy.qrcode;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.aman.hospitalappointy.R;

public class ScannerActivity extends AppCompatActivity {

    private TextView mName, mEmail;
    private EditText mFeedbackText;
    private Button mSubmitFeedback;

    private String currnetUID;

//    private FirebaseAuth mAuth = FirebaseAuth.getInstance();
//    private DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scanner);
    }

}
