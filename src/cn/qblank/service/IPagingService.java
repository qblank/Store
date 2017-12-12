package cn.qblank.service;

import java.util.List;

import cn.qblank.model.entity.Order;

public interface IPagingService {
	/**
	 * 获取购物车的总个数
	 * @param order_status
	 * @param user_id
	 * @return
	 */
	public Integer getAllNum(int status,int user_id);
	
	/**
	 * 分页查询
	 * @param pageNum  当前页码
	 * @param pageSize 一页多少数据
	 * @return
	 */
	public List<Order> pagingShopCar(int pageNum,int pageSize,int status,int user_id);
}
