package cn.qblank.model.entity;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * 二级类别
 * @author Administrator
 *
 */
@SuppressWarnings("serial")
public class TowPCategory implements Serializable{
	private String id;
	private String name;
	private String c_id;
	private ArrayList<Product> product;
	
	
	
	public TowPCategory(String id, String name, String c_id,
			ArrayList<Product> product) {
		super();
		this.id = id;
		this.name = name;
		this.c_id = c_id;
		this.product = product;
	}
	public TowPCategory() {
		super();
	}
	public ArrayList<Product> getProduct() {
		return product;
	}
	public void setProduct(ArrayList<Product> product) {
		this.product = product;
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
	public String getC_id() {
		return c_id;
	}
	public void setC_id(String c_id) {
		this.c_id = c_id;
	}
	
	

}
