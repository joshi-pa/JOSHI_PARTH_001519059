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
 * @author admin
 */
public class Clinic {

    ArrayList<Patient> patientDirectory = new ArrayList<Patient>();
    City city = new City("Boston");

    public Clinic() {
    }

    public void Start() {

        Scanner scanner = new Scanner(System.in);
        printMainMenu();

        boolean stop = false;
        while (!stop) {
            System.out.println("Enter your choice: Press 7 to view main menu again. Press 6 to exit");
            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    addnewPatienttoTheDirectory();
                    break;
                case 2:
                    addEncountertoExsistingPatient();
                    break;
                case 3:
                    printPatientDirectory();
                    break;

                case 4:
                    printPersonDirectory();
                    break;

                case 5:
                    System.out.println("Total Number of people in community with Abnormal Blood Pressure \n");
                    city.printCommunityList();
                    System.out.println("Enter the serial number of the community in the above List");
                    int code = scanner.nextInt();
                    System.out.println("Following are the names of People in community with abnormal Systolic Blood Pressure: \n");
                    city.communityList.get(code -1).listOfAbnormalPatiens("bloodpressure");
                    System.out.println("Number of people with Abnormal Blood Pressure : " +(city.communityList.size()+1));
//                    city.listOfTotalAbnormalPatients();
                    break;

                case 6:
                    stop = true;
                    break;

                case 7:
                    printMainMenu();
                    break;

            }
        }
    }

    public void printPatientDirectory() {
        {

            int num = patientDirectory.size();
            System.out.println("************************************************************************************\n"
                    + "PATIENT DIRECTORY \n"
                    + "************************************************************************************");
            System.out.println("Name          Mobile Number");

            for (int i = 0; i < num; i++) {
                System.out.println((i + 1) + ". " + patientDirectory.get(i).getPersonName() + "   " + patientDirectory.get(i).getMobileNumber());
            }

            System.out.println("************************************************************************************");
        }
    }

    public void printPersonDirectory() {
        {

            int num = patientDirectory.size();
            System.out.println("************************************************************************************\n"
                    + "PERSON DIRECTORY                                                                    \n"
                    + "************************************************************************************");

            for (int i = 0; i < num; i++) {
                System.out.println((i + 1) + ". " + patientDirectory.get(i).toString());
            }

            System.out.println("************************************************************************************");
        }
    }

    public void addnewPatienttoTheDirectory() {
        
        int age1;
        
        Scanner scanner = new Scanner(System.in);
        String patientName = null;
        String mobileNumber = null;

        System.out.println("Enter Patient's Name:");

        patientName = scanner.nextLine();

        System.out.println("Enter Patient's Age:");

        age1 = scanner.nextInt();

        int age = age1;

        System.out.println("Enter Patient's Mobile Number:");

        mobileNumber = stringscan();

        System.out.println("Enter Patient's Residence details:");

        Community comm = city.addCommunityToCity();
        House house1 = comm.addNewHouseToCommunity();

        Patient patient = new Patient(patientName, age, mobileNumber, house1);
        house1.addPatientInHouse(patient);

        System.out.println("Enter Patient's Vital Signs");
        patient.newEncounter();
        patientDirectory.add(patient);

        System.out.println("");

    }

    public void printMainMenu() {
        System.out.println("Avalible Options:\nPress one of the following option to select.\n"
                + "1-To add a new Patient.\n"
                + "2-To add an Encounter (Visit) to the exsisting Patient.\n"
                + "3-To view Patient Directory.\n"
                + "4-To view Person Directory.\n"
                + "5-To calculate number of patient in the community with abnormal Systollic Blood Pressure.\n"
                + "7-Exit.\n"
                + "8-To print menu again.");

    }

    public void checkPatienAlreadyExist() {
    }

    public static String stringscan() {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        return str;
    }

    private int checkIfNumberALreadyExists(String mobileNumber) {
        for (int i = 0; i < patientDirectory.size(); i++) {

            {
                if (patientDirectory.get(i).getMobileNumber() == null ? mobileNumber == null : patientDirectory.get(i).getMobileNumber().equals(mobileNumber)) {
                    System.out.println("Enterd number is linked to " + patientDirectory.get(i).getPersonName());
                    return i;
                }
            }

        }
        return -1;
    }

    private void addEncountertoExsistingPatient() {

        System.out.println("Enter Patients Mobile Number:");
        String mobilenum = stringscan();
        if (checkIfNumberALreadyExists(mobilenum) == -1) {
            System.out.println("This Patient dosent exist.");
        } else {
            System.out.println("For Patient -> " + patientDirectory.get(checkIfNumberALreadyExists(mobilenum)).getPersonName());

            avalibleOptions(patientDirectory.get(checkIfNumberALreadyExists(mobilenum)));

        }
    }

    public static void printActions() {

        System.out.println("Avalible options are:");


        System.out.println("");
        System.out.println("1 - to check patient is normal?.");
        System.out.println("2 - to check patients current vital signs.");
        System.out.println("3 - to add new patient encounter.");
        System.out.println("4 - to view patients encounter history.");
        System.out.println("5 - to know patients vital sign is normal or not?");
        System.out.println("6 - Exit.");
        System.out.println("9 - To view options again");
        System.out.println("");

    }

    public static void avalibleOptions(Patient patient) {

        Scanner scanner = new Scanner(System.in);
        boolean stop = false;
        printActions();
        while (!stop) {

            System.out.println("\nEnter your choice: (press 9 to view options again)");
            int option = scanner.nextInt();

            System.out.println("");
            switch (option) {

                case 1:
                    if (patient.isPatientNormal()) {
                        System.out.println("-> Patient is Normal");
                    } else {
                        System.out.println("-> Patient is Not Normal");
                    }

                    break;

                case 2:
                    patient.currentVitalSigns();
                    break;
                case 3:
                    patient.newEncounter();
                    break;
                case 4:
                    patient.viewPatientEncounterHistory();
                    break;
                case 5:
                    System.out.println("Enter the Vital Sign to check if the vital sign is normal \n Enter 'respiratoryrate' - Respiratory Rate, 'heartrate' - Heart Rate, 'bloodpressure' - Systolic Blood Pressure, 'weightinkg'- Weight in Kgs, 'weightinlb'- Weight in Lbs");

                    if (patient.isThisVitalSignNormal(stringscan())) {
                        System.out.println("The entered Vital Sign is Normal and in the normal range");
                    } else {
                        System.out.println("The entered Vital Sign is Ab-Normal and in the not normal range");
                    }
                    break;
                case 6:
                    stop = true;
                    break;
                case 9:
                    printActions();
                    break;

                default:
                    break;

            }
        }
    }

}
