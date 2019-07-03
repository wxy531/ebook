package mybook.Entity;




import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "users")
public class users implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
    @Column(name = "id")
	private String id;
	@Column(name = "password")
	private String password;
	@Column(name = "name")
	private String name;
	@Column(name = "phone")
	private long phone;	
	@Column(name = "email")
	private String email;
	@Column(name = "address")
	private String address;
	@Column(name = "manager")
	private int manager;
	
	
	@Override
	public String toString() {
		return "orders [id=" + id + ", password=" + password + ", name=" + name + ", phone=" + phone +
				", email=" + email +", address=" + address + ", manager=" + manager +"]";
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getManager() {
		return manager;
	}
	public void setManager(int manager) {
		this.manager = manager;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public users(String id, String password, String name, long phone,String email,String  address,int manager) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.phone = phone;
		this.phone = phone;
		this.email = email;
		this.manager = manager;
	}
	public users() {
		super();
	}
}
