package com.eidiko.student_management_system.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class RegisterRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
}
