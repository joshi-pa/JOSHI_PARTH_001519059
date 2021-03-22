/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info5100.university.example.Persona;

import info5100.university.example.CourseSchedule.CourseLoad;
import info5100.university.example.CourseSchedule.CourseOffer;
import info5100.university.example.Persona.EmploymentHistory.EmploymentHistory;
import java.util.List;

/**
 *
 * @author kal bugrara
 */
public class StudentProfile {

    public Transcript getTranscript() {
        return transcript;
    }

    public void setTranscript(Transcript transcript) {
        this.transcript = transcript;
    }

    public EmploymentHistory getEmploymenthistory() {
        return employmenthistory;
    }

    public void setEmploymenthistory(EmploymentHistory employmenthistory) {
        this.employmenthistory = employmenthistory;
    }

    private Person person;
    Transcript transcript;
    EmploymentHistory employmenthistory;

    public StudentProfile(Person p) {

        setPerson(p);
        transcript = new Transcript();
        employmenthistory = new EmploymentHistory();
    }

    public boolean isMatch(String id) {
        if (getPerson().getPersonId().equals(id)) {
            return true;
        }
        return false;
    }

    public CourseLoad getCourseLoadBySemester(String semester) {

        return transcript.getCourseLoadBySemester(semester);
    }

    public CourseLoad getCurrentCourseLoad() {

        return transcript.getCurrentCourseLoad();
    }

    public CourseLoad newCourseLoad(String s) {

        return transcript.newCourseLoad(s);
    }

    public List<CourseOffer> getCoursesTaken() {

        return transcript.getCourses();
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public float getGPA() {
        if (transcript == null) {
            return 0;
        }
        return transcript.calculateGPA();
    }

    @Override
    public String toString() {
        return this.person.getPersonId();
    }

}
