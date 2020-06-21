package com.dpk.poc.mocking.bo;

public class Contact {
	
	private Integer id;
	private String name;
	private Long contactNum;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getContactNum() {
		return contactNum;
	}
	public void setContactNum(Long contactNum) {
		this.contactNum = contactNum;
	}
	@Override
	public String toString() {
		return "Contact [id=" + id + ", name=" + name + ", contactNum=" + contactNum + "]";
	}
	
	

}
