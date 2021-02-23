/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author 12013
 */
public class Patient {
    
    private static String patientName;
    private static int patientAge;
    private static VitalSigns currVitalSign;
    private static ArrayList<VitalSigns> vitalSigns;
    
    
    
    public Patient(String patientName, int patientAge){
        this.patientName = patientName;
        this.patientAge = patientAge;
        this.vitalSigns = new ArrayList<VitalSigns>();
    }

    public static String getPatientName() {
        return patientName;
    }

    public static void setPatientName(String patientName) {
        Patient.patientName = patientName;
    }

    public static int getPatientAge() {
        return patientAge;
    }

    public static void setPatientAge(int patientAge) {
        Patient.patientAge = patientAge;
    }

    public static VitalSigns getCurrVitalSign() {
        return currVitalSign;
    }

    public static void setCurrVitalSign(VitalSigns currVitalSign) {
        Patient.currVitalSign = currVitalSign;
    }

    public static ArrayList<VitalSigns> getVitalSigns() {
        return vitalSigns;
    }

    public static void setVitalSigns(ArrayList<VitalSigns> vitalSigns) {
        Patient.vitalSigns = vitalSigns;
    }
    


   //Main Method
    public static void main (String args[]){
        
        System.out.println("Provide Patient and Vital Signs information below....");
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Patient's Name :");
        String patientName = scanner.nextLine();
        
        System.out.println("Enter Patient's Age in years (0 for Newborn) :");
        int patientAge = scanner.nextInt();
        
        Patient patient = new Patient(patientName, patientAge);
        
        System.out.println("Enter Patient's vital signs below......");
        newVitalSign();
        
        System.out.println(" \n");
        availOptions(patient);
                
    }
    
    
    public static boolean isPatientNormal(){
        
        int age = Patient.getPatientAge();
        int respRate = Patient.currVitalSign.getResporatoryRate();
        int hrtRate = Patient.currVitalSign.getHeartRate();
        double bloodPress = Patient.currVitalSign.getBloodPressure();
        double weightK = Patient.currVitalSign.getWeightKg();
//        double weightL = Patient.currVitalSign.getWeightLb();  
        
        
        if (age == 0 && respRate >= 30 &&
                respRate <= 50 && hrtRate >= 120 &&
                hrtRate <= 160 && bloodPress >= 50 &&
                bloodPress <= 70 && weightK >= 2 &&
                weightK <= 3){
            return true;
        } else if (age >0 && age <=1 && respRate >= 20 &&
                respRate <= 30 && hrtRate >= 80 &&
                hrtRate <= 140 && bloodPress >= 70 &&
                bloodPress <= 100 && weightK >= 4 &&
                weightK <= 10){
            return true;
        } else if (age >1 && age <=3 && respRate >= 20 &&
                respRate <= 30 && hrtRate >= 80 &&
                hrtRate <= 130 && bloodPress >= 80 &&
                bloodPress <= 110 && weightK >= 10 &&
                weightK <= 14){
            return true;
        } else if (age > 3 && age < 6 && respRate >= 20 &&
                respRate <= 30 && hrtRate >= 80 &&
                hrtRate <= 120 && bloodPress >= 80 &&
                bloodPress <= 110 && weightK >= 14 &&
                weightK <= 18){
            return true;
        } else if (age >= 6 && age < 13 && respRate >= 20 &&
                respRate <= 30 && hrtRate >= 70 &&
                hrtRate <= 110 && bloodPress >= 80 &&
                bloodPress <= 120 && weightK >= 20 &&
                weightK <= 42){
            return true;
        } else if (age >=13 && respRate >= 12 &&
                respRate <= 20 && hrtRate >= 55 &&
                hrtRate <= 105 && bloodPress >= 110 &&
                bloodPress <= 120 && weightK >= 50) {
            return true;
        }
        
        else return false;
        
        
        }
    
    
    public static void newVitalSign(){
        
        Scanner scanner = new Scanner(System.in);
        VitalSigns vs = new VitalSigns();
        System.out.println("Enter Respiratory Rate: ");
        vs.setResporatoryRate(scanner.nextInt());
        System.out.println("Enter Heart Rate: ");
        vs.setHeartRate(scanner.nextInt());
        System.out.println("Enter Blood Pressure: ");
        vs.setBloodPressure(scanner.nextDouble());
        System.out.println("Enter Weight in Kgs: ");
        vs.setWeightKg(scanner.nextDouble());  
        
        vs.setWeightLb(vs.getWeightKg()* 2.205);
        System.out.println("Weight in Lbs: " + vs.getWeightLb());
        
        vitalSigns.add(vs);
        currVitalSign = vs;
        
        System.out.println("Patient's Vital Signs are recorded successfully...");
    }
    
    public static void showPatientHistory(){
        
        int n = Patient.vitalSigns.size();
        System.out.println("********************************************************************************************************************************************\n" +
                           "PATIENT HISTORY DETAILS                                NAME :  " + Patient.patientName +"\n" +
                           "********************************************************************************************************************************************");
        
        for (int i=0; i < n-1; i++){
            
            System.out.println("Visit No. " + (i + 1) + ". " + Patient.vitalSigns.get(i).formatDateTime + " " + Patient.vitalSigns.get(i));
        }
        System.out.println("********************************************************************************************************************************************\n");
        
    }
    
    
    public boolean isThisVitalSignNormal(String vitalSign){
        
        int age = getPatientAge();
        int respRate = 0;
        int hrtRate = 0;
        double bloodPress = 0;
        double weightK = 0;
        double weightL = 0;
        
        switch (vitalSign) {
            case "respiratoryrate":
                respRate = currVitalSign.getResporatoryRate();
                break;
                
            case "heartrate":
                hrtRate = currVitalSign.getHeartRate();
                break;
                
            case "bloodpressure":
                bloodPress = currVitalSign.getBloodPressure();
                break;
                
            case "weightinkg":
                weightK = currVitalSign.getWeightKg();
                break;
                
            case "weightinlb":
                weightL = currVitalSign.getWeightLb();
                break;
                
            default:
                System.out.println("No Matching character found. Enter again.");
                break;
        }
        
        if (age == 0){
            return (respRate >= 30 ||
                respRate <= 50 || hrtRate >= 120 ||
                hrtRate <= 160 || bloodPress >= 50 ||
                bloodPress <= 70 || weightK >= 2 ||
                weightK <= 3);
        } else if (age <=1 && age > 0 ){
            return (respRate >= 20 &&
                respRate <= 30 && hrtRate >= 80 &&
                hrtRate <= 140 && bloodPress >= 70 &&
                bloodPress <= 100 && weightK >= 4 &&
                weightK <= 10);
        } else if (age > 1 && age <= 3){
            return (respRate >= 20 ||
                respRate <= 30 || hrtRate >= 80 ||
                hrtRate <= 130 || bloodPress >= 80 ||
                bloodPress <= 110 || weightK >= 10 ||
                weightK <= 14);
        } else if (age > 3 && age < 6){
            return (respRate >= 20 ||
                respRate <= 30 || hrtRate >= 80 ||
                hrtRate <= 120 || bloodPress >= 80 ||
                bloodPress <= 110 || weightK >= 14 ||
                weightK <= 18);
        } else if (age >=6 && age <= 13){
            return (respRate <= 30 || hrtRate >= 70 ||
                hrtRate <= 110 || bloodPress >= 80 ||
                bloodPress <= 120 || weightK >= 20 ||
                weightK <= 42);
        } else if (age > 13){
            return (respRate >= 12 ||
                respRate <= 20 || hrtRate >= 55 ||
                hrtRate <= 105 || bloodPress >= 110 ||
                bloodPress <= 120 || weightK >= 50);            
        } else{ return false;}
        
    }
    
    public static void showCurrentVitalSigns(){
        
        System.out.println("********************************************************************************************************************************************\n" +
                            "PATIENT CURRENT VITAL SIGNS                            NAME :  " + Patient.patientName +"\n" +
                            "***************************************************************************************************************");
        
        System.out.println("Visit " + (vitalSigns.size() + ". " + Patient.currVitalSign.formatDateTime + " " + Patient.currVitalSign ));
        
        System.out.println("********************************************************************************************************************************************\n");

        
    }
    
    public static void availOptions (Patient patient){
        
        Scanner scanner = new Scanner(System.in);
        boolean close = false;
        printMenu();
        while(!close){
            System.out.println("");
            System.out.println("Enter your choice. (Press 0 to see all the options)");
            int numInput= scanner.nextInt();
            
            switch (numInput) {
                case 1 : 
                    if (isPatientNormal()) {
                        System.out.println("Patient is normal");                    
                    } else {
                        System.out.println("Patient is not normal");
                    }
                    
                    break;
                
                case 2 :             
                    
                    newVitalSign();
                    break;
                    
                case 3 :
                    
                    showPatientHistory();
                    break;
                    
                case 4 :
                    
                    showCurrentVitalSigns();
                    break;
                    
                case 5 :
                    System.out.println("Enter the Vital Sign to check if the vital sign is normal \n Enter 'respiratoryrate' - Respiratory Rate, 'heartrate' - Heart Rate, 'bloodpressure' - Systolic Blood Pressure, 'weightinkg'- Weight in Kgs, 'weightinlb'- Weight in Lbs");
                    
                    if(patient.isThisVitalSignNormal(scan())== true) {
                            System.out.println("The enterted Vital Sign is Normal");
                    } else {
                        System.out.println("The enterted Vital Sign is not Normal");}
                    break;
                    
                case 6:
                    close = true;
                    break;
                    
                case 0:
                    printMenu();
                    break;
                    
                default:
                    break;
                    
            }
        }
    }
    
   public static String scan(){
       
       Scanner scanner = new Scanner(System.in);
       String str = scanner.nextLine();
       return str;
   }
   
   public static void printMenu(){
       
       System.out.println("Available Options to enter are : ");
       System.out.println("1 - to check if the patient is Normal? ");
       System.out.println("2 - to add new Vital Signs for patient");
       System.out.println("3 - to view the patient's history");
       System.out.println("4 - to check current vital signs of Patient");
       System.out.println("5 - to know if  particular vital sign is normal or not.");
       System.out.println("6 - Exit from the Menu ");
       System.out.println("0 - to view all options again/ Menu Display ");
       System.out.println("\n");
       

   }
}