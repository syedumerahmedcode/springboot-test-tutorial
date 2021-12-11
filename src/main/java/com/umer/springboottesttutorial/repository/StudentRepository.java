package com.umer.springboottesttutorial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.umer.springboottesttutorial.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

}
