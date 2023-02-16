package com.example.auth;

import com.example.auth.Model.MyUser;
import com.example.auth.Repository.AuthRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class authRepositoryTest {
@Autowired
AuthRepository authRepository;




    MyUser myUser;

    @BeforeEach
    void setUp() {
        myUser=new MyUser(null,"jamelah" , "12345" , "user" , null);
    }

    @Test
    public void findMyUserByUsername(){
        authRepository.save(myUser);
        MyUser myUser1 = authRepository.findMyUserByUsername(myUser.getUsername());
        Assertions.assertThat(myUser1).isEqualTo(myUser);
    }


}
