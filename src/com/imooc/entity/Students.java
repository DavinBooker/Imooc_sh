package com.imooc.entity;

import java.util.Date;

public class Students {
	private String sid,sname,gender,address;
	private Date birthday;
	
	public Students(){
		
	}
	
	
	public Students(String sid, String sname, String gender, String address,
			Date birthday) {
//		super();
		this.sid = sid;
		this.sname = sname;
		this.gender = gender;
		this.address = address;
		this.birthday = birthday;
	}


	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}


	@Override
	public String toString() {
		return "Students [sid=" + sid + ", sname=" + sname + ", gender="
				+ gender + ", address=" + address + ", birthday=" + birthday
				+ "]";
	}
	
}
