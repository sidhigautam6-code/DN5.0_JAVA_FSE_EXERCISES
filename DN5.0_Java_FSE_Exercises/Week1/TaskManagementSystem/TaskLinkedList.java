package Week1.TaskManagementSystem;
// src/TaskLinkedList.java
public class TaskLinkedList {
    private TaskNode head;
    private int size;
    
    public TaskLinkedList() {
        this.head = null;
        this.size = 0;
        System.out.println("Task Linked List initialized");
    }
    
    // Add task to beginning - O(1)
    public void addTaskToBeginning(Task task) {
        TaskNode newNode = new TaskNode(task);
        newNode.setNext(head);
        head = newNode;
        size++;
        System.out.println("Task added to beginning: " + task.getTaskName());
    }
    
    // Add task to end - O(n)
    public void addTaskToEnd(Task task) {
        TaskNode newNode = new TaskNode(task);
        
        if (head == null) {
            head = newNode;
        } else {
            TaskNode current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newNode);
        }
        size++;
        System.out.println("Task added to end: " + task.getTaskName());
    }
    
    // Add task at specific position - O(n)
    public void addTaskAtPosition(Task task, int position) {
        if (position < 0 || position > size) {
            System.out.println("Invalid position: " + position);
            return;
        }
        
        if (position == 0) {
            addTaskToBeginning(task);
            return;
        }
        
        TaskNode newNode = new TaskNode(task);
        TaskNode current = head;
        
        for (int i = 0; i < position - 1; i++) {
            current = current.getNext();
        }
        
        newNode.setNext(current.getNext());
        current.setNext(newNode);
        size++;
        System.out.println("Task added at position " + position + ": " + 
                          task.getTaskName());
    }
    
    // Search task by ID - O(n)
    public Task findTaskById(String taskId) {
        TaskNode current = head;
        int position = 0;
        
        while (current != null) {
            if (current.getData().getTaskId().equals(taskId)) {
                System.out.println("Task found at position " + position + 
                                  ": " + current.getData().getTaskName());
                return current.getData();
            }
            current = current.getNext();
            position++;
        }
        
        System.out.println("Task not found: " + taskId);
        return null;
    }
    
    // Search tasks by status - O(n)
    public Task[] findTasksByStatus(String status) {
        int count = 0;
        TaskNode current = head;
        
        // Count matches
        while (current != null) {
            if (current.getData().getStatus().equalsIgnoreCase(status)) {
                count++;
            }
            current = current.getNext();
        }
        
        // Collect matches
        Task[] matches = new Task[count];
        current = head;
        int index = 0;
        
        while (current != null) {
            if (current.getData().getStatus().equalsIgnoreCase(status)) {
                matches[index++] = current.getData();
            }
            current = current.getNext();
        }
        
        return matches;
    }
    
    // Delete task by ID - O(n)
    public void deleteTaskById(String taskId) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        
        // Handle deletion at head
        if (head.getData().getTaskId().equals(taskId)) {
            head = head.getNext();
            size--;
            System.out.println("Task deleted: " + taskId);
            return;
        }
        
        TaskNode current = head;
        while (current.getNext() != null) {
            if (current.getNext().getData().getTaskId().equals(taskId)) {
                current.setNext(current.getNext().getNext());
                size--;
                System.out.println("Task deleted: " + taskId);
                return;
            }
            current = current.getNext();
        }
        
        System.out.println("Task not found: " + taskId);
    }
    
    // Delete task at position - O(n)
    public void deleteTaskAtPosition(int position) {
        if (position < 0 || position >= size) {
            System.out.println("Invalid position: " + position);
            return;
        }
        
        if (position == 0) {
            head = head.getNext();
        } else {
            TaskNode current = head;
            for (int i = 0; i < position - 1; i++) {
                current = current.getNext();
            }
            current.setNext(current.getNext().getNext());
        }
        size--;
        System.out.println("Task deleted at position: " + position);
    }
    
    // Traverse all tasks - O(n)
    public void displayAllTasks() {
        if (head == null) {
            System.out.println("No tasks in the list");
            return;
        }
        
        System.out.println("\n=== TASK LIST ===");
        System.out.println("Total tasks: " + size);
        System.out.println("----------------");
        
        TaskNode current = head;
        int position = 0;
        
        while (current != null) {
            System.out.println((position + 1) + ". " + current.getData());
            current = current.getNext();
            position++;
        }
        System.out.println("================\n");
    }
    
    // Get tasks by priority - O(n)
    public Task[] getTasksByPriority(int minPriority) {
        int count = 0;
        TaskNode current = head;
        
        while (current != null) {
            if (current.getData().getPriority() >= minPriority) {
                count++;
            }
            current = current.getNext();
        }
        
        Task[] tasks = new Task[count];
        current = head;
        int index = 0;
        
        while (current != null) {
            if (current.getData().getPriority() >= minPriority) {
                tasks[index++] = current.getData();
            }
            current = current.getNext();
        }
        
        return tasks;
    }
    
    // Update task status - O(n)
    public void updateTaskStatus(String taskId, String newStatus) {
        TaskNode current = head;
        
        while (current != null) {
            if (current.getData().getTaskId().equals(taskId)) {
                current.getData().setStatus(newStatus);
                System.out.println("Task status updated: " + taskId + " -> " + newStatus);
                return;
            }
            current = current.getNext();
        }
        
        System.out.println("Task not found: " + taskId);
    }
    
    // Get size
    public int getSize() { return size; }
    public boolean isEmpty() { return size == 0; }
    
    // Clear all tasks
    public void clear() {
        head = null;
        size = 0;
        System.out.println("All tasks cleared");
    }
}
