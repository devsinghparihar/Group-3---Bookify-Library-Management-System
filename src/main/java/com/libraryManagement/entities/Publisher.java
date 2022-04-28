package com.libraryManagement.entities;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="Publisher")


public class Publisher {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long publisherId;
	 
	 private String Name;
	 private String Company;
	public Long getPublisherId() {
		return publisherId;
	}
	public void setPublisherId(Long publisherId) {
		this.publisherId = publisherId;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getCompany() {
		return Company;
	}
	public void setCompany(String company) {
		Company = company;
	}
	public Publisher(Long publisherId, String name, String company) {
		super();
		this.publisherId = publisherId;
		Name = name;
		Company = company;
	}
	public Publisher() {
		super();
	}
    @ManyToMany(mappedBy = "publishers")
    private Collection<Book> books;
}
