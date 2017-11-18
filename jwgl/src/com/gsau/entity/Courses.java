package com.gsau.entity;

public class Courses {
 private String cour_id;
 private String cour_name;
 private int cour_hour;
 private int semester;
 private int credit;
 private int type;
 private int flag;
public int getFlag() {
	return flag;
}
public void setFlag(int flag) {
	this.flag = flag;
}
public String getCour_id() {
	return cour_id;
}
public void setCour_id(String cour_id) {
	this.cour_id = cour_id;
}
public String getCour_name() {
	return cour_name;
}
public void setCour_name(String cour_name) {
	this.cour_name = cour_name;
}
public int getCour_hour() {
	return cour_hour;
}
public void setCour_hour(int cour_hour) {
	this.cour_hour = cour_hour;
}
public int getSemester() {
	return semester;
}
public void setSemester(int semester) {
	this.semester = semester;
}
public int getCredit() {
	return credit;
}
public void setCredit(int credit) {
	this.credit = credit;
}
public int getType() {
	return type;
}
public void setType(int type) {
	this.type = type;
}
 
}
