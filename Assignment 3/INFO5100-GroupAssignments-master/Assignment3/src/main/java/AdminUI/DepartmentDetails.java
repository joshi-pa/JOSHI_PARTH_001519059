/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AdminUI;

import info5100.university.example.CourseSchedule.CourseOffer;
import info5100.university.example.Department.Department;
import info5100.university.example.Persona.EmploymentHistory.Employment;
import info5100.university.example.Persona.StudentDirectory;
import info5100.university.example.Persona.StudentProfile;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author 12013
 */
public class DepartmentDetails extends javax.swing.JPanel {

    /**
     * Creates new form DepartmentDetails
     */
    StudentDirectory studentdata;
    Department department;
    StudentProfile sp;

    public DepartmentDetails(Department d) {
        initComponents();
        this.department = d;

        if (d != null) {
            populateTable(this.department.getStudentDirectory().getStudentlist());
        }
        lblcoursesfeedback.setVisible(false);
        lblcoursestaken.setVisible(false);
        feedbackCoursePane.setVisible(false);
        courseTakenScrollPane.setVisible(false);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitle = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblDepartment = new javax.swing.JTable();
        btnViewDetails = new javax.swing.JButton();
        lblcoursestaken = new javax.swing.JLabel();
        lblcoursesfeedback = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        feedbackCoursePane = new javax.swing.JScrollPane();
        txtFeedbackCourses = new javax.swing.JTextArea();
        courseTakenScrollPane = new javax.swing.JScrollPane();
        txtCoursesTaken = new javax.swing.JTextArea();

        lblTitle.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("View All Student Details");

        tblDepartment.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Student ID", "Student Name", "GPA", "Current Employer", "Current Salary", "Current Position"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblDepartment);

        btnViewDetails.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnViewDetails.setText("View Course details");
        btnViewDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewDetailsActionPerformed(evt);
            }
        });

        lblcoursestaken.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblcoursestaken.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lblcoursestaken.setText("Courses Taken :");

        lblcoursesfeedback.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblcoursesfeedback.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lblcoursesfeedback.setText("Feedback Courses :");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "By ID", "By Salary", "By GPA" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        txtFeedbackCourses.setEditable(false);
        txtFeedbackCourses.setColumns(20);
        txtFeedbackCourses.setRows(5);
        feedbackCoursePane.setViewportView(txtFeedbackCourses);

        txtCoursesTaken.setEditable(false);
        txtCoursesTaken.setColumns(20);
        txtCoursesTaken.setRows(5);
        courseTakenScrollPane.setViewportView(txtCoursesTaken);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 921, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnViewDetails)
                .addGap(38, 38, 38))
            .addGroup(layout.createSequentialGroup()
                .addGap(104, 104, 104)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblcoursestaken)
                    .addComponent(lblcoursesfeedback, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(feedbackCoursePane, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(courseTakenScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblcoursestaken, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18))
                            .addComponent(courseTakenScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(lblcoursesfeedback, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(feedbackCoursePane, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(40, 40, 40))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnViewDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(171, 171, 171))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnViewDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewDetailsActionPerformed
        int selectedRowIndex = tblDepartment.getSelectedRow();

        if (selectedRowIndex < 0) {
            JOptionPane.showMessageDialog(this, "Please select a row to View.");
            return;
        }

        DefaultTableModel model = (DefaultTableModel) tblDepartment.getModel();
        StudentProfile sp1 = (StudentProfile) model.getValueAt(selectedRowIndex, 0);

        lblcoursesfeedback.setVisible(true);
        lblcoursestaken.setVisible(true);
        feedbackCoursePane.setVisible(true);
        courseTakenScrollPane.setVisible(true);
        txtFeedbackCourses.setLineWrap(true);
        txtCoursesTaken.setLineWrap(true);
        List<String> courseList = sp1.getCoursesTaken().stream().map(CourseOffer::getCourseName).collect(Collectors.toList());
        txtCoursesTaken.setText(courseList.toString());
        List<CourseOffer> courseOfList = sp1.getEmploymenthistory().getEmployments().get(sp1.getEmploymenthistory().getEmployments().size() - 1).getRelevantcourseoffers();
        List<String> courseList1 = courseOfList.stream().map(CourseOffer::getCourseName).collect(Collectors.toList());
        txtFeedbackCourses.setText(courseList1.toString());

    }//GEN-LAST:event_btnViewDetailsActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
        ArrayList<StudentProfile> list = this.department.getStudentDirectory().getStudentlist();
        if (jComboBox1.getSelectedItem() == "By ID") {
            populateTable(this.department.sortByID(list));
        } else if (jComboBox1.getSelectedItem() == "By Salary") {

            populateTable(this.department.sortBySalary(list));
        } else if (jComboBox1.getSelectedItem() == "By GPA") {
            populateTable(this.department.sortByGPA(list));
        }
    }//GEN-LAST:event_jComboBox1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnViewDetails;
    private javax.swing.JScrollPane courseTakenScrollPane;
    private javax.swing.JScrollPane feedbackCoursePane;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblcoursesfeedback;
    private javax.swing.JLabel lblcoursestaken;
    private javax.swing.JTable tblDepartment;
    private javax.swing.JTextArea txtCoursesTaken;
    private javax.swing.JTextArea txtFeedbackCourses;
    // End of variables declaration//GEN-END:variables

    private void populateTable(List<StudentProfile> list) {
        DefaultTableModel model = (DefaultTableModel) tblDepartment.getModel();
        model.setRowCount(0);
        for (StudentProfile co : list) {

            Object[] row = new Object[6];
            row[0] = co;
            row[1] = co.getPerson().getName();
            row[2] = String.format("%.1f",co.getGPA());
            Employment emp = co.getEmploymenthistory().getEmployments().get(co.getEmploymenthistory().getEmployments().size() - 1);
            row[3] = emp.getEmployer().getName();
            row[4] = emp.getSalary();
            row[5] = emp.getPosition();
            model.addRow(row);
        }
    }
}
