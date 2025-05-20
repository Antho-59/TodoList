package org.example.service;

import org.example.model.Todo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TodoServiceImplV2 implements TodoService{


    private Map<Integer,Todo> todoMap = new HashMap<>(); // collection avec un hashmap
    private int nextId = 1;


    @Override
    public List<Todo> getAll() {
//        List<Todo> todoList = new ArrayList<>();
//        for (Todo t: todoMap.values()) {
//            todoList.add(t);
//        }
        return new ArrayList<>(todoMap.values());
    }

    @Override
    public Todo getById(int id) {
        return todoMap.get(id) ;
    }

    @Override
    public void add(String name, String description) {
        Todo todo = new Todo(nextId++,name,description);
        todoMap.put(todo.getId(),todo);
    }

    @Override
    public void update(int id, String name, String description, boolean done) {
        Todo todoToUpdate = todoMap.get(id);
        todoToUpdate.setName(name);
        todoToUpdate.setDescription(description);
        todoToUpdate.setDone(done);

    }

    @Override
    public void remove(int id) {
        todoMap.remove(id);

    }

    @Override
    public void toggleDone(int id) {
        Todo todoToToggle = getById(id);
//        todoToToggle.setDone();

    }
}
