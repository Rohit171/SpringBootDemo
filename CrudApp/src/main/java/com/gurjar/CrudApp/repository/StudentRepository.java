package com.gurjar.CrudApp.repository;

import com.gurjar.CrudApp.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Integer> {
}
