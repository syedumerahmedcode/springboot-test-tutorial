package com.umer.springboottesttutorial.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Student {

	private static final String STUDENT_SEQUENCE = "student_sequence";

	@Id
	@SequenceGenerator(name = STUDENT_SEQUENCE, sequenceName = STUDENT_SEQUENCE, allocationSize = 1)
	@GeneratedValue(generator = STUDENT_SEQUENCE, strategy = GenerationType.SEQUENCE)
	private Long id;

	@NotBlank
	@Column(nullable = false)
	private String name;

	@Email
	@Column(nullable = false, unique = true)
	private String email;

	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private Gender gender;

	public Student(String name, String email, Gender gender) {
		this.name = name;
		this.email = email;
		this.gender = gender;
	}
}
