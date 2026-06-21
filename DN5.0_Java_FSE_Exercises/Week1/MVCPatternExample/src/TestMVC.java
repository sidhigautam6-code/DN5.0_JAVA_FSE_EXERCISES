package Week1.MVCPatternExample.src;
// src/TestMVC.java
public class TestMVC {
    public static void main(String[] args) {
        // Create model
        Student student = new Student("John Doe", "S12345", "A");
        
        // Create view
        StudentView view = new StudentView();
        
        // Create controller
        StudentController controller = new StudentController(student, view);
        
        // Display initial student details
        System.out.println("Initial Student Details:");
        controller.displayStudent();
        
        // Update student details
        System.out.println("\nUpdating student details...");
        controller.updateStudentName("Jane Smith");
        controller.updateStudentGrade("A+");
        
        // Display updated details
        System.out.println("\nUpdated Student Details:");
        controller.displayStudent();
    }
}
