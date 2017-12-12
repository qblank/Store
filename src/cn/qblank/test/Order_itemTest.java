package cn.qblank.test;

import java.util.ArrayList;
import java.util.List;

import cn.qblank.model.dao.impl.Order_itemDaoImpl;
import cn.qblank.model.entity.Order_item;

public class Order_itemTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Order_itemDaoImpl odi=new Order_itemDaoImpl();
		List<Order_item> order_items=new ArrayList<Order_item>();
		System.out.println(order_items=odi.getOrder_items("1"));
//		for (Order_item order_item : order_items) {
//			System.out.println(order_item);
//		}
		
		//添加列表项
//		Order_item order_item=new Order_item();
//		order_item.setO_id("1");
//		order_item.setP_id("1");
//		order_item.setSubtotal(150.2);
//		order_items.add(order_item);
////		for (Order_item order_item1 : order_items) {
////			System.out.println(order_item1);
////		}
//		System.out.println(odi.insertOrder_item(order_items));
		
		//删除列表项
//		System.out.println(odi.deleteOrder_item("1"));
	}

}
