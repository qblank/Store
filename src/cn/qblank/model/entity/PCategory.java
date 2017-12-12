package cn.qblank.model.entity;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * 商品类别类
 * @author Administrator
 *
 */
@SuppressWarnings("serial")
public class PCategory implements Serializable{
	private String id;
	private String name;
	private ArrayList<TowPCategory> towPCategory;
	
	public ArrayList<TowPCategory> getTowPCategory() {
		return towPCategory;
	}
	public void setTowPCategory(ArrayList<TowPCategory> towPCategory) {
		this.towPCategory = towPCategory;
	}
	public PCategory() {
	}
	public PCategory(String id, String name) {
		super();
		this.id = id;
		this.name = name;
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
	
	
	
	
}
