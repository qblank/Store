package cn.qblank.service.impl;

import java.util.List;

import cn.qblank.model.dao.impl.PagingImpl;
import cn.qblank.model.entity.Order;
import cn.qblank.model.entity.Order_item;
import cn.qblank.service.IPagingService;

public class PagingServiceImpl implements IPagingService {

	@Override
	public Integer getAllNum(int status,int user_id) {
		return new PagingImpl().getAllNum(status,user_id);
	}

	@Override
	public List<Order> pagingShopCar(int pageNum, int pageSize,int status,int user_id) {
		return new PagingImpl().pagingShopCar(pageNum, pageSize,status,user_id);
	}

}
