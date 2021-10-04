package pojo;

public class Product {
	private int id;
	private String name;
	private int category_id;
	private boolean status;
	private int price;
	private int discount;
	private int inventory;
	private String image;
	
	public Product() {}

	public Product(String name, int category_id, boolean status,int price, int discount, int inventory, String image) {
		super();
		this.name = name;
		this.category_id = category_id;
		this.status = status;
		this.price=price;
		this.discount = discount;
		this.inventory = inventory;
		this.image = image;
	}

	public Product(int id, String name, int category_id, boolean status, int price,int discount, int inventory, String image) {
		super();
		this.id = id;
		this.name = name;
		this.category_id = category_id;
		this.status = status;
		this.price=price;
		this.discount = discount;
		this.inventory = inventory;
		this.image = image;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
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

	public int getInventory() {
		return inventory;
	}

	public void setInventory(int inventory) {
		this.inventory = inventory;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
}
