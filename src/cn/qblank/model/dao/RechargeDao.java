package cn.qblank.model.dao;

import cn.qblank.model.entity.User;

public interface RechargeDao {
	/**
	 * 获取用户的信息
	 * @return
	 */
	public User getUserMessage(String username);
	
	/**
	 * 修改金额
	 */
	public void updateMoney(User user);
	
	
}
