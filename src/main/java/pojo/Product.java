package pojo;

public class Product {
	private int id;
	private String name;
	private int category_id;
	private boolean status;
	private int discount;
	private int quantity_left;
	
	public Product() {}
	
	public Product(int id, String name, int category_id, boolean status, int discount, int quantity_left) {
		this.id = id;
		this.name = name;
		this.category_id = category_id;
		this.status = status;
		this.discount = discount;
		this.quantity_left = quantity_left;
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

	public int getCategory_id() {
		return category_id;
	}

	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public int getQuantity_left() {
		return quantity_left;
	}

	public void setQuantity_left(int quantity_left) {
		this.quantity_left = quantity_left;
	}
	
	
	
}
