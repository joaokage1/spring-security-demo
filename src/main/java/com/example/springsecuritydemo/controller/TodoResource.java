package com.example.springsecuritydemo.controller;

import com.example.springsecuritydemo.model.Todo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TodoResource {

    private final Logger LOGGER = LoggerFactory.getLogger(getClass());

    private static final List<Todo> todoList = List.of(
            new Todo("jogomes","Terminar curso spring"),
            new Todo("jaqueline","Jogar Hogwarts Legacy"),
            new Todo("jogomes","Terminar TLOU 2")
    );

    @GetMapping("/todos")
    public List<Todo> findAllTodos(){
        return todoList;
    }

    @GetMapping("/todos/{username}")
    public List<Todo> findTodosForSpecificName(@PathVariable String username){
        return todoList.stream().filter(todo -> todo.username().equals(username)).toList();
    }

    @PostMapping("/todos")
    public void insertTodo(@RequestBody Todo todo){
        LOGGER.info("Adding todo: {}", todo);
    }
}
