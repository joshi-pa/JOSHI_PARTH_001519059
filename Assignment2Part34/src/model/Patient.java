/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author 12013
 */
public class Patient extends Person{
    
    private VitalSigns currentVitalSigns;
    private ArrayList<EncounterHistory> encounterHistory;

    public Patient(String patientName, int patientAge,String mobileNum,House house) {
        super(patientName,patientAge,mobileNum,house);
        
        encounterHistory= new ArrayList<EncounterHistory>();
       

    }
    
    public void addPersonToHouse(){
    
    }
    
    public void addEncounter(VitalSigns vs){
        VitalSigns vs1=new VitalSigns(vs);
        EncounterHistory encounter =new EncounterHistory(vs1);
        encounterHistory.add(encounter);
        currentVitalSigns = vs1;
        System.out.println("vital signs "+vs.toString()+" added to -> "+super.getPersonName()+" at "+encounter.formattedDateTime);
    }

    public void newEncounter() {
        Scanner scanner = new Scanner(System.in);
        VitalSigns vs = new VitalSigns();
        
        System.out.println("Respiratory Rate:");
        vs.setRespiratoryRate(scanner.nextInt());

        
        System.out.println("Heart Rate:");
        vs.setHeartRate(scanner.nextInt());

        System.out.println("SystolicBP:");
        vs.setbloodPressure(scanner.nextInt());

        
        System.out.println("Weight(kg):");
        int weightInKg = scanner.nextInt();
        vs.setWeightKg(weightInKg);

        System.out.println("Confirm Weight in (pounds):");
        double weightInPounds = weightInKg * 2.2;
        vs.setweightLb(weightInPounds);
             
        DecimalFormat dfc = new DecimalFormat("#.#");
        System.out.println(dfc.format(weightInPounds));
       
        EncounterHistory encounter =new EncounterHistory(vs);
        encounterHistory.add(encounter);

        currentVitalSigns = vs;
        System.out.println("");
        System.out.println("patients record added sucessfully...");
        System.out.println("");
        // System.out.println(encounterHistory.get(0).getHeartRate());
        //   return currentVitalSigns;       

    }

    public void viewPatientEncounterHistory() {

        int n = encounterHistory.size();
        System.out.println("----------------------------------------------------------------------------------------------------------------\n"
                + "PATIENT'S ENCOUNTER HISTORY                                                            NAME: " + super.getPersonName() +"("+super.getPersonAge()+"Y)\n"
                + "----------------------------------------------------------------------------------------------------------------");

        for (int i = 0; i < (n - 1); i++) {
            System.out.println("Visit" + (i + 1) + " " + encounterHistory.get(i).formattedDateTime + " " + encounterHistory.get(i).getVitalSigns().toString());
        }

        System.out.println("----------------------------------------------------------------------------------------------------------------");
    }

    public void currentVitalSigns() {
        // System.out.println("Patients Name: " + Patient.personName);
        System.out.println("---------------------------------------------------------------------------------------------------------------\n"
                + "PATIENT'S CURRENT VITAL SIGNS                                                       NAME: " + super.getPersonName() +"("+super.getPersonAge()+"Y)\n"
                + "---------------------------------------------------------------------------------------------------------------");

        System.out.println("Visit" + (encounterHistory.size()) + " " + encounterHistory.get(encounterHistory.size()-1).formattedDateTime + " " + currentVitalSigns.toString());

        // System.out.println("      "+Patient.currentVitalSigns.toString());
        System.out.println("---------------------------------------------------------------------------------------------------------------");
    }

    public boolean isPatientNormal() {
        int n = super.getPersonAge();
        int a = currentVitalSigns.getHeartRate();
        int b = currentVitalSigns.getRespiratoryRate();
        int c = currentVitalSigns.getbloodPressure();
        int w = currentVitalSigns.getWeightKg();
        double wp = currentVitalSigns.getweightLb();

        if (n == 0) {
            if (a < 119 && b < 29) {
                System.out.println("-> Clinically decompensating child.");

            }
            if (a > 160 && b > 50 && c > 70) {
                System.out.println("-> Patient is suffering from fever or stress.");
            }
            if (a<120){
                System.out.println("-> Bradicardya in children Action Required childrens condition is critical.");
            }
            return 161 > a && a > 119 && b > 29 && 51 > b && c > 49 && c < 71 && w > 1 && w < 4 && wp >= 4.5 && wp < 8;

        } else if (n == 1) {
            if (a > 140 && b > 31 && c > 101) {
                System.out.println("-> Patient is suffering from fever or stress.");
            }
            if (a < 79 && b < 19) {
                System.out.println("-> Clinically decompensating child.");

            }
            if (a<80){
                System.out.println("-> Bradicardya in children Action Required childrens condition is critical.");
            }
            return 141 > a && a > 79 && b > 19 && 31 > b && c > 69 && c < 101 && w > 3 && w < 11 && wp >= 9 && wp < 23;
        } else if (n > 1 && n <= 3) {
            if (a < 79 && b < 19) {
                System.out.println("-> Clinically decompensating child.");

            }
            if (a > 130 && b > 31 && c > 111) {
                System.out.println("-> Patient is suffering from fever or stress.");
            }
              if (a<80){
                System.out.println("-> Bradicardya in children Action Required childrens condition is critical.");
            }
            return 131 > a && a > 79 && b > 19 && 31 > b && c > 79 && c < 111 && w > 9 && w < 15 && wp >= 22 && wp < 32;

        } else if (n > 3 && n <= 5) {
            if (a > 120 && b > 31 && c > 111) {
                System.out.println("-> Patient is suffering from fever or stress.");
            }
            if (a < 80 && b < 20) {
                System.out.println("-> Clinically decompensating child.");

            }
              if (a<80){
                System.out.println("-> Bradicardya in children Action Required childrens condition is critical.");
            }
            return 121 > a && a > 79 && b > 19 && 31 > b && c > 79 && c < 111 && w > 13 && w < 19 && wp >= 31 && wp < 41;
        } else if (n > 6 && n <= 12) {
            if (a < 70 && b < 20) {
                System.out.println("-> Clinically decompensating child.");

            }
            if (a > 110 && b > 31 && c > 111) {
                System.out.println("-> Patient is suffering from fever or stress.");
            }
              if (a<70){
                System.out.println("-> Bradicardya in children Action Required childrens condition is critical.");
            }
            return 111 > a && a > 69 && b > 19 && 31 > b && c > 79 && c < 111 && w > 19 && w < 43 && wp >= 41 && wp < 93;
        } else if (n > 12) {
            if (a > 106 && b > 21 && c > 111) {
                System.out.println("-> Patient is suffering from fever or stress.");

            }
            return 106 > a && a > 54 && b > 11 && 21 > b && c > 79 && c < 111 && w > 50 && wp > 110;
        } else {
            return false;
        }

    }

    public boolean isThisVitalSignNormal(String vitalSign) {
        int n = getPersonAge();

        int a = 0;
        int c = 0;
        int w = 0;
        int b = 0;
        double wp = 0;
        switch (vitalSign) {
            case "heartrate":
                a = currentVitalSigns.getHeartRate();
                break;

            case "systolicbp":
                c = currentVitalSigns.getbloodPressure();
                break;

            case "weight(kg)":
                w = currentVitalSigns.getWeightKg();
                break;

            case "weight(pounds)":
                wp = currentVitalSigns.getweightLb();
                break;

            //    case "weight(pounds)":
            // int a = patient.currentVitalSigns.getHeartRate();
            //  break;
            case "respiratoryrate":
                b = currentVitalSigns.getRespiratoryRate();
                break;

            default:
                System.out.println("no match found");
        }

        if (n == 0) {

            return (161 > a && a > 119) || (b > 29 && 51 > b) || (c > 49 && c < 71) || (w > 1 && w < 4) || (wp >= 4.5 && wp < 8);

        } else if (n == 1) {

            return 141 > a && a > 79 || b > 19 && 31 > b || c > 69 && c < 101 || w > 3 && w < 11 || wp >= 9 && wp < 23;
        } else if (n > 1 && n <= 3) {

            return 131 > a && a > 79 || b > 19 && 31 > b || c > 79 && c < 111 || w > 9 && w < 15 || wp >= 22 && wp < 32;

        } else if (n > 3 && n <= 5) {

            return 121 > a && a > 79 || b > 19 && 31 > b || c > 79 && c < 111 || w > 13 && w < 19 || wp >= 31 && wp < 41;
        } else if (n > 6 && n <= 12) {

            return 111 > a && a > 69 || b > 19 && 31 > b || c > 79 && c < 111 || w > 19 && w < 43 || wp >= 41 && wp < 93;
        } else if (n > 12) {

            return 106 > a && a > 54 || b > 11 && 21 > b || c > 79 && c < 111 || w > 50 || wp > 110;
        } else {
            return false;
        }

    }
    
    
    
}
