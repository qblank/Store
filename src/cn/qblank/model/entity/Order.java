package cn.qblank.model.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;
/**
 * 订单类
 * @author Administrator
 *
 */
public class Order implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String name;
	private String user_id;
	private int comment_status;
	private int order_status;
	private double order_price;
	private Date order_time;
	private String user_name;
	private List<Order_item> order_items; 
	
	public List<Order_item> getOrder_items() {
		return order_items;
	}
	public void setOrder_items(List<Order_item> order_items) {
		this.order_items = order_items;
	}
	public Order() {
		super();
	}
	public Order(String id, String name, String user_id, int comment_status,
			int order_status, double order_price, Date order_time,
			String user_name) {
		super();
		this.id = id;
		this.name = name;
		this.user_id = user_id;
		this.comment_status = comment_status;
		this.order_status = order_status;
		this.order_price = order_price;
		this.order_time = order_time;
		this.user_name = user_name;
	}
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public int getComment_status() {
		return comment_status;
	}
	public void setComment_status(int comment_status) {
		this.comment_status = comment_status;
	}
	public int getOrder_status() {
		return order_status;
	}
	public void setOrder_status(int order_status) {
		this.order_status = order_status;
	}
	public double getOrder_price() {
		return order_price;
	}
	public void setOrder_price(double order_price) {
		this.order_price = order_price;
	}
	public Date getOrder_time() {
		return order_time;
	}
	public void setOrder_time(Date order_time) {
		this.order_time = order_time;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	@Override
	public String toString() {
		return "Order [id=" + id + ", name=" + name + ", user_id=" + user_id + ", comment_status=" + comment_status
				+ ", order_status=" + order_status + ", order_price=" + order_price + ", order_time=" + order_time
				+ ", user_name=" + user_name + ", order_items=" + order_items + "]";
	}
	
	
	
}
