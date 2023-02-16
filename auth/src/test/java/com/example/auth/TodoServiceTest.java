package com.example.auth;

import com.example.auth.Model.MyUser;
import com.example.auth.Model.Todo;
import com.example.auth.Repository.AuthRepository;
import com.example.auth.Repository.TodoRepository;
import com.example.auth.Service.TodoService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.OngoingStubbing;

import java.util.ArrayList;
import java.util.List;

import static jdk.internal.org.objectweb.asm.util.CheckClassAdapter.verify;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TodoServiceTest {

    @InjectMocks
    TodoService todoService;

    @Mock
    TodoRepository todoRepository;
    @Mock
    AuthRepository authRepository;

    MyUser myUser;

    Todo todo1, todo2, todo3;

    List<Todo> todos;

    @BeforeEach
    void setUp() {
        myUser = new MyUser(null, "jamelah", "12345", "ADMIN", null);
        todo1 = new Todo(null, "todo1", "body1", myUser);
        todo2 = new Todo(null, "todo2", "body2", myUser);


        todos = new ArrayList<>();
        todos.add(todo1);
        todos.add(todo2);

    }
    @Test
    public void getAllTodoTest(){
        When(todoRepository.findAll()).thenReturn(todos);
        List<Todo> todoList = todoService.getTodos(todo1.getUserId());
        Assertions.assertEquals(3,todoList.size());
        verify(todoRepository,times(1)).findAll();
    }



    @Test
    public void getAllTodoByIdTest(){
        when(authRepository.findMyUserById(myUser.getId())).thenReturn(myUser);
        when(todoRepository.findAllByMyUser(myUser)).thenReturn(todos);
        List<Todo> todoList = todoService.getTodos(myUser.getId());
        Assertions.assertEquals(todoList,todos);
        verify(authRepository,times(1)).findMyUserById(myUser.getId());
        verify(todoRepository,times(1)).findAllByMyUser(myUser);
    }

    @Test
    public void addTodoTest(){
        when(authRepository.findMyUserById(myUser.getId())).thenReturn(myUser);

        todoService.addTodo(todo1,myUser.getId());
        verify(todoRepository,times(1)).save(todo1);
    }


    @Test
    public void removeTest(){
        // user
        when(authRepository.findMyUserById(myUser.getId())).thenReturn(myUser);
        //TO do
        when(todoRepository.findTodoById(todo1.getId())).thenReturn(todo1);

        todoService.removeTodo(todo1.getId(),myUser.getId());

        verify(authRepository,times(1)).findMyUserById(myUser.getId());
        verify(todoRepository,times(1)).findTodoById(todo1.getId());
        verify(todoRepository,times(1)).delete(todo1);

    }
}
