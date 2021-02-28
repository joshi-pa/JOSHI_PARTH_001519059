/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import java.util.ArrayList;
/**
 *
 * @author 12013
 */
public class House {
    
    private String houseAdress;
    private ArrayList<Patient> houseMembers;

    public House(String houseAdress) {
        this.houseAdress = houseAdress;
        houseMembers= new ArrayList<>();
    }

    public String getHouseAdress() {
        return houseAdress;
    }

    public void setHouseAdress(String houseAdress) {
        this.houseAdress = houseAdress;
    }
    
    public void addPatientInHouse(Patient patient){
    houseMembers.add(patient);
    }

    public ArrayList<Patient> getHouseMembers() {
        return houseMembers;
    }
    
}
