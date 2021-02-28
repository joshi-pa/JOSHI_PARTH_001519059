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
public class Clinic {
    
    ArrayList<Patient> patientDirectory = new ArrayList<Patient>();

    public Clinic() {
    }

    public void Start() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Avalible actions:\npress\n"
                + "1-Add new Patient.\n"
                + "2-print patient directory.\n"
                + "3-");

    }

    public void printPatientDirectory() {
        {

            int n = patientDirectory.size();
            System.out.println("----------------------------------------------------------------------------------------------------------------\n"
                    + "PATIENT DIRECTORY                                                                                             \n"
                    + "----------------------------------------------------------------------------------------------------------------");

            for (int i = 0; i < n; i++) {
                System.out.println((i + 1) + ". " + patientDirectory.get(i).getPersonName() + " " + patientDirectory.get(i).getHouse().getHouseAdress());
            }

            System.out.println("----------------------------------------------------------------------------------------------------------------");
        }
    }

    public void addNewPatientToDirectory() {
        //System.out.println("---------------------------------------------------------------------");
        System.out.println("Please fill out patients Name, Age and Vital Signs for the record.\n"
                + "Refer the information below for the Age\n"
                + "New born   - 0 years\n"
                + "Infant     - 1 years\n"
                + "Toddler    - 1-3 years\n"
                + "PreSchooler- 3-5 years\n"
                + "SchoolAge  - 6-12 years\n"
                + "Adolescent - 13+ years\n");
        // System.out.println("---------------------------------------------------------------------");
        System.out.println("");
        System.out.println("Let Start....");
        System.out.println("");

        Scanner scanner = new Scanner(System.in);
        String patientName = null;
        String mobileNumber = null;

        System.out.println("Enter Patient's Name:");

        boolean quit = false;
        while (!quit) {

            patientName = scanner.nextLine();

           
        System.out.println("Enter Patient's Age:");
        int age = scanner.nextInt();

        System.out.println("Enter Patient's Mobile Number:");


        

        City boston = new City("Boston");

        System.out.println("Enter Patient's Residence details:");
        Community ck = boston.addCommunityToCity();
        House house1 = ck.addNewHouseToCommunity();

        Patient john = new Patient(patientName, age, mobileNumber, house1);

        System.out.println("Enter Patient's Vital Signs");
        john.newEncounter();
        patientDirectory.add(john);

        System.out.println("");

    }
    }

    public static String scanne() {
        Scanner scanner = new Scanner(System.in);
        String sk = scanner.nextLine();
        return sk;
    }

    private boolean numberAlreadyExist(String mobileNumber) {
        for (int i = 0; i < patientDirectory.size(); i++)
          
        { if (patientDirectory.get(i).getMobileNumber() == null ? mobileNumber == null : patientDirectory.get(i).getMobileNumber().equals(mobileNumber)) {
                System.out.println("Enterd number is linked to " + patientDirectory.get(i).getPersonName());
                return true;
               }
       
     }
       return false;
    }

}  
   
