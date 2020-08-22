package com.university.Student.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.university.Student.dto.StudentDTO;
import com.university.Student.entity.Student;

@Repository
@Transactional
public interface StudentRepository extends JpaRepository<Student, Integer> {

	public Student findBystudentId(int id);
	public Student findByemailId(String emailId);
	public Student findBymobileNumber(String mobileNumber);
	public void save(StudentDTO student);
}
