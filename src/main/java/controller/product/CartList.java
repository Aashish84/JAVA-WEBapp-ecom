package controller.product;

import java.util.ArrayList;

public class CartList {
	public static ArrayList<int[]> list = new ArrayList<int []>();
	
	public void cartListAdd(int id) {
		int []xyz= {id,1};
		//check if list is null
		if(list == null) {
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
	public void display() {
		for(int []i:list) {
			System.out.println(i[0]+" "+i[1]);
		}
	}
}
