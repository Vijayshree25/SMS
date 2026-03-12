package com.klef.fsad.sdp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.klef.fsad.sdp.entity.Customer;


@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer>
{
	//from customer where email=?1 and password=?2-->jpql query
	//select * from customer_table where email="" and password=""
	public Customer findByEmailAndPassword(String email, String password);
}
