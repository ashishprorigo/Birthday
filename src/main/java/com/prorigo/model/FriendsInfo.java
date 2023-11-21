package com.prorigo.model;

import java.time.LocalDate;
import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity

public class FriendsInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
    
  //  @Nonnull
	private String name;
    
	//@Nonnull
	private Date dateOfBirth;
	
	//@Nonnull
	private String mail;
	
	
	
	public FriendsInfo(long id, String name, Date dateOfBirth, String mail) {
		super();
		this.id = id;
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.mail = mail;
	}
	public FriendsInfo() {
		// TODO Auto-generated constructor stub
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	

	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	@Override
	public String toString() {
		return "FriendsInfo [id=" + id + ", name=" + name + ", dateOfBirth=" + dateOfBirth + ", mail=" + mail + "]";
	} 
	
	
}
