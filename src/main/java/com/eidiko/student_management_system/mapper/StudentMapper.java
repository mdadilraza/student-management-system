package com.eidiko.student_management_system.mapper;

import com.eidiko.student_management_system.dto.StudentDto;
import com.eidiko.student_management_system.entity.Student;
import org.springframework.stereotype.Component;

@Component
public class StudentMapper {
    public static StudentDto mapToStudentDto(Student student){
        return new StudentDto(
                student.getId(),
                student.getFirstName(),
                student.getLastName(),
                student.getEmail() ,
                student.getPassword()

        );
    }

    public static Student mapToStudent(StudentDto studentDto){
        return new Student(
                studentDto.getId(),
                studentDto.getFirstName(),
                studentDto.getLastName(),
                studentDto.getEmail() ,
                studentDto.getPassword()
        );
    }


}
