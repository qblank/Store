package cn.qblank.service;

public interface IUserService {
	/**
	 * 通过id查找用户信息
	 * @return
	 */
	public Integer findIdByName(String name);
}
