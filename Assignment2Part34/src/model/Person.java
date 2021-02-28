/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author 12013
 */
public class Person {
    
    private String personName;
    private int personAge;
    private String mobileNum;
    private House house;
   

    public Person(String personName, int personAge, String mobileNum, House residence) {
        this.personName = personName;
        this.personAge = personAge;
        this.mobileNum = mobileNum;
        this.house=residence;
        
        
        
    }

    public House getHouse() {
        return house;
    }

    public String getmobileNum() {
        return mobileNum;
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

    
}
