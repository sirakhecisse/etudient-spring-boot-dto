package com.devoir.devoir.repository;

import com.devoir.devoir.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Long>{
}
