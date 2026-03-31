package com.klef.fsad.sdp.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.fsad.sdp.dto.CustomerDTO;
import com.klef.fsad.sdp.entity.Admin;
import com.klef.fsad.sdp.entity.Customer;
import com.klef.fsad.sdp.entity.ServiceManager;
import com.klef.fsad.sdp.repository.AdminRepository;
import com.klef.fsad.sdp.repository.CustomerRepository;
import com.klef.fsad.sdp.repository.ManagerRepository;

@Service
public class AdminServiceImpl implements AdminService
{
	@Autowired
	private AdminRepository adminRepository;

	@Autowired
	private ManagerRepository managerRepository;

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public Admin verifyAdminlogin(String username, String password) 
	{
		return adminRepository.findByUsernameAndPassword(username, password);
	}

	@Override
	public String addServiceManager(ServiceManager sm) 
	{
		managerRepository.save(sm);
		return "Manager added successfully!";
	}

	@Override
	public List<ServiceManager> viewallServiceManagers() 
	{
		return managerRepository.findAll();
	}

	@Override
	public List<Customer> viewallCustomers() 
	{
		return customerRepository.findAll();
	}

	@Override
	public boolean deleteServiceManagerString(int id)
	{  //findById 
		if(managerRepository.existsById(id))   //if it is there then it will run the if loop
		{
			managerRepository.deleteById(id);
			return true;
		}
		else 
		{
			return false;
		}
	}

	@Override
	public CustomerDTO CustomerToCustomerDTO(Customer c) 
	{
		CustomerDTO dto=new CustomerDTO();
		
		dto.setId(c.getId());
		dto.setName(c.getName());
		dto.setGender(c.getGender());
		dto.setLocation(c.getLocation());
		
		return dto;
	}

	@Override
	public List<CustomerDTO> displayAllCustomersDTO() 
	{
		//List<Customer> customers=customerRepository.findAll();
		
		List<Customer> customers=viewallCustomers();
		
		return customers.stream()  //list into individual objects
				.map(this::CustomerToCustomerDTO) //customer object to customerdto
				.collect(Collectors.toList()); 	//will be connected into list 
	}

	@Override
	public String deleteCustomer(int id) 
	{
		customerRepository.deleteById(id);
		
		return "Customer deleted successfully!!";
	}
}