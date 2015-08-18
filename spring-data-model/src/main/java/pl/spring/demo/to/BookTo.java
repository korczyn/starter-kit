package pl.spring.demo.to;

public class BookTo {
    private Long id;
    private String title;
    private String authors;
    private String libName;

    public BookTo() {
    }

    public BookTo(Long id, String title, String authors, String libName) {
        this.id = id;
        this.title = title;
        this.authors = authors;
        this.libName = libName;
    }

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

    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

	public String getLibName() {
		return libName;
	}

	public void setLibName(String libName) {
		this.libName = libName;
	}
}
