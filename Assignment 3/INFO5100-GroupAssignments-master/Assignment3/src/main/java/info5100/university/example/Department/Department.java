/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info5100.university.example.Department;

import info5100.university.example.CourseCatalog.Course;
import info5100.university.example.CourseCatalog.CourseCatalog;
import info5100.university.example.CourseSchedule.CourseLoad;
import info5100.university.example.CourseSchedule.CourseOffer;
import info5100.university.example.CourseSchedule.CourseSchedule;
import info5100.university.example.Persona.EmploymentHistory.Employment;
import info5100.university.example.Persona.Faculty.FacultyDirectory;
import info5100.university.example.Persona.PersonDirectory;
import info5100.university.example.Persona.StudentDirectory;
import info5100.university.example.Persona.StudentProfile;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 *
 * @author kal bugrara
 */
public class Department {

    String name;
    CourseCatalog coursecatalog;
    PersonDirectory persondirectory;
    StudentDirectory studentdirectory;
    FacultyDirectory facultydirectory;
    //EmployerDirectory employerdirectory;

    HashMap<String, CourseSchedule> mastercoursecatalog;

    public Department(String n) {
        name = n;
        mastercoursecatalog = new HashMap<String, CourseSchedule>();
        coursecatalog = new CourseCatalog(this);
        studentdirectory = new StudentDirectory(this); //pass the department object so it stays linked to it
        persondirectory = new PersonDirectory();
    }

    public PersonDirectory getPersonDirectory() {

        return persondirectory;

    }

    public StudentDirectory getStudentDirectory() {
        return studentdirectory;
    }

    public CourseSchedule newCourseSchedule(String semester) {

        CourseSchedule cs = new CourseSchedule(semester, coursecatalog);
        mastercoursecatalog.put(semester, cs);
        return cs;
    }

    public CourseSchedule getCourseSchedule(String semester) {

        return mastercoursecatalog.get(semester);

    }

    public CourseCatalog getCourseCatalog() {

        return coursecatalog;

    }

    public Course newCourse(String n, String nm, int cr) {

        Course c = coursecatalog.newCourse(n, nm, cr);
        return c;
    }

    public int calculateRevenuesBySemester(String semester) {

        CourseSchedule css = mastercoursecatalog.get(semester);

        return css.calculateTotalRevenues();

    }

    public void RegisterForAClass(String studentid, String cn, String semester) {

        StudentProfile sp = studentdirectory.findStudent(studentid);

        CourseLoad cl = sp.getCurrentCourseLoad();

        CourseSchedule cs = mastercoursecatalog.get(semester);

        CourseOffer co = cs.getCourseOfferByNumber(cn);

        co.assignEmptySeat(cl);

    }

    public String getName() {
        return this.name;
    }

    public HashMap<String, CourseSchedule> getMastercoursecatalog() {
        return mastercoursecatalog;
    }

    public void setCoursecatalog(CourseCatalog coursecatalog) {
        this.coursecatalog = coursecatalog;
    }

    public List<CourseOffer> getPopuplarCourses(String semester) {
        List<CourseOffer> list = new ArrayList<>();
        CourseSchedule co = mastercoursecatalog.get(semester);
        list.addAll(co.getPopularCourses());
        return list;
    }

    public Set<String> getPopularCoursesBySalary() {
        List<StudentProfile> list = this.getStudentDirectory().getStudentlist();
        Collections.sort(list,
                (o1, o2)
                -> new Double(o2.getEmploymenthistory().getEmployments().get(o2.getEmploymenthistory().getEmployments().size() - 1).getSalary()).compareTo(o1.getEmploymenthistory().getEmployments().get(o1.getEmploymenthistory().getEmployments().size() - 1).getSalary())
        );

        List<CourseOffer> courselist = new ArrayList<>();
        //taking top 3 max salaries
        for (int i = 0; i <= 2; i++) {
            List<Employment> emp = list.get(i).getEmploymenthistory().getEmployments();
            courselist.addAll(emp.get(emp.size() - 1).getRelevantcourseoffers());
        }
        Set<String> namesList = courselist.stream()
                .map(CourseOffer::getCourseName)
                .collect(Collectors.toSet());
        return namesList;
    }

    public Set<String> getPopularCoursesByPromotion() {
        List<StudentProfile> list = this.getStudentDirectory().getStudentlist().stream().filter(p -> p.getEmploymenthistory().getPromotions() >= 2).collect(Collectors.toCollection(ArrayList::new));
        List<CourseOffer> courselist = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            List<Employment> emp = list.get(i).getEmploymenthistory().getEmployments();
            courselist.addAll(emp.get(emp.size() - 1).getRelevantcourseoffers());
        }
        Set<String> namesList = courselist.stream()
                .map(CourseOffer::getCourseName)
                .collect(Collectors.toSet());
        return namesList;
    }

    public Set<String> getPopularCoursesByCompanyRanking() {
        List<StudentProfile> list = this.getStudentDirectory().getStudentlist().stream().filter(p -> p.getEmploymenthistory().getEmployments().get(p.getEmploymenthistory().getEmployments().size() - 1).getEmployer().getRanking() <= 3).collect(Collectors.toCollection(ArrayList::new));
        List<CourseOffer> courselist = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            List<Employment> emp = list.get(i).getEmploymenthistory().getEmployments();
            courselist.addAll(emp.get(emp.size() - 1).getRelevantcourseoffers());
        }
        Set<String> namesList = courselist.stream()
                .map(CourseOffer::getCourseName)
                .collect(Collectors.toSet());
        return namesList;
    }

    public double percentageOfStudentsAboveAverageSalary() {
        List<StudentProfile> list = this.getStudentDirectory().getStudentlist().stream().filter(p -> p.getEmploymenthistory().getEmployments().get(p.getEmploymenthistory().getEmployments().size() - 1).getSalary() >= 120000).collect(Collectors.toCollection(ArrayList::new));
        return ((double) list.size() / (double) this.getStudentDirectory().getStudentlist().size()) * 100;
    }

    public double percentageOfStudentsInTop5Ranking() {
        List<StudentProfile> list = this.getStudentDirectory().getStudentlist().stream().filter(p -> p.getEmploymenthistory().getEmployments().get(p.getEmploymenthistory().getEmployments().size() - 1).getEmployer().getRanking() <= 5).collect(Collectors.toCollection(ArrayList::new));
        return ((double) list.size() / (double) this.getStudentDirectory().getStudentlist().size()) * 100;
    }

    public double percentageOfStudentsBasedonGPA() {
        List<StudentProfile> list = this.getStudentDirectory().getStudentlist().stream().filter(p -> p.getGPA() >= 3.5).collect(Collectors.toCollection(ArrayList::new));
        return ((double) list.size() / (double) this.getStudentDirectory().getStudentlist().size()) * 100;
    }

    public double percentageOfStudentsBasedonPromotions() {
        List<StudentProfile> list = this.getStudentDirectory().getStudentlist().stream().filter(p -> p.getEmploymenthistory().getPromotions() >= 2).collect(Collectors.toCollection(ArrayList::new));
        return ((double) list.size() / (double) this.getStudentDirectory().getStudentlist().size()) * 100;
    }

    public ArrayList<StudentProfile> sortBySalary(ArrayList<StudentProfile> list) {
        Collections.sort(list,
                (o1, o2)
                -> new Double(o2.getEmploymenthistory().getEmployments().get(o2.getEmploymenthistory().getEmployments().size() - 1).getSalary()).compareTo(o1.getEmploymenthistory().getEmployments().get(o1.getEmploymenthistory().getEmployments().size() - 1).getSalary())
        );
        return list;
    }

    public ArrayList<StudentProfile> sortByGPA(ArrayList<StudentProfile> list) {
        Collections.sort(list,
                (o1, o2) -> Float.compare(o2.getGPA(), o1.getGPA())
        );
        return list;
    }

    public ArrayList<StudentProfile> sortByID(ArrayList<StudentProfile> list) {
        list.sort((o1, o2) -> Integer.parseInt(o1.getPerson().getPersonId()) - Integer.parseInt(o2.getPerson().getPersonId()));
        return list;
    }
}
