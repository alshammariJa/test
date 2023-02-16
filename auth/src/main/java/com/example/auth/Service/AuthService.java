package com.example.auth.Service;

import com.example.auth.Model.MyUser;
import com.example.auth.Repository.AuthRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor

public class AuthService {

    private final AuthRepository authRepository;


    public void register(MyUser myUser) {
        myUser.setRole("USER");
        String hashedPassword = new BCryptPasswordEncoder().encode(myUser.getPassword());
        myUser.setPassword(hashedPassword);
        authRepository.save(myUser);
    }

    public List<MyUser> getAllUsers(){
        return authRepository.findAll();
    }

    public MyUser getUser(Integer id){
        MyUser myUser=authRepository.findMyUserById(id);

        return myUser;
    }


    public void addUser(MyUser newUser){
        newUser.setRole("USER");
        String hashedPassword=new BCryptPasswordEncoder().encode(newUser.getPassword());
        newUser.setPassword(hashedPassword);
        authRepository.save(newUser);
    }

    public void deleteUser(Integer id){
        MyUser myUser=authRepository.findMyUserById(id);

        authRepository.delete(myUser);
    }


    public void updateUser(MyUser newUser, Integer id){
        MyUser oldUser=authRepository.findMyUserById(id);

        newUser.setId(id);
        newUser.setRole(oldUser.getRole());
        newUser.setPassword(new BCryptPasswordEncoder().encode(newUser.getPassword()));

        authRepository.save(newUser);
    }
}
