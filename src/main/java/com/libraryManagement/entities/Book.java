package com.libraryManagement.entities;

import java.sql.Date;
//import java.util.Collection;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import java.util.Set;
//@Data

//@NoArgsConstructor
@Entity
@Table(name= "Book")
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private long bookId;

	private String title;
    private String author;
	private boolean available;
	private Date publishedDate;
	public long getBookId() {
		return bookId;
	}
	public void setBookId(long bookId) {
		this.bookId = bookId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public boolean isAvailable() {
		return available;
	}
	public void setAvailable(boolean available) {
		this.available = available;
	}
	public Date getPublishedDate() {
		return publishedDate;
	}
	public void setPublishedDate(Date publishedDate) {
		this.publishedDate = publishedDate;
	}
	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", title=" + title + ", author=" + author + ", available=" + available
				+ ", publishedDate=" + publishedDate + "]";
	}
	public Book(long bookId, String title, String author, boolean available, Date publishedDate) {
		super();
		this.bookId = bookId;
		this.title = title;
		this.author = author;
		this.available = available;
		this.publishedDate = publishedDate;
	}
	public Book() {
		super();
	}
	@ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "books_publishers",
            joinColumns = @JoinColumn(name = "bookId"),
            inverseJoinColumns = @JoinColumn(name = "publisherId")
    )
    private Collection<Publisher> publishers;
	
//	@OneToMany(mappedBy = "book") 
//	private Set<Member> member;
	
	@ManyToOne
    @JoinColumn(name="member_id")
    private Member member;
	
}
