package cn.qblank.model.entity;

import java.io.Serializable;

/**
 * 用户类
 * @author Administrator
 *
 */
@SuppressWarnings("serial")
public class User implements Serializable{
	private String id;	
	private String name;
	private String password;
	private int age;
	private String gender;
	private String phone;
	private String address;
	private double money;
	
	public User() {
		
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", password=" + password
				+ ", age=" + age + ", gender=" + gender + ", phone=" + phone
				+ ", address=" + address + ", money=" + money + "]";
	}

	public User(String id, String name, String password, int age,
			String gender, String phone, String address, double money) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.age = age;
		this.gender = gender;
		this.phone = phone;
		this.address = address;
		this.money = money;
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


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public double getMoney() {
		return money;
	}


	public void setMoney(double money) {
		this.money = money;
	} 
	
	
	
}
