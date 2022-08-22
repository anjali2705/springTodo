package com.example.todos.com.example.todos.webServices;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TodoService {
    private static List<TodoModel> todos = new ArrayList();
    private static int counterId = 0;
    
    static { 
    	todos.add(new TodoModel(++counterId, "Learn To Dance", null, new Date(), false));
    	todos.add(new TodoModel(++counterId, "Learn To Sing", null, new Date(), false));
    	todos.add(new TodoModel(++counterId, "Learn To Write", null, new Date(), false));
    }
    
    public List<TodoModel> findAll(){
    	return todos;
    }
    
    public TodoModel save(TodoModel todo) {
    	if(todo.getId() == -1) {
    		todo.setId(++counterId);
    		todos.add(todo);
    	}
    	else {
    	    deleteById(todo.getId());
    		todos.add(todo);
    	}
    	return todo;
    }
    
    public TodoModel deleteById(long id) {
    	TodoModel todo = findById(id);
    	if(todo == null) return null;
    	if(todos.remove(todo))
    	   return todo;
    	
    	return null;
    }

	public TodoModel findById(long id) {
		for(TodoModel todo:todos) {
			if(todo.getId() == id) {
				return todo;
			}
		}
		return null;
	}
}
