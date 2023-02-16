package com.example.auth.Repository;

import com.example.auth.Model.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthRepository extends JpaRepository <MyUser,Integer> {
    MyUser findMyUserById(Integer id);
    MyUser findMyUserByUsername(String username);

}

