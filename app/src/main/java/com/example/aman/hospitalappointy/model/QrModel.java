package com.example.aman.hospitalappointy.model;

import android.graphics.drawable.Drawable;
import android.widget.TextView;

public class QrModel {
    private Drawable doctorImage;
    private String doctorName;
    private String doctorSpeciality;
    private String appointmentTime;

    public Drawable getDoctorImage() {
        return doctorImage;
    }

    public void setDoctorImage(Drawable doctorImage) {
        this.doctorImage = doctorImage;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getDoctorSpeciality() {
        return doctorSpeciality;
    }

    public void setDoctorSpeciality(String doctorSpeciality) {
        this.doctorSpeciality = doctorSpeciality;
    }

    public String getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(String appointmentTime) {
        this.appointmentTime = appointmentTime;
    }
}
