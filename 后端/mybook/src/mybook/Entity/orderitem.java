package mybook.Entity;




import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;
@Entity
@Table(name = "orderitem")
public class orderitem implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
    @Column(name = "itemid")
	private int item_id;
	@Column(name = "orderid")
	private int order_id;
	@Column(name = "num")
	private int num;
	@Column(name = "bookname")
	private String bookname;


	
	@Override
	public String toString() {
		return "orderitem [item_id=" + item_id + ", order_id=" + order_id + ", bookname=" + bookname +", num=" + num  +"]";
	}
	public int getItem_id() {
		return item_id;
	}
	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}

	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}

	public orderitem(int item_id, int order_id, String bookname,int num) {
		super();
		this.item_id = item_id;
		this.bookname = bookname;
		this.order_id = order_id;
		this.num = num;

	}
	public orderitem() {
		super();
	}
}
