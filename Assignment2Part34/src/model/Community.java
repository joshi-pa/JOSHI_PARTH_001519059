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
    private String communityName;
    private ArrayList<House> houseList=new ArrayList<House>();;
    private String zipCode;

    public Community(String communityName,String zipCode) {
        this.communityName = communityName;
        
    }
    public void addHouse(House house){
    this.houseList.add(house);
    }

    public String getCommunityName() {
        return communityName;
    }

    public void setCommunityName(String communityName) {
        this.communityName = communityName;
    }

    public ArrayList<House> getHouseList() {
        return houseList;
    }

    public void setHouseList(ArrayList<House> houseList) {
        this.houseList = houseList;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
    
     public int checkHouseAlreadyExist(String houseAdress){
     
       
         for(int i=0;i<houseList.size();i++){
               if(houseList.get(i).getHouseAdress()== houseAdress){
                   
           return i;
        }   
         }
         return -1;
         }
    
    public House addNewHouseToCommunity(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter House Adress:"); 
        String residenceAdress = scanner.nextLine();
       
       
       
       if(checkHouseAlreadyExist(residenceAdress)== -1){
            House h1=new House(residenceAdress);
            addHouse(h1);
            return h1;
       } else{
            return houseList.get(checkHouseAlreadyExist(residenceAdress));
       }
    } 
    public void listOfAbnormalPatients(String vitalsign){
    
        for(int i=0;i<houseList.size();i++){
            for(int j=0;j<houseList.get(i).getHouseMembers().size();j++){
                if(!(houseList.get(i).getHouseMembers().get(j).isThisVitalSignNormal(vitalsign))){
                    System.out.println(houseList.get(i).getHouseMembers().get(j).getPersonName());
                }
            }
        }
        
    }

}
