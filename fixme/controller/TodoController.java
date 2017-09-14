package com.kgfsl.fixme.controller;

import com.kgfsl.fixme.model.Todo;
import com.kgfsl.fixme.service.TodoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@CrossOrigin(origins = "http://127.0.0.1:5500", maxAge = 3600)
@RequestMapping("/todolist")
public class TodoController {
	@Autowired
	private TodoService todoService;

@RequestMapping(method = RequestMethod.POST)
	public void addTodo(@RequestBody Todo todo) {
		todoService.saveTodo(todo);		
	}
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deleteTodo(@PathVariable Long id) {
		todoService.delete(id);
	}

	@RequestMapping(method = RequestMethod.GET)
	public List<Todo> getTodos() {
		 return todoService.findAll();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Todo getTodo(@PathVariable int id) {
		Todo Todo = todoService.findOne(id);
		return Todo;
	}



	
}
