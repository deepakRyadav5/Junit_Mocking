package com.dpk.poc.mockito.dao;

import java.util.List;

import com.dpk.poc.mocking.bo.Contact;

public interface IContactDao {
	
	public String getNameById(Integer id);

	public List<String> getAllNames();

	public Contact getContactById(Integer id);
	
}
