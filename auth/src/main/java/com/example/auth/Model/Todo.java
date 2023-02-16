package com.example.auth.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Todo {
@Id
@GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private  String message;

    private Integer userId;
@ManyToOne
@JsonIgnore
@JoinColumn(name = "myUser_id" ,referencedColumnName  ="id")
    private MyUser myUser;


    public Todo(Integer id, String todo1, String body1, MyUser myUser) {
    }
}
