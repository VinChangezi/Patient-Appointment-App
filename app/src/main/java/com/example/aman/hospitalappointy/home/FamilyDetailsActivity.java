package com.example.aman.hospitalappointy.home;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.aman.hospitalappointy.R;
import com.example.aman.hospitalappointy.patient.BookAppointmentActivity;
import com.example.aman.hospitalappointy.patient.PatientViewBookedAppointmentActivity;

import java.util.HashMap;

public class FamilyDetailsActivity extends AppCompatActivity {

    private EditText name, fatherName, relation, contactInfo, symptom, pastHistory;
    private String date, time = "", shift;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_family_details);

        name = findViewById(R.id.name);
        fatherName = findViewById(R.id.father_name);
        relation = findViewById(R.id.relation);
        contactInfo = findViewById(R.id.contact_info);
        symptom = findViewById(R.id.symptom);
        pastHistory = findViewById(R.id.past_history);

        Button mAddMemberBtn = (Button) findViewById(R.id.book_appointment_button);

        mAddMemberBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HashMap<String,String> details = new HashMap<>();
                details.put("Doctor_ID",getIntent().getStringExtra("DoctorUserId"));
                details.put("Date",date);
                details.put("Time",time);

                startActivity(new Intent(FamilyDetailsActivity.this, PatientViewBookedAppointmentActivity.class));

            }
        });

        // Set hardcoded values
        name.setText("Shamis Asghar");
        fatherName.setText("Shamis Asghar");
        relation.setText("Son");
        contactInfo.setText("1234567890");
        symptom.setText("Fever");
        pastHistory.setText("No past history of any particular disease");

    }
}