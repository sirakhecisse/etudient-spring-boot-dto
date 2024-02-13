package com.devoir.devoir.dtoImpl;


import com.devoir.devoir.dto.StudentDto;
import com.devoir.devoir.entities.Student;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class StudentDtoImpl {


    public StudentDto fromStudent(Student student){
        StudentDto studentDto=new StudentDto();
        BeanUtils.copyProperties(student,studentDto);
        return  studentDto;
    }

    public Student fromStudentDTO(StudentDto studentDto){
        Student student=new Student();
        BeanUtils.copyProperties(studentDto,student);
        return  student;
    }
}
