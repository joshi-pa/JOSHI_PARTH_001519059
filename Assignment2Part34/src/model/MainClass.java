/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import java.util.Scanner;
/**
 *
 * @author 12013
 */
public class MainClass {
    
    public static void main(String[] args) {
        
        
        Clinic bostonClinic = new Clinic();
        bostonClinic.Start();
        
    }

    public static void avalibleOptions(Patient patient) {
        
        Scanner scanner = new Scanner(System.in);
        boolean close = false;
        printActions();
        while (!close) {
            
            System.out.println("");
            System.out.println("Enter your choice: (press 9 to view options again)");
            int choice = scanner.nextInt();

            System.out.println("");
            switch (choice) {

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
                    System.out.println("type patients vitals sign you want to know about?\n(heartrate,systolicbp,respiratoryrate,weight(kg)),weight(pounds)");
                    
                    
                     
                   if(patient.isThisVitalSignNormal(scanne())){
                       System.out.println("Normal-in range");
                   }else{System.out.println("Ab Normal-not in range");}
                    break;
                case 6:
                    close = true;
                    break;
                case 9:
                    printActions();
                    break;

                default:
                    break;

            }
        }
    }
    public static String scanne(){
    Scanner scanner = new Scanner(System.in);
    String scan =scanner.nextLine();
    return scan;
    }

    public static void printActions(){

                System.out.println("Avalible options are:\n");
                System.out.println("1 - to check patient is normal?.");
                System.out.println("2 - to check patients current vital signs.");
                System.out.println("3 - to add new vital signs.");
                System.out.println("4 - to view patients history.");
                System.out.println("5 - to know patients vital sign is normal or not?");
                System.out.println("6 - Exit.");
                System.out.println("9 - To view options again");
                System.out.println("");
    }
    
}
