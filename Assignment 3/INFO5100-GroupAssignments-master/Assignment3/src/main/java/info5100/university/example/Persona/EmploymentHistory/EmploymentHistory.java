/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info5100.university.example.Persona.EmploymentHistory;

import java.util.ArrayList;

/**
 *
 * @author kal bugrara
 */
public class EmploymentHistory {

    ArrayList<Employment> employments;
    int promotions = 0;

    public EmploymentHistory() {
        employments = new ArrayList();
    }

    public Employment newEmployment(Employment ne) {

        if (employments.size() > 0) {
            Employment last = employments.get(employments.size() - 1);
            if (!last.getPosition().equalsIgnoreCase(ne.getPosition())) {
                promotions++;
            }
        }
        employments.add(ne);

        return ne;
    }

    public ArrayList<Employment> getEmployments() {
        return employments;
    }

    public void setEmployments(ArrayList<Employment> employments) {
        this.employments = employments;
    }

    public int getPromotions() {
        return promotions;
    }

    public void setPromotions(int promotions) {
        this.promotions = promotions;
    }

}
