package cn.qblank.model.dao;

import cn.qblank.model.entity.User;

/**
 * 用户信息
 * @author Administrator
 *
 */
public interface IUserDao {
	
	/**
	 * 通过id查找用户信息
	 * @return
	 */
	public Integer findIdByName(String name);
}
