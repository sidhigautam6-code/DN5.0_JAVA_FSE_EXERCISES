package Week1.TaskManagementSystem;
// src/TaskNode.java
public class TaskNode {
    private Task data;
    private TaskNode next;
    
    public TaskNode(Task data) {
        this.data = data;
        this.next = null;
    }
    
    public Task getData() { return data; }
    public TaskNode getNext() { return next; }
    public void setNext(TaskNode next) { this.next = next; }
}
