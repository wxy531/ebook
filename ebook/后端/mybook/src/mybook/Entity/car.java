package mybook.Entity;




import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@Entity
@Table(name = "car")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class car implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
    @Column(name = "carid")
	private int car_id;
	@Column(name = "id")
	private String id;
	@Column(name = "time")
	private String time;
	@Column(name = "num")
	private int num;
	@Column(name = "bookname")
	private String bookname;


	
	@Override
	public String toString() {
		return "car [car_id=" + car_id + ", id=" + id + ", bookname=" + bookname + ", time=" + time +
				", num=" + num  +"]";
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}

	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getCar_id() {
		return car_id;
	}
	public void setCar_id(int car_id) {
		this.car_id = car_id;
	}
	public car(int car_id, String id, String time, String bookname,int num) {
		super();
		this.id = id;
		this.bookname = bookname;
		this.car_id = car_id;
		this.time = time;
		this.num = num;

	}
	public car() {
		super();
	}
}
