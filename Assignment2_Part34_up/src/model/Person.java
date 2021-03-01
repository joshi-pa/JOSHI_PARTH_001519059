/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author admin
 */
public class Person {
    
    private String personName;
    private int personAge;
    private String mobileNumber;
    private House house;
   

    public Person(String personName, int personAge, String mobileNumber, House residence) {
        this.personName = personName;
        this.personAge = personAge;
        this.mobileNumber = mobileNumber;
        this.house=residence;
        
    }

    public House getHouse() {
        return house;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }
    
        
    public String getPersonName() {
        return personName;
    }
        

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public int getPersonAge() {
        return personAge;
    }

    public void setPersonAge(int personAge) {
        this.personAge = personAge;
    }
    
       @Override
    public String toString() {
        return  "Person Name : " + personName + ", Person Age : " + personAge + ", Mobile Number : " + mobileNumber+", Address : "+house.getHouseAdress();
    }

}
