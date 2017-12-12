package cn.qblank.model.entity;

import java.io.Serializable;

/**
 * 订单列表类
 * @author Administrator
 *
 */
public class Order_item implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String o_id;
	private String p_id;
	private double subtotal;
	private Product product;
	
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}


	public Order_item() {
		super();
	}


	public Order_item(String id, String o_id, String p_id, double subtotal) {
		super();
		this.id = id;
		this.o_id = o_id;
		this.p_id = p_id;
		this.subtotal = subtotal;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getO_id() {
		return o_id;
	}


	public void setO_id(String o_id) {
		this.o_id = o_id;
	}


	public String getP_id() {
		return p_id;
	}


	public void setP_id(String p_id) {
		this.p_id = p_id;
	}

	/**
	 * 获取商品小计
	 * @return
	 */
	public double getSubtotal() {
		return subtotal;
	}


	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}


	@Override
	public String toString() {
		return "Order_item [id=" + id + ", o_id=" + o_id + ", p_id=" + p_id + ", subtotal=" + subtotal + ", product="
				+ product + "]";
	}
	
	
	
	
}
