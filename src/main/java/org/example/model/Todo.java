package org.example.model;

import java.time.LocalDate;
import java.util.Objects;

public class Todo {
    private int id;
    public String title;
    public String description;
    public LocalDate deadLine;
    public boolean done;
    public Person assignee_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        Todo todo = (Todo) o;
        return id == todo.id && done == todo.done && Objects.equals(title, todo.title) && Objects.equals(description, todo.description) && Objects.equals(deadLine, todo.deadLine) && Objects.equals(assignee_id, todo.assignee_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, deadLine, done, assignee_id);
    }

    @Override
    public String toString() {
        return "Todo{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", deadLine=" + deadLine +
                ", done=" + done +
                ", assignee_id=" + assignee_id +
                '}';
    }
}