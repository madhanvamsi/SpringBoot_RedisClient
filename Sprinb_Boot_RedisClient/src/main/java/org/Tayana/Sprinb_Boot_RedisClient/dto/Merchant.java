package org.Tayana.Sprinb_Boot_RedisClient.dto;

import java.io.Serializable;


import org.springframework.data.redis.core.RedisHash;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;


@RedisHash("merchant")
@Entity
public class Merchant implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	private int id;
	@Column(nullable = false)
	private String fname;
	@Column(nullable = false)
	private String lname;
	@Column(nullable = false, unique = true)
	private long phone;
	public int getId()
	{
		return id;
	}
	public void setId(int id) 
	{
		this.id = id;
	}
	public String getFname() 
	{
		return fname;
	}
	public void setFname(String fname) 
	{
		this.fname = fname;
	}
	public String getLname()
	{
		return lname;
	}
	public void setLname(String lname)
	{
		this.lname = lname;
	}
	public long getPhone() 
	{
		return phone;
	}
	public void setPhone(long phone)
	{
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "Merchant [id=" + id + ", fname=" + fname + ", lname=" + lname + ", phone=" + phone + "]";
	}
	
	
	

}
