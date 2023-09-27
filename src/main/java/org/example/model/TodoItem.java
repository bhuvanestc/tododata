package org.example.model;

import java.time.LocalDate;
import java.util.Objects;

public class TodoItem {
    private int todo_id;
    public String title;
    public String description;
    public LocalDate deadLine;
    public boolean done;
    public Person assignee_id;

    public int getTodo_id() {
        return todo_id;
    }

    public void setTodo_id(int todo_id) {
        this.todo_id = todo_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDeadLine() {
        return deadLine;
    }

    public void setDeadLine(LocalDate deadLine) {
        this.deadLine = deadLine;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public Person getAssignee_id() {
        return assignee_id;
    }

    public void setAssignee_id(Person assignee_id) {
        this.assignee_id = assignee_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TodoItem todoItem = (TodoItem) o;
        return todo_id == todoItem.todo_id && done == todoItem.done && Objects.equals(title, todoItem.title) && Objects.equals(description, todoItem.description) && Objects.equals(deadLine, todoItem.deadLine) && Objects.equals(assignee_id, todoItem.assignee_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(todo_id, title, description, deadLine, done, assignee_id);
    }

    public TodoItem(int todo_id, String title, String description, LocalDate deadLine, boolean done, Person assignee_id) {
        this.todo_id = todo_id;
        this.title = title;
        this.description = description;
        this.deadLine = deadLine;
        this.done = done;
        this.assignee_id = assignee_id;
    }
}
