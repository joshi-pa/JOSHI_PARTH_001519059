/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info5100.university.example.CourseSchedule;

/**
 *
 * @author kal bugrara
 */
  public class SeatAssignment {
    
    Seat seat;
    CourseLoad courseload;
    float score;
    public SeatAssignment(CourseLoad cl, Seat s,float score){
        seat = s;
        courseload = cl;
        this.score = score;
    }
        public SeatAssignment(){

    }
         public SeatAssignment(Seat s){
             this.seat = s;
    }
    public void assignSeatToStudent(CourseLoad cl){
        courseload = cl;
    }

    public Seat getSeat() {
        return seat;
    }

    public CourseLoad getCourseload() {
        return courseload;
    }

    public float getScore() {
        return score;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }

    public void setCourseload(CourseLoad courseload) {
        this.courseload = courseload;
    }

    public void setScore(float score) {
        this.score = score;
    }
    
    
    
}
