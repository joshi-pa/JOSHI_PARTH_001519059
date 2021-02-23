/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author 12013
 */
public class VitalSigns {
    
    private int resporatoryRate;
    private int heartRate;
    private double bloodPressure;
    private double weightKg;
    private double weightLb;
    private final LocalDateTime checkUpDate = LocalDateTime.now();
    DateTimeFormatter date = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
    String formatDateTime = checkUpDate.format(date);
    
    public VitalSigns(){
    }

    public VitalSigns(int resporatoryRate, int heartRate, double bloodPressure, double weightKg, double weightLb) {
        this.resporatoryRate = resporatoryRate;
        this.heartRate = heartRate;
        this.bloodPressure = bloodPressure;
        this.weightKg = weightKg;
        this.weightLb = weightLb;

    }
    
    

    public int getResporatoryRate() {
        return resporatoryRate;
    }

    public void setResporatoryRate(int resporatoryRate) {
        this.resporatoryRate = resporatoryRate;
    }

    public int getHeartRate() {
        return heartRate;
    }

    public void setHeartRate(int heartRate) {
        this.heartRate = heartRate;
    }

    public double getBloodPressure() {
        return bloodPressure;
    }

    public void setBloodPressure(double bloodPressure) {
        this.bloodPressure = bloodPressure;
    }

    public double getWeightKg() {
        return weightKg;
    }

    public void setWeightKg(double weightKg) {
        this.weightKg = weightKg;
    }

    public double getWeightLb() {
        return weightLb;
    }

    public void setWeightLb(double weightLb) {
        this.weightLb = weightLb;
    }

    @Override
    public String toString() {
        return "Vital Signs are {" + "Resporatory Rate = " + resporatoryRate + ", Heart Rate = " + heartRate + ", Blood Pressure = " + bloodPressure + ", Weight in Kgs = " + weightKg + ", Weight in Lbs = " + weightLb + "}";
    }
   
    
    
}
    
    

