package org.example.service;

import org.example.model.Todo;

import java.util.ArrayList;
import java.util.List;

public class TodoServiceImpl implements TodoService{

private List<Todo> todoList = new ArrayList<>();

    @Override
    public List<Todo> getAll() {

        return new ArrayList<>(todoList);
    }

    @Override
    public Todo getById(int id) {
    for (Todo todo: todoList){
        if (todo.getId() == id){
            return todo;
        }
    }
        return null;
    }

    @Override
    public void add(String name, String description) {
    }

    @Override
    public void update(int id, String name, String description, boolean done) {

    }

    @Override
    public void remove(int id) {
    todoList.remove(id);
    }

    @Override
    public void toggleDone(int id) {

    }
}
