package pl.spring.demo.to;

import java.util.List;

public class BookEntity implements IdAware{
	private Long id;
	private String title;
	private List<AuthorTo> author;
	
	public BookEntity(){
	}
	
	public BookEntity(Long id, String title, List<AuthorTo> author){
		this.id = id;
		this.title = title;
		this.author = author;
	}

	@Override
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<AuthorTo> getAuthor() {
		return author;
	}

	public void setAuthor(List<AuthorTo> author) {
		this.author = author;
	}
	
	public void addAuthor(Long id, String firstName, String lastName){
		author.add(new AuthorTo(id, firstName, lastName));
	}
	
}
