package store.domain;

import java.util.Date;


import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/*
 * This Author class represent an author entity
 */
@Entity
@Table(name="author")
 public class Author {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private Integer id;
	
	@Column(name="name")
	private String name;

	@Column(name="birthday")
	private Date birthday;
	
	@Column(name="address")
	private String address;
	
	@Column(name="description")
	private String description;
	
	@ManyToMany
	private Set<Book> bookofauthors;
	
	public Set<Book> getBookofauthors() {
		return bookofauthors;
	}

	public void setBookofauthors(Set<Book> bookofauthors) {
		this.bookofauthors = bookofauthors;
	}

	public Author() {
	}
	
	public Author(String name, Date birthday, String address, String description, Set<Book> bookofauthors) {
		super();
		this.name = name;
		this.birthday = birthday;
		this.address = address;
		this.description = description;
		this.bookofauthors = bookofauthors;
	}

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

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Author [id=" + id + ", name=" + name + ", birthday=" + birthday + ", address=" + address
				+ ", description=" + description +  "]";
	}
}
