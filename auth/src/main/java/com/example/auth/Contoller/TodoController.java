package com.example.auth.Contoller;

import com.example.auth.Model.MyUser;
import com.example.auth.Model.Todo;
import com.example.auth.Service.TodoService;
import lombok.AllArgsConstructor;
import org.apache.catalina.connector.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/todo")
public class TodoController {

    private TodoService todoService;


    @GetMapping()
    public ResponseEntity <List<Todo>> getTodos(@AuthenticationPrincipal MyUser myUser){
        return ResponseEntity.status(200).body(todoService.getTodos(myUser.getId()));
    }

    @PostMapping()
    public ResponseEntity <Response> addTodos(@AuthenticationPrincipal MyUser myUser, @RequestBody Todo todo){
        todoService.addTodo(myUser.getId(),todo);
        return ResponseEntity.status(201).body(new Response());
    }

    @DeleteMapping("/{todoId}")
    public ResponseEntity <Response> removeTodos(@AuthenticationPrincipal MyUser myUser, @PathVariable Integer todoId){
        todoService.removeTodo(myUser.getId(),todoId);
        return ResponseEntity.status(200).body(new Response());
    }}
