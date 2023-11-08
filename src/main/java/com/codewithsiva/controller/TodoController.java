package com.codewithsiva.controller;

import com.codewithsiva.model.Todo;
import com.codewithsiva.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class TodoController {
    @Autowired
    private TodoRepository todoRepository;

   @GetMapping("/todo/all")
    public List<Todo> getAllTodos(){
       return todoRepository.findAll();
   }
   @PostMapping("/todo")
    public List<Todo> addTodo(@RequestBody Todo todo){
       return todoRepository.insertTodo(todo);
   }
   @PostMapping("/updateTodo")
    public List<Todo> updateTodo(@RequestBody Todo todo){
       return  todoRepository.updateTodo(todo);
   }
   @PostMapping("/deleteTodo/{id}")
    public  List<Todo> deleteTodo(@PathVariable int id){
       return todoRepository.deleteTodo(id);
   }
}
