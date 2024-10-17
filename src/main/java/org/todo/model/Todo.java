package org.todo.model;
public class Todo<List> {
    private Long id;
    private String description;
    private boolean isCompleted;

    public Todo(Long id, String description) {
        this.id = id;
        this.description = description;
        this.isCompleted = false;
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }
}