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
public class Community {
    
    private String zipCode;
    private String communityName;
    private ArrayList<House> housesList=new ArrayList<House>();

    public Community(String communityName,String zipCode) {
        this.communityName = communityName;
        this.zipCode=zipCode;
        
    }
    public void addHouse(House house){
    this.housesList.add(house);
    }

    public String getCommunityName() {
        return communityName;
    }

    public void setCommunityName(String communityName) {
        this.communityName = communityName;
    }

    public ArrayList<House> getHouseList() {
        return housesList;
    }

    public void setHouseList(ArrayList<House> housesList) {
        this.housesList = housesList;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
    
    
    public House addNewHouseToCommunity(){
    Scanner scanner=new Scanner(System.in);
    System.out.println("Enter the address of the House:"); 
    String residAddress = scanner.nextLine();
       
       if(checkIfHouseAlreadyExists(residAddress)==-1){
           House house =new House(residAddress);
          housesList.add(house);
           return house;
       } else{
           return housesList.get(checkIfHouseAlreadyExists(residAddress));
       }
    }
    
    
    public int checkIfHouseAlreadyExists(String houseAdress){
     
       
         for(int i=0;i<housesList.size();i++){
               if(!(housesList.get(i).getHouseAdress() == null ? houseAdress == null : housesList.get(i).getHouseAdress().equals(houseAdress))){
        } else {
                   return i;
             }   
         }
         return -1;
    }
    
     
    public void listOfAbnormalPatiens(String vitalsign){              //Print only Abnormal Patients
    
        for(int i=0;i<housesList.size();i++){
            for(int j=0;j<housesList.get(i).getHouseMem().size();j++){
                if(!(housesList.get(i).getHouseMem().get(j).isThisVitalSignNormal(vitalsign))){
                    System.out.println(housesList.get(i).getHouseMem().get(j).getPersonName());
                }
                    }
        }}
        
        public void listOfTotalAbnormalPatients(){
        
            int count =0;
        for(int i=0;i<housesList.size();i++){
            for(int j=0;j<housesList.get(i).getHouseMem().size();j++){
                if(!(housesList.get(i).getHouseMem().get(j).isPatientNormal())){
                    count++; 
                }
            }
        }
        System.out.println("Total Number of Abnormal Patients in this community are : " +count);
        
    }

}
