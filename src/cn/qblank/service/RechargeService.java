package cn.qblank.service;

import cn.qblank.model.entity.User;

public interface RechargeService {
	/**
	 * 获取用户的信息
	 * @return
	 */
	public User getUserMessage(String username);
	
	/**
	 * 充值
	 */
//	public void updateMoney(User user,String recharge);
	
	/**
	 * 修改金额
	 * @param user
	 * @param recharge
	 * @param flag  true为充值  false为消费
	 */
	public void updateMoney(User user,String recharge,boolean flag);
}
