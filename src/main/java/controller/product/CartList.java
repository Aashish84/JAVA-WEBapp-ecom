package controller.product;

import java.util.ArrayList;

public class CartList {
	private static CartList single_instance = null;
	public static CartList getInstance() {
		if (single_instance == null) {
			single_instance = new CartList();
		}
		
		return single_instance;
	}
	private ArrayList<int[]> list;
	private CartList(){
		list = new ArrayList<>();
	}
	
	public void cartListAdd(int id) {
		int []xyz= {id,1};
		//check if list is null
		if(list == null) {
			 //list = new ArrayList<int []>();
			list.add(xyz);
		}else {
			//check if value present in list already
			int flag=0;
			for (int [] i : list) {
				if(i[0]==id) {
					flag = 1;
					break;
				}
			}
			if(flag==0) {
				list.add(xyz);
			}
		}
	}
	
	public ArrayList<int[]> getList() {
		return list;
	}

	public void setList(ArrayList<int[]> list) {
		this.list = list;
	}
	
	public void display() {
		for(int []i:list) {
			System.out.println(i[0]+" "+i[1]);
		}
	}
}
