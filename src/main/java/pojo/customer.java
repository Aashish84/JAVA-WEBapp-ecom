package pojo;

public class Customer {
	private int id;
	private String name;
	private double contact;
	private String email;
	private String address;
	private boolean status;
	
	public Customer(int id, String name, double contact, String email, String address,boolean status) {
		super();
		this.id = id;
		this.name = name;
		this.contact = contact;
		this.email = email;
		this.address=address;
		this.status = status;
	}
	
	public Customer(String name, double contact, String email, String address) {
		super();
		this.name = name;
		this.contact = contact;
		this.email = email;
		this.address = address;
		this.status = false;
	}

	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getContact() {
		return contact;
	}
	public void setContact(double contact) {
		this.contact = contact;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
}
