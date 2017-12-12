package cn.qblank.service.impl;


import cn.qblank.model.dao.impl.RechargeDaoImpl;
import cn.qblank.model.entity.User;
import cn.qblank.service.RechargeService;

public class RechargeServiceImpl implements RechargeService {

	@Override
	public User getUserMessage(String username) {
		return new RechargeDaoImpl().getUserMessage(username);
	}

	@Override
	public void updateMoney(User user,String recharge,boolean flag) {
		RechargeDaoImpl recDao = new RechargeDaoImpl();
		//进行充值的操作
		if (flag) {
			
			user.setMoney(user.getMoney() + Double.parseDouble(recharge));
		}else{
			
			user.setMoney(user.getMoney() - Double.parseDouble(recharge));
		}
		//调用dao层，进行对金钱改动
		recDao.updateMoney(user);
	}


	


	

}
