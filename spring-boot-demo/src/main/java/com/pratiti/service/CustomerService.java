package com.pratiti.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pratiti.entity.Customer;
import com.pratiti.entity.Customer.Status;
import com.pratiti.exceptions.CustomerServiceException;
import com.pratiti.repo.AddressDao;
import com.pratiti.repo.CustomerDao;

@Service // this is same as @Component actually service is a type of component
public class CustomerService {

	@Autowired
	private CustomerDao customerRepository;

	@Autowired
	private AddressDao addressRepository;

	public int register(Customer customer) {
//		Optional<Customer> cust = customerRepository.findByEmail(customer.getEmail());
//		
//		if(cust==null) {
//			customerRepository.save(customer);
//		}
		if (!customerRepository.existsByEmail(customer.getEmail())) {
			customer.setStatus(Status.INACTIVE);
			customer.getAddress().setCustomer(customer);
			customerRepository.save(customer);
			// code to send email ---->
			// emailService.sendEmailOnRegistration(customer.getEmail());

			return customer.getId();
		} else
			throw new CustomerServiceException("Customer Already Exists");

	}

	public void activate(int id) {

		Optional<Customer> customer = customerRepository.findById(id);
		if (customer.isPresent()) {
			Customer customerData = customer.get();
			if (customerData.getStatus() != Status.LOCKED) {
				customerData.setStatus(Status.ACTIVE);
				customerRepository.save(customerData);
			} else {
				throw new CustomerServiceException("Account is locked, please contact admin");
			}
		} else {
			throw new CustomerServiceException("Customer doesn't exist");
		}

	}

	public Customer login(String email, String password) {
		Optional<Customer> customer = customerRepository.findByEmail(email);

		if (customer.isPresent()) {
			Customer customerData = customer.get();
			if (customerData.getPassword().equals(password)) {
				if (customerData.getStatus() == Status.ACTIVE) {
					return customerData;
				} else {
					throw new CustomerServiceException("Account is locked, please contact admin");
				}
			}else {
				throw new CustomerServiceException("Wrong Password");   //generally we give like invalid email or password
			}
		} else {
			throw new CustomerServiceException("Customer doesn't exist");
		}

	}
	public Customer allinfo(int id){
		Optional<Customer> customer = customerRepository.findById(id);
		Customer customerData = customer.get();
		return customerData;
	}

}
