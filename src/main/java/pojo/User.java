package pojo;

public class User {
    private String name;
    private String email;
    private String pwd;
    private String address;
    private double contact;
    private String gender;
	public User(String name, String email, String pwd, String address, double contact, String gender) {
		super();
		this.name = name;
		this.email = email;
		this.pwd = pwd;
		this.address = address;
		this.contact = contact;
		this.gender = gender;
	}
	public User(String email,String pwd) {
		this.email = email;
		this.pwd = pwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public double getContact() {
		return contact;
	}
	public void setContact(double contact) {
		this.contact = contact;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
}

