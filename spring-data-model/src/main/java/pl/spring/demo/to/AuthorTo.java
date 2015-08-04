package pl.spring.demo.to;

public class AuthorTo{
	private Long id;
	private String firstName;
	private String lastName;
	
	public AuthorTo(){
	}
	
	public AuthorTo(Long id, String firstName, String lastName){
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public Long getId(){
		return id;
	}
	
	public void setID(Long id){
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLasteName() {
		return lastName;
	}

	public void setLasteName(String lasteName) {
		this.lastName = lasteName;
	}
	
	
	
}
