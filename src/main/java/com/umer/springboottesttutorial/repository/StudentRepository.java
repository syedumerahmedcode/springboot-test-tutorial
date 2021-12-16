package com.umer.springboottesttutorial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.umer.springboottesttutorial.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
	
	@Query(
			"SELECT CASE "
					+ "WHEN COUNT(s) > 0 "
					+ "THEN TRUE "
					+ "ELSE FALSE "
					+ "END "
			+ "FROM Student s "
			+ "WHERE s.email = ?1"
			)
	Boolean selectExistsEmail(String email);
	
	Student findByEmail(String email);

}
