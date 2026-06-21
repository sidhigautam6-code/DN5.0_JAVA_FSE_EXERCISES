package Week1.TaskManagementSystem;
// src/TestTaskManagement.java
public class TestTaskManagement {
    public static void main(String[] args) {
        System.out.println("=== TASK MANAGEMENT SYSTEM ===\n");
        
        // Create task list
        TaskLinkedList taskList = new TaskLinkedList();
        
        // Add tasks
        System.out.println("\n--- Adding Tasks ---");
        taskList.addTaskToEnd(new Task("T001", "Design Database", "Pending", 
                                     3, "John", "2024-02-15"));
        taskList.addTaskToEnd(new Task("T002", "API Development", "In Progress", 
                                     5, "Jane", "2024-02-20"));
        taskList.addTaskToBeginning(new Task("T003", "Security Review", "Pending", 
                                           4, "Bob", "2024-02-10"));
        taskList.addTaskToEnd(new Task("T004", "Frontend Design", "Completed", 
                                     3, "Alice", "2024-02-05"));
        taskList.addTaskAtPosition(new Task("T005", "Testing", "Pending", 
                                         2, "Charlie", "2024-02-25"), 2);
        
        // Display all tasks
        taskList.displayAllTasks();
        
        // Search operations
        System.out.println("\n--- Search Operations ---");
        Task found = taskList.findTaskById("T002");
        if (found != null) {
            System.out.println("Found: " + found);
        }
        
        // Find by status
        Task[] pendingTasks = taskList.findTasksByStatus("Pending");
        System.out.println("\nPending Tasks (" + pendingTasks.length + "):");
        for (Task t : pendingTasks) {
            System.out.println("  " + t);
        }
        
        // Get high priority tasks
        Task[] highPriority = taskList.getTasksByPriority(4);
        System.out.println("\nHigh Priority Tasks (Priority >= 4):");
        for (Task t : highPriority) {
            System.out.println("  " + t);
        }
        
        // Update task
        System.out.println("\n--- Updating Task ---");
        taskList.updateTaskStatus("T001", "In Progress");
        
        // Delete task
        System.out.println("\n--- Deleting Task ---");
        taskList.deleteTaskById("T004");
        
        // Display final list
        taskList.displayAllTasks();
        
        // Performance statistics
        System.out.println("\n--- Statistics ---");
        System.out.println("Total tasks: " + taskList.getSize());
        System.out.println("Is empty? " + taskList.isEmpty());
    }
}
