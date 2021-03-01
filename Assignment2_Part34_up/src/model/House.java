/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author admin
 */
public class House {
    private String houseAdress;
    private ArrayList<Patient> houseMem;

    public House(String houseAdress) {
        this.houseAdress = houseAdress;
        houseMem= new ArrayList<>();
    }

    public String getHouseAdress() {
        return houseAdress;
    }

    public void setHouseAdress(String houseAdress) {
        this.houseAdress = houseAdress;
    }
    
    public void addPatientInHouse(Patient patient){
    houseMem.add(patient);
    }

    public ArrayList<Patient> getHouseMem() {
        return houseMem;
    }
    
    
   

  
}
