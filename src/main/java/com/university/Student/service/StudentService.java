package com.university.Student.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;
import javax.naming.InvalidNameException;
import javax.validation.Validator;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.university.Student.dto.StudentDTO;
import com.university.Student.dto.StudentLoginDTO;

import com.university.Student.entity.Student;

import com.university.Student.repository.StudentRepository;


@Service
public class StudentService {
	private static final Logger logger = LoggerFactory.getLogger(StudentService.class);
	@Autowired
	StudentRepository studentrepo;
	
	
	
	public String registerstudent(StudentDTO studentDTO) throws Exception {
		
		 try{
		logger.info("Registration request for user {}", studentDTO);
		validateBuyer(studentDTO);
		
		Student be=studentDTO.createEntity();
		studentrepo.save(be);
		return("new user created");
		}catch(Exception e) {
			throw new Exception("Name is not valid");
		}
	}
	private void validateBuyer(StudentDTO studentDTO) throws Exception {

		logger.info("Buyer details are being validated");
		// TODO Auto-generated method stub
		if(!isAlreadyPhoneNumberExist(studentDTO.getMobileNumber()))
			throw new Exception("BuyerRegistration: Phone number already exists");
		if(!isAlreadyEmailIdExist(studentDTO.getEmailid()))
			throw new Exception("BuyerRegistration: Email already exists");
		if(!isValidEmail(studentDTO.getEmailid()))
			throw new Exception("BuyerRegistration: Invalid Email");
		if(!isValidPhoneNumber(studentDTO.getMobileNumber()))
			throw new Exception("BuyerRegistration:Invalid Phone number");
		if(!isvalidPassword(studentDTO.getPassword()))
			throw new Exception("BuyerRegistration: Invalid Password");
	
		
		
	}

	private boolean isAlreadyEmailIdExist(String email) {
		// TODO Auto-generated method stub
		Student student=studentrepo.findByemailId(email);
		if (student!=null)
			return false;
		return true;
	}

	private boolean isAlreadyPhoneNumberExist(String phoneNumber) {
		// TODO Auto-generated method stub
		Student student=studentrepo.findBymobileNumber(phoneNumber);
		if (student!=null)
			return false;
		return true;
	}

	private boolean isvalidPassword(String password) {
		return Pattern.matches("(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*]).{7,20}$",password);
	}

	private boolean isValidPhoneNumber(String phoneNumber) {
		// TODO Auto-generated method stub
	
		return Pattern.matches("^\\d{10}$", phoneNumber);
	}

	private boolean isValidEmail(String email) {
		// TODO Auto-generated method stub
		return Pattern.matches("^[A-Za-z0-9+_.-]+@(.+)$",email);
	}

	private boolean isValidName(String name) {
		// TODO Auto-generated method stub
		return Pattern.matches("^[a-zA-Z]+[-a-zA-Z\\s]+([-a-zA-Z]+)$", name);
	}

	
	

	public void studentLogin(StudentLoginDTO studentloginDTO) throws Exception {

		Student student = studentrepo.findByemailId(studentloginDTO.getEmail());
		if (student != null) {
			if (student.getPassword().equals(studentloginDTO.getPassword())) {
			
			} else {
				throw new Exception("BuyerLogin:Invalid Password");
			}
		}else {
			throw new Exception("buyerLogin:InvalidEmail");
		}
		
	}

	public void deactivateBuyer(StudentDTO studentDTO) throws Exception {

		Student student = studentrepo.findByemailId(studentDTO.getEmailid());
		if (student != null) {
			studentrepo.delete(student);
		} else {
			System.out.println("Invalid Email ID ");
		}

	}
	
	
	
	
	






}
