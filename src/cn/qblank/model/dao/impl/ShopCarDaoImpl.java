package cn.qblank.model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import cn.qblank.model.dao.IShopCarDao;
import cn.qblank.model.entity.ShopCarItem;
import cn.qblank.util.ConnectionFactory;

public class ShopCarDaoImpl implements IShopCarDao{
	PreparedStatement pstmt = null;
	Connection conn = null;

	@Override
	public ArrayList<ShopCarItem> items() {
		ResultSet rs = null;
		//购物项的所有信息
		String sql = "select * from s_order";
		conn = ConnectionFactory.getConnection();
		
		
		
		return null;
	}

	@Override
	public ShopCarItem findById(String id) {
		return null;
	}
	
}
