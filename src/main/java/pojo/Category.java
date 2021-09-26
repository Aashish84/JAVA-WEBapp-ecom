package pojo;

public class Category {
	private int id;
	private String name;
	private boolean status;
	public Category(int id, String name, boolean status) {
		super();
		this.id = id;
		this.name = name;
		this.status = status;
	}
	public Category(String name, boolean status) {
		this.name = name;
		this.status = status;
	}
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
}
