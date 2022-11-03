package prob2;

public class Book extends LendingItem{
	private String isbn;
	private String title;
	private String authorFirstName;
	private String authorLastName;
	
	public Book(String isbn, String title, String fName, String lName) {
		this.isbn = isbn;
		this.title = title;
		authorFirstName = fName;
		authorLastName = lName;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(!(obj instanceof Book)) return false;
		Book b = (Book)obj;
		return isbn.equals(b.isbn) && title.equals(b.title) && authorFirstName.equals(b.authorFirstName) && authorLastName.equals(b.authorLastName);
	}
}
