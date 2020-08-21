package com.springbootrest.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springbootrest.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
