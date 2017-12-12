package cn.qblank.service;

import cn.qblank.model.entity.User;

public interface LogingRegImplService {
	/**
	 * 获取用户名
	 * @param name
	 * @return
	 */
	public String getUserName(String name);
	/**
	 * 获取用户名密码
	 * @param name
	 * @return
	 */
	public String getPassword(String name);
	/**
	 * 添加注册信息
	 * @param users
	 */
	public void registerUser(User users);
}
