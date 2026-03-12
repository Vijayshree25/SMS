package com.klef.fsad.sdp.service;

import java.util.List;

import com.klef.fsad.sdp.entity.Admin;
import com.klef.fsad.sdp.entity.Customer;
import com.klef.fsad.sdp.entity.ServiceManager;

public interface AdminService 
{
	public Admin verifyAdminlogin(String username,String password); //it is going to verify admin login
	
	public String addServiceManager(ServiceManager sm); //
	
	public List<ServiceManager> viewallServiceManagers();
	
	public boolean deleteServiceManagerString(int id);
	
	public List<Customer> viewallCustomers();
}
