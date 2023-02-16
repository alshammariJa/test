package com.example.auth.Contoller;

import com.example.auth.Model.MyUser;
import com.example.auth.Service.AuthService;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.connector.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;


    @PostMapping("/register")
    public ResponseEntity<Response> register(@RequestBody MyUser myUser){
        authService.register(myUser);
        return ResponseEntity.status(HttpStatus.CREATED).body(new Response());
    }

    @PostMapping("/admin")
    public ResponseEntity<Response> admin(){
        return ResponseEntity.status(HttpStatus.OK).body(new Response());
    }

    @PostMapping("/user")
    public ResponseEntity<Response> user(){
        return ResponseEntity.status(HttpStatus.OK).body(new Response());
    }


//    @PostMapping("/login")
//    public ResponseEntity<Response> login() {

    }
