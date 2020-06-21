package com.dpk.poc.mockito.service;

import java.util.List;

import com.dpk.poc.mocking.bo.Contact;
import com.dpk.poc.mockito.dao.IContactDao;
import com.dpk.poc.mockito.exceptons.NoRecordFoundException;

public class ContactServiceImpl implements IContactService {

	private IContactDao contactDao;

	public void setContactDao(IContactDao contactDao) {
		this.contactDao = contactDao;
	}

	public String obtainNameById(Integer id) {

		String name = null;
		name = contactDao.getNameById(id);

		if (name == null)
			throw new NoRecordFoundException();

		return name;
	}

	public List<String> obtainAllNames() {
		List<String> names = null;

		names = contactDao.getAllNames();

		return names;
	}

	public Contact obtainContactDetailById(Integer id) {

		Contact contact = contactDao.getContactById(id);

		return contact;
	}

}
