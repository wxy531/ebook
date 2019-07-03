package mybook.Entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "evaluate")
public class Eva {

	 @Id
    private String id;
    @Field("bookname")
	private String bookname;
	private String username;
	private String eva;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getbookname() {
		return bookname;
	}

	public void setbookname(String bookname) {
		this.bookname = bookname;
	}

	public String getusername() {
		return username;
	}

	public void setusername(String username) {
		this.username = username;
	}
	public String geteva() {
		return eva;
	}

	public void seteva(String eva) {
		this.eva = eva;
	}

	public Eva(String id, String bookname, String username ,String eva) {
		this.id = id;
		this.bookname = bookname;
		this.username = username;
		this.eva = eva;
	}
	public Eva() {
		super();
	}
}

