package cn.qblank.model.entity;

import java.io.Serializable;

/**
 * 购物项
 * @author Administrator
 *
 */
@SuppressWarnings("serial")
public class ShopCarItem implements Serializable{
	//商品对象
	private Product product;
	//小计
	private Double subTotal;
	
	//数量
	private Integer count;
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	/**
	 * 获取小计
	 * @return
	 */
	public Double getSubTotal() {
		return product.getPrice() * product.getCount();
	}
	public void setSubTotal(Double subTotal) {
		this.subTotal = subTotal;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	
}
