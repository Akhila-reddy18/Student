package com.university.Student.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.university.Student.entity.Address;
import com.university.Student.entity.Student;

public interface AddressRepository extends JpaRepository<Address, Integer> {

}
