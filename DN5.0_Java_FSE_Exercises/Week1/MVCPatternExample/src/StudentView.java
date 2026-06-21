package Week1.MVCPatternExample.src;
// src/StudentView.java
public class StudentView {
    public void displayStudentDetails(Student student) {
        System.out.println("==========================");
        System.out.println("Student Details:");
        System.out.println("Name: " + student.getName());
        System.out.println("ID: " + student.getId());
        System.out.println("Grade: " + student.getGrade());
        System.out.println("==========================");
    }
}
