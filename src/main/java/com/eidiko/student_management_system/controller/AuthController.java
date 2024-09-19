package com.eidiko.student_management_system.controller;
import com.eidiko.student_management_system.dto.JwtResponse;
import com.eidiko.student_management_system.dto.LoginRequest;
import com.eidiko.student_management_system.dto.RegisterRequest;
import com.eidiko.student_management_system.repository.StudentRepository;
import com.eidiko.student_management_system.security.JwtGenerator;
import com.eidiko.student_management_system.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    UserDetailsService userDetailsService;
    @Autowired
    private StudentService studentService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtGenerator jwtGenerator;

    @PostMapping("/register")
    public ResponseEntity<?> registerStudent(@RequestBody RegisterRequest registerRequest) {
        studentService.registerStudent(registerRequest);
        return ResponseEntity.ok("Student registered successfully!");
    }


    @PostMapping("/login")
    public ResponseEntity<JwtResponse> login(@RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtGenerator.generateToken(authentication);
        return new ResponseEntity<>(new JwtResponse(token), HttpStatus.OK);
    }
}