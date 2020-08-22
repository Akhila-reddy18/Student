package com.university.Student.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.university.Student.dto.FeeDTO;
import com.university.Student.dto.StudentDTO;
import com.university.Student.dto.StudentLoginDTO;

import com.university.Student.entity.Student;
import com.university.Student.repository.StudentRepository;
import com.university.Student.service.StudentService;



@RestController
@CrossOrigin
//@RequestMapping(value="/api")
public class StudentController {

	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	StudentService studentService;
	
	@Autowired
	StudentRepository studentRepo;
	

	@PostMapping(value="/student/register",  consumes = MediaType.APPLICATION_JSON_VALUE)
	public String registerUser(@RequestBody StudentDTO studentDTO) {
		try {
		logger.info("Registration request for student {}", studentDTO);
		
		studentService.registerstudent(studentDTO);
		return "Success";
	}catch(Exception e) {
		return("Already registered");
	}
	}

	@PostMapping(value = "/student/login",consumes = MediaType.APPLICATION_JSON_VALUE)
	public String loginBuyer(@RequestBody StudentLoginDTO studentloginDTO) throws Exception {
		try {
			studentService.studentLogin(studentloginDTO);
			return "Login Successfull";
		} catch (Exception e) {
			return " Login unsuccessfull, check your credentials and try again";
		}
	}


	@PostMapping(value = "/student/deactivate",consumes = MediaType.APPLICATION_JSON_VALUE)
	public String deactivateBuyer(@RequestBody StudentDTO studentDTO) throws Exception{
			try {
				studentService.deactivateBuyer(studentDTO);
			} catch (Exception e) {
				throw new Exception("Invalid Credentials");
			}
			return "Account Deactivated";
	
	}
	
	@GetMapping(value="/student/{studentid}/feedue")
	public FeeDTO viewPendingDue(@PathVariable Integer studentid){
//		Double due=0.0;
	
		FeeDTO feeDto=new RestTemplate().getForObject("http://localhost:7858/fees/"+studentid, FeeDTO.class) ;
//		due=feeDto.getPendingdue();
		return feeDto;
	}
	
	
	@PostMapping(value="/student/{studentid}/pay")
	public String payDue(Integer studentid) {
		String msg=null;
		msg=new RestTemplate().postForObject("http://localhost:7858/fees/"+studentid+"/pay", FeeDTO.class,String.class);
		return msg;
	}
}

