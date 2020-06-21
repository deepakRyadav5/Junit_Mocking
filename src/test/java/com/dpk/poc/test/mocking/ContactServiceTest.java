package com.dpk.poc.test.mocking;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.easymock.EasyMock;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.dpk.poc.mocking.bo.Contact;
import com.dpk.poc.mockito.dao.IContactDao;
import com.dpk.poc.mockito.exceptons.NoRecordFoundException;
import com.dpk.poc.mockito.service.ContactServiceImpl;
import com.dpk.poc.mockito.service.IContactService;

public class ContactServiceTest {

	private static IContactService contactService;

	@BeforeClass
	public static void beforeClass() {
		contactService = new ContactServiceImpl();

		// Mock for contactDao
		IContactDao contactDaoProxy = EasyMock.createMock(IContactDao.class);

		// setting behavior to proxy for method getNameById
		EasyMock.expect(contactDaoProxy.getNameById(101)).andReturn("Deepak");
		EasyMock.expect(contactDaoProxy.getNameById(201)).andReturn("");
		EasyMock.expect(contactDaoProxy.getNameById(301)).andReturn(null);

		// setting behavior to proxy for method getAllNames
		List<String> names = new ArrayList<String>();
		names.add("Deepak");
		names.add("Yadav");
		names.add("Poonam");
		names.add("Dipen");

		EasyMock.expect(contactDaoProxy.getAllNames()).andReturn(names);
		
		// setting behavior to proxy for method getContactById
		
		Contact contact1 = new Contact();
		contact1.setId(101);
		contact1.setName("Deepak");
		contact1.setContactNum(9004828373L);
		
		EasyMock.expect(contactDaoProxy.getContactById(101)).andReturn(contact1);
		
		// swithing controls with all behaviours
		EasyMock.replay(contactDaoProxy);

		((ContactServiceImpl) contactService).setContactDao(contactDaoProxy);

	}
	
	@AfterClass
	public static void afterClass() {
		contactService = null;
	}

	@Test
	public void testGetNameById_01() {

		String name = contactService.obtainNameById(101);

		assertNotNull(name);

	}

	@Test
	public void testGetNameById_02() {

		String name = contactService.obtainNameById(201);
		assertTrue(name.equals(""));
	}
	
	@Test(expected = NoRecordFoundException.class)
	public void testGetNameById_03() {

		String name = contactService.obtainNameById(301);
	}

	@Test
	public void testObtainAllNames_01() {

		List<String> names = contactService.obtainAllNames();
		assertNotNull(names);
		assertTrue(names.size() > 0);

	}
	
	@Test
	public void testObtainContactById_01() {

		Contact contact = contactService.obtainContactDetailById(101);
		assertNotNull(contact);
		assertTrue(contact.getName().equalsIgnoreCase("Deepak"));

	}

	

}
