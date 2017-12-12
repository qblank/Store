package cn.qblank.model.entity;

import java.io.Serializable;

/**
 * 商品类
 * @author Administrator
 *
 */
@SuppressWarnings("serial")
public class Product implements Serializable{
	private String id;
	private String name;
	//商品的价格
	private double price;
	//商品的描述
	private String describe;
	private int count;
	//商品的重量
	private String weight;
	//图片的位置
	private String image;
	//商品类别编号
	private String tc_id;
	
	
	
	public Product(String id, String name, double price, String describe,
			int count, String weight, String image, String c_id) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.describe = describe;
		this.count = count;
		this.weight = weight;
		this.image = image;
		this.tc_id = c_id;
	}

	public Product() {
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
	
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDescribe() {
		return describe;
	}
	public void setDescribe(String describe) {
		this.describe = describe;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getTc_id() {
		return tc_id;
	}
	public void setTc_id(String c_id) {
		this.tc_id = c_id;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + ", describe=" + describe + ", count="
				+ count + ", weight=" + weight + ", image=" + image + ", tc_id=" + tc_id + "]";
	}
	
	
	
	
	
}
