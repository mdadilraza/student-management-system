package com.eidiko.student_management_system.service;

import com.eidiko.student_management_system.dto.RegisterRequest;
import com.eidiko.student_management_system.dto.StudentDto;
import com.eidiko.student_management_system.entity.Student;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface StudentService {

    StudentDto createStudent(StudentDto studentDto );
    StudentDto findStudentById(long id);

    List<StudentDto> findAllStudent();

    StudentDto updateStudent( long id , StudentDto studentDto);

    StudentDto deleteStudent (long id);

     void registerStudent(RegisterRequest request);

     Student getStudentByEmail(String email);
}
