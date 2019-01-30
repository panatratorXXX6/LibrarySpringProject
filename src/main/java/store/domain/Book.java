package store.domain;

import java.util.Date;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/*
 * This Book class render the book
 */
@Entity
@Table(name="book")
public class Book {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@NotNull
	@Column
	private String isbn;
	
    @NotNull
    @Column(name="name")
    private String name;

    @NotNull
    @Column(name="age")
    private Integer age;
    
    @NotNull
    @Column(name="publishdate")
    private Date publishdate;
    
    @Column(name="count")
    private Integer count;
    
    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
                },mappedBy="bookofauthors")
    private Set<Author> author;
    
    public Book(){
    	
    }
    
	public Book(@NotNull String isbn, @NotNull String name, @NotNull Integer age, @NotNull Date publishdate,
			Integer count, Set<Author> author) {
		super();
		this.isbn = isbn;
		this.name = name;
		this.age = age;
		this.publishdate = publishdate;
		this.count = count;
		this.author = author;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Date getPublishdate() {
		return publishdate;
	}

	public void setPublishdate(Date publishdate) {
		this.publishdate = publishdate;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Set<Author> getAuthor() {
		return author;
	}

	public void setAuthor(Set<Author> author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", isbn=" + isbn + ", name=" + name + ", age=" + age + ", publishdate=" + publishdate
				+ ", count=" + count + ", author=" + author + "]";
	}

	
}


