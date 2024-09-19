package com.eidiko.student_management_system.controller;

import com.eidiko.student_management_system.dto.StudentDto;
import com.eidiko.student_management_system.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("api/students")
public class StudentController {

    @Autowired
    private StudentService studentService;
    //BUILD ADD STUDENT REST API
    @PostMapping
    public ResponseEntity<?> createStudent(@RequestBody StudentDto studentDto){
      StudentDto savedStudentDto1 =  studentService.createStudent(studentDto);
      return new ResponseEntity<>(savedStudentDto1 , HttpStatus.CREATED);
    }
    //BUILD GET STUDENT REST API
    @GetMapping("/{id}")
    public ResponseEntity<?> getStudentById(@PathVariable("id") long id){
     StudentDto studentDto= studentService.findStudentById(id);
     return ResponseEntity.ok(studentDto);
    }
    //BUILD GET ALL STUDENT REST API
    @GetMapping("")
    public ResponseEntity<List<?>> getAllEmployees() {

        List<StudentDto>  allStudents  =studentService.findAllStudent();
        return   ResponseEntity.ok(allStudents);
    }
    @PutMapping("{id}")
    public ResponseEntity<?> updateStudent(@PathVariable long id, @RequestBody StudentDto studentDto) {

        StudentDto studentDto1 =  studentService.updateStudent(id ,studentDto);
        return   ResponseEntity.ok(studentDto1);
    }


    //BUILD DELETE STUDENT REST API

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable  long id) {

        StudentDto studentDto  = studentService.deleteStudent(id);

        return ResponseEntity.ok(studentDto);

    }
}
