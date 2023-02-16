package com.example.auth;

import com.example.auth.Model.MyUser;
import com.example.auth.Repository.AuthRepository;
import com.example.auth.Service.AuthService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static jdk.internal.org.objectweb.asm.util.CheckClassAdapter.verify;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AuthServiceTest {
    @InjectMocks

    AuthService authService;
    @Mock
    AuthRepository authRepository;


    MyUser  myUser1,myUser2;
    List<MyUser> myUsers;

    @BeforeEach
    void setUp() {

        myUser1 = new MyUser(null, "jamela", "123", "ADMIN", null);
        myUser2 = new MyUser(null, "sara", "1234", "USER", null);


        myUsers = new ArrayList<>();
        myUsers.add(myUser1);
        myUsers.add(myUser2);

    }

    @Test
    public void getAllUsers(){
        when(authRepository.findAll()).thenReturn(myUsers);
        List<MyUser> userList = authService.getAllUsers();
        Assertions.assertEquals(3,userList.size());
        verify(authRepository,times(1)).findAll();
    }

    @Test
    public void UserById(){
        when(authRepository.findMyUserById(myUser1.getId())).thenReturn(myUser1);
        MyUser user = authService.getUser(myUser1.getId());
        Assertions.assertEquals(user,myUser1);
        verify(authRepository,times(1)).findMyUserById(myUser1.getId());
    }

    @Test
    public void updateUser(){
        when(authService.register(MyUser.getId());).thenReturn(myUser1);
        authService.updateUser(myUser2,myUser1.getId());

        verify(authRepository,times(1)).findMyUserById(myUser1.getId());
        verify(authRepository,times(1)).save(myUser2);
    }



    @Test
    public void removeTest(){

        when(authRepository.findMyUserById(myUser1.getId())).thenReturn(myUser1);


    }


}
