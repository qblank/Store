package cn.qblank.util;
/**
 * 封装所有的订单状态
 * @author Administrator
 * 订单状态:
 * 			1表示待付款 
			2 表示待收货（已付款）
			3 表示待评价（已付款 已收货）
			4 表示可删除 （已付款 已收货 已评价）
			5 购物车（在购物车的商品记录，尚未提交到订单）

	评论状态:
			0表示不能评论
			1表示能评论 
			2 表示已评价
 */
public class OrderStatus {
	/*** 1表示待付款   ***/
	public static final  int NOPAY = 1;
	
	/*** 2表示待收货（已付款）  ***/
	public static final int PAYNORECE = 2;
	
	/*** 3表示待评价（已付款 已收货）***/
	public static final int  RECECOMMENT= 3;
	
	/*** 4表示可删除 （已付款 已收货 已评价）  ***/
	public static final int CANREMOVE = 4;
	
	/*** 5购物车（在购物车的商品记录，尚未提交到订单）  ***/
	public static final int SHOPCAR = 5;
	
	
	/*** 0表示不能评论  ***/
	public static final int NOCOMMENT = 0;
	/*** 1表示能评论  ***/
	public static final int CANCOMMENT = 1;
	/*** 2表示已评论 ***/
	public static final int COMMENTED = 2;
}
