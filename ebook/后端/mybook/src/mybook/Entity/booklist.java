package mybook.Entity;




import java.io.Serializable;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


 @Entity
 @Table(name = "booklist")
 @JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class booklist implements Serializable{
	private static final long serialVersionUID = 1L;
	 @Id
	    @Column(name = "id")
	private int id;
	 @Column(name = "����")
	private String bookname;
	 @Column(name = "����")
	private String author;
	 @Column(name = "����")
	private String language;
	 @Column(name = "����")
	private int date;
	 @Column(name = "���")
	private int num;
	 @Column(name = "�۸�")
	private int price;
	 @Column(name = "��ϸ")
	private String detail;
	 @Column(name="����")
	 private byte[] cover;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public int getDate() {
		return date;
	}
	public void setDate(int date) {
		this.date = date;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public byte[] getCover() {
		return cover;
	}
	public void setCover(byte[] cover) {
		this.cover = cover;
	}
	public booklist(int id, String bookname, String author, String language,int date,int num,int price,String detail,byte[] cover) {
		super();
		this.id = id;
		this.bookname = bookname;
		this.author = author;
		this.language = language;
		this.date = date;
		this.num = num;
		this.price = price;
		this.detail = detail;
		this.cover = cover;
	}
	public booklist() {
		super();
	}
}
