package Week1.TaskManagementSystem;
// src/Task.java
public class Task {
    private String taskId;
    private String taskName;
    private String status;
    private int priority;
    private String assignedTo;
    private String dueDate;
    
    public Task(String taskId, String taskName, String status, 
                int priority, String assignedTo, String dueDate) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.status = status;
        this.priority = priority;
        this.assignedTo = assignedTo;
        this.dueDate = dueDate;
    }
    
    // Getters and Setters
    public String getTaskId() { return taskId; }
    public String getTaskName() { return taskName; }
    public String getStatus() { return status; }
    public int getPriority() { return priority; }
    public String getAssignedTo() { return assignedTo; }
    public String getDueDate() { return dueDate; }
    
    public void setStatus(String status) { this.status = status; }
    public void setPriority(int priority) { this.priority = priority; }
    public void setAssignedTo(String assignedTo) { this.assignedTo = assignedTo; }
    public void setDueDate(String dueDate) { this.dueDate = dueDate; }
    
    @Override
    public String toString() {
        return String.format("Task[ID: %s, Name: %s, Status: %s, Priority: %d, " +
                           "Assigned: %s, Due: %s]",
                           taskId, taskName, status, priority, assignedTo, dueDate);
    }
}
