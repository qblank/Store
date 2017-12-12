package cn.qblank.service.impl;


import cn.qblank.model.dao.impl.LoginRegImpl;
import cn.qblank.model.entity.User;
import cn.qblank.service.LogingRegImplService;

public class LoginRegServiceImpl implements LogingRegImplService {

	@Override
	public String getUserName(String name) {
		// TODO Auto-generated method stub
		return new LoginRegImpl().getUserName(name);
	}

	@Override
	public String getPassword(String name) {
		// TODO Auto-generated method stub
		return new LoginRegImpl().getPassword(name);
	}

	@Override
	public void registerUser(User users) {
		// TODO Auto-generated method stub
		new LoginRegImpl().registerUser(users);
	}

}
