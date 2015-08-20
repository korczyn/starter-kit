package pl.spring.demo.to;

public class LibraryTo {
	private Long id;
	private String name;
	private String books;
	
	public LibraryTo(){
		
	}
	
	public LibraryTo(Long id, String name, String books){
		this.setId(id);
		this.setName(name);
		this.setBooks(books);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBooks() {
		return books;
	}

	public void setBooks(String books) {
		this.books = books;
	}
}
