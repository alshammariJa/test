package com.example.auth.Repository;

import com.example.auth.Model.MyUser;
import com.example.auth.Model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TodoRepository extends JpaRepository<Todo, Integer> {
    List<Todo> findAllByUserId(Integer userId);
    Todo findTodoById(Integer id);

    List<Todo> findAllByMyUser(MyUser myUser);
}
