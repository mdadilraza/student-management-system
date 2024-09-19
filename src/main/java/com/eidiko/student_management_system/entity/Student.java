package com.eidiko.student_management_system.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "students")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id ;

    private String firstName ;

    private String lastName ;

    private String email ;

    private String password ;

}
