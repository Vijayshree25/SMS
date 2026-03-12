package com.klef.fsad.sdp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.fsad.sdp.entity.Admin;
import com.klef.fsad.sdp.entity.Customer;
import com.klef.fsad.sdp.entity.ServiceManager;
import com.klef.fsad.sdp.repository.AdminRepository;
import com.klef.fsad.sdp.repository.CustomerRepository;
import com.klef.fsad.sdp.repository.ServiceManagerRepository;

@Service
public class AdminServiceImpl implements AdminService
{
	@Autowired
	private AdminRepository adminRepository;

	@Autowired
	private ServiceManagerRepository managerRepository;

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
}