/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;


import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


/**
 *
 * @author admin
 */
public class VitalSigns {

    private int respiratoryRate;
    private int heartRate;
    private int bloodPressure;
    private int weightKg;
    private double weightLb;
    
    DecimalFormat dfc = new DecimalFormat("#.#");
    
    public VitalSigns(int respiratoryRate, int heartRate, int bloodPressure, int weight) {
        this.respiratoryRate = respiratoryRate;
        this.heartRate = heartRate;
        this.bloodPressure = bloodPressure;
        this.weightKg = weight;
        this.weightLb=weight*2.205;
        
    }

    public VitalSigns() {
       
    }
    
    public VitalSigns(VitalSigns vs){
     this.respiratoryRate = vs.respiratoryRate;
        this.heartRate = vs.heartRate;
        this.bloodPressure = vs.bloodPressure;
        this.weightKg = vs.weightKg;
        this.weightLb=vs.weightKg*2.205;
       
    }
     

    public double getWeightinPounds() {
        return weightLb;
    }

    public void setWeightinPounds(double weightLb) {
        this.weightLb = weightLb;
    }


    public int getRespiratoryRate() {
        return respiratoryRate;
    }

    public void setRespiratoryRate(int respiratoryRate) {
        this.respiratoryRate = respiratoryRate;
    }

    public int getHeartRate() {
        return heartRate;
    }

    public void setHeartRate(int heartRate) {
        this.heartRate = heartRate;
    }

    public int getSystolicBP() {
        return bloodPressure;
    }

    public void setSystolicBP(int bloodPressure) {
        this.bloodPressure = bloodPressure;
    }

    public int getWeightKg() {
        return weightKg; 
    }

    public void setWeightKg(int weightKg) {
        this.weightKg = weightKg;
    }

    @Override
    public String toString() {
        return "Respiratory Rate:" + respiratoryRate + ", Heart Rate:" + heartRate + ", Blood Pressure:" + bloodPressure + ", Weight(kg):" + weightKg+ ", Weight(pounds):" + dfc.format(weightLb);
    }    

}
