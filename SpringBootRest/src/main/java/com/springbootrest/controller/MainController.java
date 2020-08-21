package com.springbootrest.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springbootrest.dao.CustomerRepository;
import com.springbootrest.model.Customer;


@RestController
public class MainController {
	
	@Autowired
	CustomerRepository customerRepository;
		
	@RequestMapping("/savedefault")
	public String saveCustomers(){
		
		Customer customer1 = new Customer();
		customer1.setName("Bruce");
		customer1.setAddress("London");
		customer1.setPhoneNumber(745896);
		customer1.setEmail("bruce@test.com");
		
		Customer customer2 = new Customer();
		customer2.setName("Braxton");
		customer2.setAddress("Ukraine");
		customer2.setPhoneNumber(8564721);
		customer2.setEmail("brax@test.com");
		
		Customer customer3 = new Customer();
		customer3.setName("Joe");
		customer3.setAddress("Italy");
		customer3.setPhoneNumber(36598574);
		customer3.setEmail("joe@test.com");
		
		customerRepository.save(customer1);
		customerRepository.save(customer2);
		customerRepository.save(customer3);
		
		return "Default Customers Added";
	}
	
	@GetMapping("/display")
	public List <Customer> fetchAllCustomers(){
		List <Customer> customerList = new ArrayList<Customer>();
		
		customerList = customerRepository.findAll();
		
		return customerList;
	}
	
	@GetMapping("/display/{id}")
	public Optional<Customer> fetchCustomerById( @PathVariable("id") long id){
		Optional<Customer> customer = Optional.of(new Customer());
		
		customer = customerRepository.findById(id);
		
		return customer;
	}
	
	@PostMapping("/save")
	public String saveNewCustomer(@RequestBody Customer apiCustomer) {
		Customer customer = new Customer();
		customer = customerRepository.save(apiCustomer);
		return "Customer Added";
	}
	
	@PutMapping("/update")
	public String updateCustomer(@RequestBody Customer apiCustomer) {
		Customer customer = new Customer();
		customer = customerRepository.save(apiCustomer);
		return "Customer Updated";
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteById( @PathVariable("id") long id){
		Customer customer = new Customer();
		
		customer = customerRepository.getOne(id);
		customerRepository.delete(customer);
		
		return "Customer Deleted";
	}

}











