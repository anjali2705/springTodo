package com.example.todos.com.example.todos.webServices;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class TodoController {
	
	@Autowired
	private TodoService todoservice;
	
	@GetMapping(path = "/hello-world")
	public TodoBean hello() {
	//	throw new RuntimeException("Some Error has happended! ");
	return new TodoBean("HelloWorld Anjali") ;
	}
	
	@GetMapping(path = "/hello-world/path-variable/{name}")
	public TodoBean helloWorld(@PathVariable String name) {
		return new TodoBean(String.format("Hello World, %s", name)) ;
	}
	
	
	//Todo Application RestApi's
	
	
	@GetMapping("/hello-world/{username}/todos")
	public List<TodoModel> getAll(@PathVariable String username){
		 return todoservice.findAll();
	}
	
	
	//retrieve Todo
	@GetMapping("/hello-world/{username}/todos/{id}")
	public TodoModel getTodo(@PathVariable String username,  @PathVariable long id){
		 return todoservice.findById(id);
	}
	
	//Update Todo
	
	@PutMapping("/hello-world/{username}/todos/{id}")
	public ResponseEntity<TodoModel> updateTodo(@PathVariable String username,
			   @PathVariable long id, @RequestBody TodoModel todo) {
		TodoModel todoObj = todoservice.save(todo);
		return new ResponseEntity<TodoModel>(todo, HttpStatus.OK);
	       
	}
	
	//Save Todo
	
	//Update Todo
	
		@PostMapping("/hello-world/{username}/todos/")
		public ResponseEntity<Void> updateTodo(@PathVariable String username,@RequestBody TodoModel todo) {
			TodoModel createdTodo = todoservice.save(todo);
			URI uri = ServletUriComponentsBuilder.fromCurrentRequest().
					path("/{id}").buildAndExpand(createdTodo.getId()).toUri();
			return ResponseEntity.created(uri).build();
		       
		}
		
		
	
	
	//Delete Todo 
	@DeleteMapping("/hello-world/{username}/todos/{id}")
	public ResponseEntity<Void> deleteTodo(@PathVariable String username,
			   @PathVariable long id) {
		TodoModel todo = todoservice.deleteById(id);
		if(todo!= null) {
			return ResponseEntity.noContent().build();
		}
		else
			return ResponseEntity.notFound().build();
	}
	
}
