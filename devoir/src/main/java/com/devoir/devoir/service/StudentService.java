package com.devoir.devoir.service;

import com.devoir.devoir.dto.StudentDto;
import com.devoir.devoir.dtoImpl.StudentDtoImpl;
import com.devoir.devoir.entities.Student;
import com.devoir.devoir.repository.StudentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StudentDtoImpl studentDtoImpl;


    public List<StudentDto> getAllStudents() {

        List<Student> students = studentRepository.findAll();
        List<StudentDto> studentDtos = students.stream()
                .map(student -> studentDtoImpl.fromStudent(student))
                .collect(Collectors.toList());
        return studentDtos;
    }


    public StudentDto saveStudent(StudentDto studentDto) {
        log.info("Saving new Customer");
        Student student=studentDtoImpl.fromStudentDTO(studentDto);
        Student savedStudent = studentRepository.save(student);
        return studentDtoImpl.fromStudent(savedStudent);
    }

    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}

