package com.dpk.poc.mockito.service;

import java.util.List;

import com.dpk.poc.mocking.bo.Contact;

public interface IContactService {
	public String obtainNameById(Integer id);
	
	public List<String> obtainAllNames();
	
	public Contact obtainContactDetailById(Integer id);
}
