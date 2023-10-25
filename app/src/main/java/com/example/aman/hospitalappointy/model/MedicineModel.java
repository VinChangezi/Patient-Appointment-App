package com.example.aman.hospitalappointy.model;

public class MedicineModel {
    private String medicineName;
    private String medicalFormula;
    private String timeToTake;

    public MedicineModel(String medicineName, String medicalFormula, String timeToTake) {
        this.medicineName = medicineName;
        this.medicalFormula = medicalFormula;
        this.timeToTake = timeToTake;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public String getMedicalFormula() {
        return medicalFormula;
    }

    public void setMedicalFormula(String medicalFormula) {
        this.medicalFormula = medicalFormula;
    }

    public String getTimeToTake() {
        return timeToTake;
    }

    public void setTimeToTake(String timeToTake) {
        this.timeToTake = timeToTake;
    }
}
