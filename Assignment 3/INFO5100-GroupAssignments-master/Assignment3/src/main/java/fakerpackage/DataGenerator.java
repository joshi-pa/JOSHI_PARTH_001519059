/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fakerpackage;


import info5100.university.example.CourseSchedule.CourseLoad;
import info5100.university.example.CourseSchedule.CourseOffer;
import info5100.university.example.CourseSchedule.CourseSchedule;
import info5100.university.example.Department.Department;
import info5100.university.example.Employer.EmployerDirectory;
import info5100.university.example.Employer.EmployerProfile;
import info5100.university.example.Persona.Person;
import info5100.university.example.Persona.PersonDirectory;
import info5100.university.example.Persona.StudentDirectory;
import info5100.university.example.Persona.StudentProfile;

import info5100.university.example.Persona.EmploymentHistory.Employment;
import info5100.university.example.Persona.EmploymentHistory.EmploymentHistory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import com.github.javafaker.Faker;
import info5100.university.example.CourseSchedule.SeatAssignment;

/**
 *
 * @author Kunjan
 */
public class DataGenerator {

    private final Random rand;
    private static DataGenerator instance;

    public static DataGenerator getInstance() {
        if (instance == null) {
            instance = new DataGenerator();
        }
        return instance;
    }

    private DataGenerator() {

        rand = new Random();

    }

    public Department generateDepartmentData() {

        Faker faker = new Faker();
        // String[] name = {"INFO", "CSYE", "SSE"};
        Department d = new Department("INFO");
        // CourseCatalog c = new CourseCatalog(d);
        float leftLimit = 3.0F;
        float rightLimit = 4F;
        //Create courses
        for (int i = 1; i <= 10; i++) {
            d.newCourse(d.getName() + "-" + i, Integer.toString(i), i);

        }
        //Create Employers
        EmployerDirectory ed = new EmployerDirectory(d);
        for (int i = 0; i <= 10; i++) {
            int num = rand.nextInt(10);
            if (num == 0) {
                num = 1;
            }
            ed.newEmployerProfile(faker.company().name(), num);
        }

        CourseSchedule fall15courseschedule = d.newCourseSchedule("Fall2015");
        //Create courseOffers for 2015
        for (int i = 1; i <= 10; i++) {

            CourseOffer courseoffer = fall15courseschedule.newCourseOffer(Integer.toString(i));
            courseoffer.generatSeats(30);

        }

        //Create student data with courses and their registeration of courses
        for (int j = 0; j <= 30; j++) {
            PersonDirectory pd = d.getPersonDirectory();

            Person person = pd.newPerson(Integer.toString(j + 1), faker.name().fullName());
            StudentDirectory sd = d.getStudentDirectory();
            StudentProfile student = sd.newStudentProfile(person);
            CourseLoad courseload = student.newCourseLoad("Fall2015");

            ArrayList<CourseOffer> list = fall15courseschedule.getSchedule();
            Collections.shuffle(list);
            // System.out.println("Registeration for student :"+student.getPerson().getId());
            for (int i = 1; i <= 8; i++) {
                SeatAssignment sa = courseload.newSeatAssignment(list.get(i), leftLimit + rand.nextFloat() * (rightLimit - leftLimit));//register student in class

            }

        }

        //Create Employment Details of students
        for (StudentProfile s : d.getStudentDirectory().getStudentlist()) {
            //System.out.println();
            //System.out.print(s.getPerson().getId()+" ");
            EmploymentHistory e = new EmploymentHistory();
            List<CourseOffer> courseOfferList = s.getCourseLoadBySemester("Fall2015").getListOfCoursesForCourseLoad();
            Collections.shuffle(courseOfferList);
            ArrayList<CourseOffer> l = new ArrayList();
            //if(courseOfferList.size()>0){
            l.add(courseOfferList.get(0));
            l.add(courseOfferList.get(courseOfferList.size() - 1));
            int num = rand.nextInt(3);
            List<EmployerProfile> list = ed.getEmployerlist();
            Collections.shuffle(list);
            double salary = ThreadLocalRandom.current().nextDouble(90000, 120000);
            if (num == 0) {
                num += 1;
            }
            if (s.getGPA() > 3.5) {
                salary = 130000;
            }
            for (int i = 1; i <= num + 1; i++) {
                Employment ep = new Employment(l, faker.job().position(), salary, list.get(i));
                e.newEmployment(ep);
                salary = salary + (0.50 * salary);
            }
            s.setEmploymenthistory(e);
            //}

        }

//        for(StudentProfile sp : d.getStudentDirectory().getStudentlist()) {
//        	System.out.println();
//        	
//			System.out.print("Employer Details for :"+sp.getPerson().getId()+" ");
//        	List<CourseOffer> courseOfferList = sp.getCourseLoadBySemester("Fall2015").getListOfCoursesForCourseLoad();
//        	for(CourseOffer co : courseOfferList) {
//        		System.out.print(co.getCourseName()+" ");
//        	}
//                System.out.println("GPA: "+sp.getGPA());
//        	System.out.println("Promotions: "+sp.getEmploymenthistory().getPromotions());
//        	
//        	for(Employment e:sp.getEmploymenthistory().getEmployments()) {
//        		System.out.println(e.getRelevantcourseoffers().get(0).getCourseNumber());
//        		System.out.println(e.getRelevantcourseoffers().get(1).getCourseNumber());
//        	}
//        	
//        }
//        System.out.println("Popular Courses in terms of seat full");
//       for(CourseOffer co:d.getPopuplarCourses("Fall2020")){
//           
//           System.out.println(co.getCourseName());
//       }
        //Top Courses Based on Salary 
//       List<StudentProfile> basedOnSalary = d.getStudentDirectory().getStudentlist();
//        Collections.sort(basedOnSalary, 
//               (o1,o2)->
//                       o2.getEmploymenthistory().getEmployments().get(o2.getEmploymenthistory().getEmployments().size()-1).getSalary() .compareTo 
//                               (o1.getEmploymenthistory().getEmployments().get(o1.getEmploymenthistory().getEmployments().size()-1).getSalary())
//       );
//       for(StudentProfile s:basedOnSalary){
//           System.out.print(s.getPerson().getName()+ "has ");
//           System.out.println("Salary:"+s.getEmploymenthistory().getEmployments().get(s.getEmploymenthistory().getEmployments().size()-1).getSalary());
//       }
//       //% of students more than average salary
//        List<CourseOffer> list = new ArrayList<>();
//       for(int i =0;i<=2;i++){
//           List<Employment> emp = basedOnSalary.get(i).getEmploymenthistory().getEmployments();
//          list.addAll(emp.get(emp.size()-1).getRelevantcourseoffers());
//       }
//      Set<String> namesList = list.stream()
//                                   .map(CourseOffer::getCourseName)
//                                   .collect(Collectors.toSet());
//        System.out.println("Popular Courses By Salary");
//      for(String s:d.getPopularCoursesBySalary()){
//          System.out.println(s);
//      }
//      System.out.println("Popular Courses By Promotion");
//      for(String s:d.getPopularCoursesByPromotion()){
//          System.out.println(s);
//      }
//      
//      System.out.println("Popular Courses By Ranking");
//      for(String s:d.getPopularCoursesByCompanyRanking()){
//          System.out.println(s);
//      }
//       
        d.getStudentDirectory().getStudentlist().sort((o1, o2) -> Integer.parseInt(o1.getPerson().getPersonId()) - Integer.parseInt(o2.getPerson().getPersonId()));
        return d;

    }

    public static void main(String args[]) throws IOException {
        DataGenerator dg = new DataGenerator();
        dg.generateDepartmentData();
    }
}
