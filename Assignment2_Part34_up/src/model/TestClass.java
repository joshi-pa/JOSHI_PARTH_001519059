/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Scanner;

/**
 *
 * @author admin
 */
public class TestClass {

    public static void main(String[] args) {

        MainClass mainClass = new MainClass();
        Scanner scanner = new Scanner(System.in);

        System.out.println("We have 3 different patients and each of them has 3 vital signs\n");
        Community ck=new Community("Beacon Hill","02100");
        
        House h1=new House("155 Tree St.");
        House h2=new House("438 Bristol St.");
        
        
        ck.addHouse(h2);
        ck.addHouse(h1);
        
        
        
        Patient deep = new Patient("Deep Shah",0,"2013490634",h1);
        Patient parth = new Patient("Parth Joshi", 1,"2013492686",h2);
        Patient meeta = new Patient("Meeta Jain", 4,"2013562210",h2);
     
        
        

        VitalSigns vs = new VitalSigns(25, 85, 85, 12);
        VitalSigns vs1 = new VitalSigns(35, 125, 55, 3);  // heart rate deep(0Y) is only taken lower here for newbornbaby
        VitalSigns vs2 = new VitalSigns(36, 34, 34, 13);
        VitalSigns vs3 = new VitalSigns(25, 70, 60, 5);   
        VitalSigns vs4 = new VitalSigns(43, 73, 53, 16);
        VitalSigns vs5 = new VitalSigns(25, 75, 85, 12);  
        VitalSigns vs6 = new VitalSigns(63, 43, 33, 11);
        VitalSigns vs7 = new VitalSigns(25, 85, 85, 15);  
        VitalSigns vs8 = new VitalSigns(63, 43, 33, 19);
        VitalSigns vs9 = new VitalSigns(35, 125, 55, 3); 

        deep.addEncounter(vs);
        deep.addEncounter(vs4);
        deep.addEncounter(vs2);
        deep.addEncounter(vs7);
        deep.addEncounter(vs9);
        deep.addEncounter(vs1);

        parth.addEncounter(vs2);
        parth.addEncounter(vs1);
        parth.addEncounter(vs3);
        parth.addEncounter(vs2);
        parth.addEncounter(vs3);

        meeta.addEncounter(vs4);
        meeta.addEncounter(vs5);
        meeta.addEncounter(vs6);
        meeta.addEncounter(vs3);
        meeta.addEncounter(vs7);

    
        h1.addPatientInHouse(parth);
        h2.addPatientInHouse(meeta);
        h1.addPatientInHouse(deep);
        
        ck.listOfAbnormalPatiens("systollicBP");
        

        System.out.println("");
        
        
    
        }
        }

    


  



