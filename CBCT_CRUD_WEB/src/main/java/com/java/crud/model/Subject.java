package com.java.crud.model;

public class Subject {

	int subject_no;
	String subject_name;
	String subject_code;
	int subject_credit;
	String subject_type;
	String basket_id;
	public int getSubject_no() {
		return subject_no;
	}
	public void setSubject_no(int subject_no) {
		this.subject_no = subject_no;
	}
	public String getSubject_name() {
		return subject_name;
	}
	public void setSubject_name(String subject_name) {
		this.subject_name = subject_name;
	}
	public String getSubject_code() {
		return subject_code;
	}
	public void setSubject_code(String subject_code) {
		this.subject_code = subject_code;
	}
	public int getSubject_credit() {
		return subject_credit;
	}
	public void setSubject_credit(int subject_credit) {
		this.subject_credit = subject_credit;
	}
	public String getSubject_type() {
		return subject_type;
	}
	public void setSubject_type(String subject_type) {
		this.subject_type = subject_type;
	}
	public String getBasket_id() {
		return basket_id;
	}
	public void setBasket_id(String basket_id) {
		this.basket_id = basket_id;
	}
}
