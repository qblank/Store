package cn.qblank.test;

import java.sql.Date;
import java.util.List;

import cn.qblank.model.dao.impl.OrderDaoImpl;
import cn.qblank.model.entity.Order;
import cn.qblank.service.impl.OrderServiceImpl;

public class OrderTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		OrderDaoImpl odi=new OrderDaoImpl();
		OrderServiceImpl osi=new OrderServiceImpl();
		Order order=new Order();
		order.setComment_status(1);
		order.setName("121231231231");
		order.setOrder_price(12.5);
		order.setOrder_status(1);
		order.setOrder_time(new Date(System.currentTimeMillis()));
		order.setUser_id("4");
		order.setUser_name("屁屁波");
//		System.out.println(odi.insertOrder(order));
//		System.out.println(odi.deleteOrder("24"));
//		List<Order> orders=odi.getOrderList(21);
		
		
		System.out.println("length:"+osi.getOrderList(22).size());
		System.out.println("length:"+osi.getOrderList(22));
		
//		System.out.println("order:"+osi.getShppingCarList(21));
////		System.out.println("order:"+osi.getOrder(orders, "4"));
////		for (Order order2 : orders) {
//////			if(order2.getId().equals("25")){
////				System.out.println(order2);
//				System.out.println(osi.getShoppingCarInfo(osi.getShppingCarList(22)).get("num"));
//				System.out.println(osi.getShoppingCarInfo(osi.getShppingCarList(22)).get("price"));
////			}
//		}
		
		
//		System.out.println(osi.listFilter(orders, "鱼"));
		
		
//		System.out.println(odi.deleteOrder("25"));
		
	}

}
