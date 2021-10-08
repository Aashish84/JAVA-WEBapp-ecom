package pojo;

public class ordereditem {
	private int customer_id;
	private int product_id;
	private boolean status;
	//status 0 = processing , 1 = ordercomplete
	public ordereditem(int customer_id, int product_id, boolean status) {
		super();
		this.customer_id = customer_id;
		this.product_id = product_id;
		this.status = status;
	}
	public int getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
}
