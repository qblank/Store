package cn.qblank.service.impl;

import cn.qblank.model.dao.impl.UserDaoImpl;
import cn.qblank.service.IUserService;

public class UserServiceImpl implements IUserService{

	@Override
	public Integer findIdByName(String name) {
		return new UserDaoImpl().findIdByName(name);
	}
	
}
