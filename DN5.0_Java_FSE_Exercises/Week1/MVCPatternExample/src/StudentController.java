package Week1.MVCPatternExample.src;
// src/StudentController.java
public class StudentController {
    private Student model;
    private StudentView view;
    
    public StudentController(Student model, StudentView view) {
        this.model = model;
        this.view = view;
    }
    
    public void updateStudentName(String name) {
        model.setName(name);
    }
    
    public void updateStudentId(String id) {
        model.setId(id);
    }
    
    public void updateStudentGrade(String grade) {
        model.setGrade(grade);
    }
    
    public void displayStudent() {
        view.displayStudentDetails(model);
    }
}
