package pl.spring.demo.entity;

public class BookSearchCriteria {
	private String title;
	private String author;
	private String libraryName;
	
	public BookSearchCriteria(String title, String author, String libraryName) {
		this.setTitle(title);
		this.setAuthor(author);
		this.setLibraryName(libraryName);
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

	public String getLibraryName() {
		return libraryName;
	}

	public void setLibraryName(String libraryName) {
		this.libraryName = libraryName;
	}
	
	
	
	
}
