package dao;

import dao.TodoItems;
import org.example.model.Person;
import org.example.model.Todo;
import org.example.model.Mysqlconnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class TodoItemsDAO implements TodoItems{


    @Override
    public Todo create(Todo todo) {
        return null;
    }

    @Override
    public Collection<Todo> findAll() {
        return null;
    }

    @Override
    public Todo findById(int id) {
        return null;
    }

    @Override
    public Collection<Todo> findByAssignee(int id) {
        return null;
    }

    @Override
    public Collection<Todo> findByAssignee(Person person) {
        return null;
    }

    @Override
    public Collection<Todo> findByUnassignedTodoItems() {
        return null;
    }

    @Override
    public Todo update(Todo todo) {
        return null;
    }

    @Override
    public boolean deleteById(int id) {
        return false;
    }
}
