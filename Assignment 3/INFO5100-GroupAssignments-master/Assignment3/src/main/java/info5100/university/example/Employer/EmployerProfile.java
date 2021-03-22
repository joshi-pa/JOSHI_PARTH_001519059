/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info5100.university.example.Employer;

import info5100.university.example.Persona.EmploymentHistory.Employment;
import java.util.ArrayList;

/**
 *
 * @author kal bugrara
 */
public class EmployerProfile {

    String name;
    int ranking;
    ArrayList<Employment> employments;

    public EmployerProfile(String n, int ranking) {  //could be company instead of just a name as a string
        this.name = n;
        this.ranking = ranking;

    }

    public boolean isMatch(String id) {
        if (name.equals(id)) {
            return true;             //String is an object and can do equal matach
        }
        return false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRanking() {
        return ranking;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }

    public ArrayList<Employment> getEmployments() {
        return employments;
    }

    public void setEmployments(ArrayList<Employment> employments) {
        this.employments = employments;
    }

}
