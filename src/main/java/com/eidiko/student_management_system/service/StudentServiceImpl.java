package com.eidiko.student_management_system.service;

import com.eidiko.student_management_system.dto.StudentDto;
import com.eidiko.student_management_system.entity.Student;
import com.eidiko.student_management_system.exception.ResourceNotFoundException;
import com.eidiko.student_management_system.mapper.StudentMapper;
import com.eidiko.student_management_system.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{
  @Autowired
  private StudentRepository studentRepository;

    @Override
    public StudentDto createStudent(StudentDto studentDto) {
       Student student=  studentRepository.save(StudentMapper.mapToStudent(studentDto));
        return StudentMapper.mapToStudentDto(student);
    }

    @Override
    public StudentDto findStudentById(long id) {
    Student student=    studentRepository.findById(id).
                orElseThrow(()->new ResourceNotFoundException("Student is not Exist with The given "+id));
        return StudentMapper.mapToStudentDto(student);
    }

    @Override
    public List<StudentDto> findAllStudent() {
      List<Student> studentList =  studentRepository.findAll();

         return studentList
                .stream()
                .map(StudentMapper::mapToStudentDto)
                .toList();
    }

    @Override
    public StudentDto updateStudent(long id, StudentDto studentDto) {

      StudentDto student=  findStudentById(id);
      student.setId(studentDto.getId());
      student.setFirstName(studentDto.getFirstName());
      student.setLastName(studentDto.getLastName());
      student.setEmail(studentDto.getEmail());
      student.setPassword(studentDto.getPassword());
        return student;
    }

    @Override
    public StudentDto deleteStudent(long id) {
      StudentDto studentDto =  findStudentById(id);

      studentRepository.delete(StudentMapper.mapToStudent(studentDto));
        return studentDto;
    }
}
