package com.example.aman.hospitalappointy.patient;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.aman.hospitalappointy.R;
import com.example.aman.hospitalappointy.home.FamilyDetailsActivity;

import java.util.Calendar;

public class PatientViewDoctorProfileActivity extends AppCompatActivity {

    private TextView mName, mEducation, mSpecialization, mExperience, mContactNo, mShift;
    private String shift;

    private Calendar calendar;
    private DatePickerDialog datePickerDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_view_doctor_profile);

        //Toolbar
        Toolbar mToolbar = (Toolbar) findViewById(R.id.patient_doctorProfile_toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle("Doctor Profile");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mName = (TextView) findViewById(R.id.patient_doctorProfile_name);
        mSpecialization = (TextView) findViewById(R.id.patient_doctorProfile_specialization);
        mEducation = (TextView) findViewById(R.id.patient_doctorProfile_education);
        mExperience = (TextView) findViewById(R.id.patient_doctorProfile_experiance);
        mContactNo = (TextView) findViewById(R.id.patient_doctorProfile_contact);
        mShift = (TextView) findViewById(R.id.patient_doctorProfile_shift);

        Button mBookAppointmentBtn = (Button) findViewById(R.id.book_appointment_button);
        mBookAppointmentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                calendar = Calendar.getInstance();
                int day = calendar.get(Calendar.DAY_OF_MONTH);
                int month = calendar.get(Calendar.MONTH);
                int year = calendar.get(Calendar.YEAR);

                datePickerDialog = new DatePickerDialog(PatientViewDoctorProfileActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                        String userId = getIntent().getStringExtra("UserId");
                        String date = dayOfMonth + "-" + (month + 1) + "-" + year;

                        showPatientSelectorDialog(userId, date);
                        /*Intent intent = new Intent(PatientViewDoctorProfileActivity.this, BookAppointmentActivity.class);
                        intent.putExtra("Date", date);
                        intent.putExtra("DoctorUserId", userId);
                        intent.putExtra("Shift", shift);
                        startActivity(intent);*/
                    }
                }, day, month, year);
                datePickerDialog.updateDate(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
                datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis() + (3 * 60 * 60 * 1000));
                datePickerDialog.getDatePicker().setMaxDate(System.currentTimeMillis() + (15 * 24 * 60 * 60 * 1000));
                datePickerDialog.show();
            }
        });
    }

    private void showPatientSelectorDialog(String userId, String date) {
        final CharSequence[] items = {"MySelf", "Add Family Person"};

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Choose an option");

        final int[] selectedItem = new int[1];
        builder.setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int item) {
                // user checked an item
                selectedItem[0] = item;
            }
        });
        builder.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // user clicked confirm
//                Intent intent = new Intent(MainActivity.this, NewActivity.class);
//                startActivity(intent);
                switch (selectedItem[0]) {
                    case 0:
                        //if Myself selected
                        Intent intent = new Intent(PatientViewDoctorProfileActivity.this, BookAppointmentActivity.class);
                        intent.putExtra("Date", date);
                        intent.putExtra("DoctorUserId", userId);
                        intent.putExtra("Shift", shift);
                        startActivity(intent);
                        break;
                    case 1:
                        Intent intent2 = new Intent(PatientViewDoctorProfileActivity.this, FamilyDetailsActivity.class);
                        intent2.putExtra("Date", date);
                        intent2.putExtra("DoctorUserId", userId);
                        intent2.putExtra("Shift", shift);
                        startActivity(intent2);
                        break;
                }

            }
        });
        builder.setNegativeButton("Cancel", null);

        AlertDialog alert = builder.create();
        alert.show();
    }

    @Override
    protected void onStart() {
        super.onStart();

        String name = getIntent().getStringExtra("Name");
        String education = getIntent().getStringExtra("Education");
        String specialization = getIntent().getStringExtra("Specialization");
        String experience = getIntent().getStringExtra("Experiance");
        String contact = getIntent().getStringExtra("Contact");
        shift = getIntent().getStringExtra("Shift");

        mName.setText(name);
        mEducation.setText(education);
        mSpecialization.setText(specialization);
        mExperience.setText(experience);
        mContactNo.setText(contact);
        mShift.setText(shift);
    }
}
