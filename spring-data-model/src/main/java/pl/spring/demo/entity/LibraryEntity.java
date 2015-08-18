package pl.spring.demo.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "LIBRARY")
public class LibraryEntity {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	
	@Column(nullable = false, length = 50, updatable=false)
    private String libName;
	
	@OneToMany(
			cascade = CascadeType.ALL,
			fetch = FetchType.EAGER
			,mappedBy = "library"
			)
//	@JoinColumn(name = "lib_id")
	private Set<BookEntity> books = new HashSet<>();
//	@JoinTable(
//			name = "LIBRARY_BOOK",
//			joinColumns = {@JoinColumn(name = "LIBRARY_NAME", nullable = false, updatable = false)},
//			inverseJoinColumns = {@JoinColumn(name = "BOOK_ID", nullable = false, updatable = false)}
//			)
//	@JoinColumn(name = "libname")
	
	protected LibraryEntity(){
	}

	public LibraryEntity(Long id, String name){
		this.id = id;
		this.libName = name;
	}
	
	public Long getId(){
		return id;
	}
	
	public void setName(String name){
		this.libName = name;
	}
	
	public String getName(){
		return libName;
	}
	
	public void setBooks(Set<BookEntity> books){
		this.books = books;
	}
	
	public Set<BookEntity> getBooks(){
		return books;
	}
}
