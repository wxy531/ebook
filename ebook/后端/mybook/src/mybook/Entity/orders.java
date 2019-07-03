package mybook.Entity;




import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
@Entity

@Table(name = "orders")
public class orders implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
    @Column(name = "orderid")
	private int order_id;
    @Column(name = "id")
	private String id;		
    @Column(name="create_time")
    private Date createTime;
    @Column(name = "phone")
	private int phone;	
    @Column(name = "address")
	private String address;
	
	
	
	@Override
	public String toString() {
		return "orders [order_id=" + order_id + ", id=" + id + ", createTime=" + createTime + ", phone=" + phone +
				", address=" + address +"]";
	}
	public Date getCreateTime() {
		return this.createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime=createTime;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}

	public orders(int order_id, String id, Date createTime, int phone,String address) {
		super();
		this.id = id;
		this.order_id = order_id;
		this.phone = phone;
		this.createTime = createTime;
		this.address = address;
	}
	public orders() {
		super();
	}
}
