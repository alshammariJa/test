package com.example.auth.Service;

import com.example.auth.Model.Todo;
import com.example.auth.Repository.TodoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TodoService {
    private final TodoRepository todoRepository;




    public List<Todo> getTodos(Integer id) {
        return todoRepository.findAll();
    }
    public void addTodo(Integer id,Todo todo) {
        todo.setUserId(id);
        todoRepository.save(todo);
    }

    public void removeTodo(Integer userId, Integer todoId) {
        Todo todo=todoRepository.findById(todoId).get();

        if(todo.getUserId()!=userId){
            return;
        }

        todoRepository.deleteById(todoId);
    }
}
