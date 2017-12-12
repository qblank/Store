package cn.qblank.test;

import cn.qblank.model.dao.impl.CategoryImpl;
import cn.qblank.model.entity.Product;

public class CategoryTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CategoryImpl ci=new CategoryImpl();
		Product product=ci.getProduct("1");
		System.out.println(product);
	}

}
