package com.libraryManagement.entities;



import java.sql.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;




@Entity
@Table(name= "Member")

public class Member {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long memberId;
	private String Name;
	private String Address;
	private Date StartDate;
	private Date ExpiryDate;
	public long getMemberId() {
		return memberId;
	}
	public void setMemberId(long memberId) {
		this.memberId = memberId;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public Date getStartDate() {
		return StartDate;
	}
	public void setStartDate(Date startDate) {
		StartDate = startDate;
	}
	public Date getExpiryDate() {
		return ExpiryDate;
	}
	public void setExpiryDate(Date expiryDate) {
		ExpiryDate = expiryDate;
	}
	public Member(long memberId, String name, String address, Date startDate, Date expiryDate) {
		super();
		this.memberId = memberId;
		Name = name;
		Address = address;
		StartDate = startDate;
		ExpiryDate = expiryDate;
	}
	public Member() {
		super();
	}
//	@ManyToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name ="book_id") 
//	private Book book;
	 @OneToMany(mappedBy="member")
	    private Set<Book> books;
	
}
