package cn.qblank.model.dao;

import java.util.ArrayList;

import cn.qblank.model.entity.ShopCarItem;

/**
 * 购物车接口类
 * @author Administrator
 *
 */
public interface IShopCarDao {
	/**
	 * 查询所有商品列表
	 * @return
	 */
	public ArrayList<ShopCarItem> items();
	/**
	 * 通过id获取商品的详细信息
	 * @param id
	 * @return
	 */
	public ShopCarItem findById(String id);
	
	
}
