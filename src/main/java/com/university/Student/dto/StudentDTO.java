package com.university.Student.dto;

import com.university.Student.entity.Address;
import com.university.Student.entity.Student;

public class StudentDTO {
	Integer studentId;
	String name;
	String emailid;
	String mobileNumber;
	String password;
	AddressDTO address;
	
	public AddressDTO getAddress() {
		return address;
	}
	public void setAddress(AddressDTO address) {
		this.address = address;
	}
	public Integer getStudentId() {
		return studentId;
	}
	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public StudentDTO() {
		super();
	}
	// Converts Entity into DTO
	public static StudentDTO valueOf(Student student) {
		
		StudentDTO studentDTO= new StudentDTO();
		studentDTO.setStudentId(student.getStudentId());
		studentDTO.setEmailid(student.getEmailId());
		studentDTO.setName(student.getName());
		studentDTO.setPassword(student.getPassword());
		AddressDTO addressDTO=new AddressDTO();
		addressDTO.setAddressId(student.getAddress().getAddressId());
		addressDTO.setCity(student.getAddress().getCity());
		addressDTO.setDistrict(student.getAddress().getCity());
		addressDTO.setHouse(student.getAddress().getHouse());
		addressDTO.setStreet(student.getAddress().getStreet());
		//addressDTO.setAddressId(student.getAddress());
		//studentDTO.getAddress().setAddressId(student.getAddress());
		studentDTO.setAddress(addressDTO);
		
		return studentDTO;
	}
	
	public Student createEntity() {
		Student student=new Student();
		Address address=new Address();
		address.setAddressId(this.getAddress().getAddressId());
		address.setCity(this.getAddress().getCity());
		address.setDistrict(this.getAddress().getDistrict());
		address.setHouse(this.getAddress().getStreet());
		address.setStreet(this.getAddress().getStreet());
		student.setAddress(address);
		
		
		
		//student.setAddress(this.getAddress().getAddressId());
		student.setEmailId(this.getEmailid());
		student.setMobileNumber(this.getMobileNumber());
		student.setName(this.getName());
		student.setPassword(this.getPassword());
		student.setStudentId(this.getStudentId());
		
		return student;
	}
		
	
	
}
