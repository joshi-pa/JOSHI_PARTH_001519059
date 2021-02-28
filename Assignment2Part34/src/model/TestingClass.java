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
public class TestingClass {
    
    public static void main(String[] args) {

        MainClass mainClass = new MainClass();

        Scanner scanner = new Scanner(System.in);

        System.out.println("We have 3 patients and each of them have 3 different vital signs");
        System.out.println("\n");
        Community ck=new Community("Harrison","02115");
        
        House h1=new House("1007 6th Street.");
        House h2=new House("506 Oakridge Dr.");
        
        
        ck.addHouse(h2);
        ck.addHouse(h1);
        
        
        
        Patient parth = new Patient("parth Joshi ",0,"3265985204",h1);
        Patient prachi = new Patient("prachi Jain .", 1,"1154542112",h2);
        Patient meeta = new Patient("meeta Shah", 4,"6565656261",h2);
      
        
        

        VitalSigns vs = new VitalSigns(25, 85, 85, 12);
        VitalSigns vs1 = new VitalSigns(35, 125, 55, 3);  
        VitalSigns vs2 = new VitalSigns(36, 34, 34, 13);
        VitalSigns vs3 = new VitalSigns(25, 70, 60, 5);   
        VitalSigns vs4 = new VitalSigns(43, 73, 53, 16);
        VitalSigns vs5 = new VitalSigns(25, 75, 85, 12);  
        VitalSigns vs6 = new VitalSigns(63, 43, 33, 11);
        VitalSigns vs7 = new VitalSigns(25, 85, 85, 15);   
        VitalSigns vs8 = new VitalSigns(63, 43, 33, 19);
        VitalSigns vs9 = new VitalSigns(35, 125, 55, 3);  

        parth.addEncounter(vs);
        parth.addEncounter(vs4);
        parth.addEncounter(vs2);
        parth.addEncounter(vs7);
        parth.addEncounter(vs9);
        parth.addEncounter(vs1);

        prachi.addEncounter(vs2);
        prachi.addEncounter(vs1);
        prachi.addEncounter(vs3);
        prachi.addEncounter(vs2);
        prachi.addEncounter(vs3);


        meeta.addEncounter(vs4);
        meeta.addEncounter(vs5);
        meeta.addEncounter(vs6);
        meeta.addEncounter(vs3);
        meeta.addEncounter(vs7);

        
        
        h1.addPatientInHouse(prachi);
        h2.addPatientInHouse(meeta);
        h1.addPatientInHouse(parth);
        
        ck.listOfAbnormalPatiens("systolicbp");
        
        System.out.println(parth.isPatientNormal());
        

        System.out.println("");
        
        
        boolean close =false;
       while(!close){
        System.out.println("Choose Patient:\n"
                + "1.parth (new born baby)\n"
                + "2.prachi  (infant)\n"
                + "3.meeta  (school age)\n"
                );

        
            int num = scanner.nextInt();
        

        switch (num) {
            case 1:
                mainClass.avalibleOptions(parth);
                break;

            case 2:
                mainClass.avalibleOptions(prachi);
                break;
            case 3:
                mainClass.avalibleOptions(meeta);
                break;
                
            case 6:
                close= true;
                break;
                
                default:
                    break;
        }
        }

    }

    
}
