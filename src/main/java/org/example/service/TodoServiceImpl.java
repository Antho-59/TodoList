package org.example.service;

import org.example.model.Todo;

import java.util.ArrayList;
import java.util.List;

public class TodoServiceImpl implements TodoService{

private List<Todo> todoList = new ArrayList<>();
private int cptId = 1 ;



    @Override
    public List<Todo> getAll() {

        return todoList;    // il veut qu'on lui renvoie tout , on renvoie la todoList qu'on vient de creer
    }

    @Override
    public Todo getById(int id) {
        Todo todoSearch = null;
        for (Todo t : todoList)  // parcour l'ensemnle des Todoo de todoList pour stocker dans la var t
            if (t.getId() == id) {
                todoSearch = t;
            }
        return todoSearch;
    }// permet de retourner notre recherche


    @Override
    public void add(String name, String description) {
        Todo newTodo = new Todo(cptId++,name,description);
        todoList.add(newTodo);
    }

    @Override
    public void update(int id, String name, String description, boolean done) {
        Todo todoToUpdate = getById(id); // utilise la methode du dessus pour aller chercher celui avec l'id que je veux

        todoToUpdate.setName(name); // on utilise le setter sur la todoo qu'on a trouver avec l'Id pour la modif
        todoToUpdate.setDescription(description);
        todoToUpdate.setDone(done);
    }

    @Override
    public void remove(int id) {
    todoList.remove(getById(id));  // .remove + getter pour aller cherche la bonne todoo

    }

    @Override
    public void toggleDone(int id) {
       Todo todoToToggle = getById(id); // on recup la todoo a toggle

        if (!todoToToggle.isDone()) { // is -> equivalant du get sur les Bool
            // le ! veut dire si le todoToToglle n',est pas (true)
            todoToToggle.setDone(true);
        }else {
            todoToToggle.setDone(false);
        }

        // v2
      // getById(id).setDone(!getById(id).isDone());

    }
}
