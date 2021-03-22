/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info5100.university.example.Employer;


import info5100.university.example.Department.Department;
import java.util.ArrayList;

/**
 *
 * @author kal bugrara
 */
public class EmployerDirectory {

    Department department;
    ArrayList<EmployerProfile> employerlist;

    public EmployerDirectory(Department d) {

        department = d;
        employerlist = new ArrayList();

    }

//    public EmployerProfile newEmployerProfile(String n) {
//
//        EmployerProfile sp = new EmployerProfile(n);
//        employerlist.add(sp);
//        return sp;
//    }

    public EmployerProfile findTeachingFaculty(String id) {

        for (EmployerProfile ep : employerlist) {

            if (ep.isMatch(id)) {
                return ep;
            }
        }
            return null; //not found after going through the whole list
         }
    
    public EmployerProfile newEmployerProfile (String name,int ranking ) {
    	EmployerProfile ep = new EmployerProfile(name, ranking);
    	employerlist.add(ep);
    	return ep;
    }

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public ArrayList<EmployerProfile> getEmployerlist() {
		return employerlist;
	}

	public void setEmployerlist(ArrayList<EmployerProfile> employerlist) {
		this.employerlist = employerlist;
	}
    
    
}
