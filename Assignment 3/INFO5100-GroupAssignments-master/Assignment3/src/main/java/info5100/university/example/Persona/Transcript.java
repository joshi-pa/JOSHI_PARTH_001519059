/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info5100.university.example.Persona;

import info5100.university.example.CourseSchedule.CourseLoad;
import info5100.university.example.CourseSchedule.CourseOffer;
import info5100.university.example.CourseSchedule.SeatAssignment;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author kal bugrara
 */
public class Transcript {

    HashMap<String, CourseLoad> courseloadlist;

    CourseLoad currentcourseload;

    public Transcript() {

        courseloadlist = new HashMap<String, CourseLoad>();

    }

    public CourseLoad newCourseLoad(String sem) {

        currentcourseload = new CourseLoad(sem);
        courseloadlist.put(sem, currentcourseload);
        return currentcourseload;
    }

    public CourseLoad getCurrentCourseLoad() {

        return currentcourseload;

    }

    public CourseLoad getCourseLoadBySemester(String semester) {

        return courseloadlist.get(semester);
    }

    public List<CourseLoad> getTotalCourseLoad() {
        List<CourseLoad> list = new ArrayList<>();
        for (CourseLoad c : courseloadlist.values()) {
            list.add(c);
        }
        return list;
    }

    public List<CourseOffer> getCourses() {
        List<CourseOffer> list = new ArrayList<>();
        for (CourseLoad c : getTotalCourseLoad()) {
            list.addAll(c.getListOfCoursesForCourseLoad());
        }
        return list;
    }

    public List<SeatAssignment> getSeatAssignments() {
        List<SeatAssignment> list = new ArrayList<>();
        for (CourseLoad c : getTotalCourseLoad()) {
            list.addAll(c.getSeatassignments());
        }
        return list;
    }

    public float calculateGPA() {

        float totalGpa = 0;
        ArrayList<SeatAssignment> saList = new ArrayList<>();
        for (CourseLoad cl : courseloadlist.values()) {
            saList.addAll(cl.getSeatassignments());
        }
        for (SeatAssignment sa : saList) {
            totalGpa += sa.getScore();
        }
        return totalGpa / saList.size();
    }

}
