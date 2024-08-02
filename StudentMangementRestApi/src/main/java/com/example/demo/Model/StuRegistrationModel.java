package com.example.demo.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class StuRegistrationModel {
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
			private int id;
			private String student_id;
			private String first_name;
			private String last_name;
			private String email;
			private long phone_number;
			private String date_of_birth;
			private String address;
			private String password;
			private String department;
			private int year_of_study;
			private String enrollment_date;
	}
