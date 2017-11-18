package com.gsau.entity;

import java.util.Date;

public class Students {

	private String stu_id;
	private String stu_name;
	private String stu_sex;
	private Date stu_birth;
	private String stu_birthplace;
	private String stu_email;
	private String stu_telephone;
	private String dept_id;
	
	public Students() {
		
	}

	public String getStu_id() {
		return stu_id;
	}

	public void setStu_id(String stu_id) {
		this.stu_id = stu_id;
	}

	public String getStu_name() {
		return stu_name;
	}

	public void setStu_name(String stu_name) {
		this.stu_name = stu_name;
	}

	public String getStu_sex() {
		return stu_sex;
	}

	public void setStu_sex(String stu_sex) {
		this.stu_sex = stu_sex;
	}

	public Date getStu_birth() {
		return stu_birth;
	}

	public void setStu_birth(Date stu_birth) {
		this.stu_birth = stu_birth;
	}

	public String getStu_birthplace() {
		return stu_birthplace;
	}

	public void setStu_birthplace(String stu_birthplace) {
		this.stu_birthplace = stu_birthplace;
	}

	public String getStu_email() {
		return stu_email;
	}

	public void setStu_email(String stu_email) {
		this.stu_email = stu_email;
	}

	public String getStu_telephone() {
		return stu_telephone;
	}

	public void setStu_telephone(String stu_telephone) {
		this.stu_telephone = stu_telephone;
	}

	public String getDept_id() {
		return dept_id;
	}

	public void setDept_id(String dept_id) {
		this.dept_id = dept_id;
	}

	public Students(String stu_id, String stu_name, String stu_sex,
			Date stu_birth, String stu_birthplace, String stu_email,
			String stu_telephone, String dept_id) {
		super();
		this.stu_id = stu_id;
		this.stu_name = stu_name;
		this.stu_sex = stu_sex;
		this.stu_birth = stu_birth;
		this.stu_birthplace = stu_birthplace;
		this.stu_email = stu_email;
		this.stu_telephone = stu_telephone;
		this.dept_id = dept_id;
	}
	
}
