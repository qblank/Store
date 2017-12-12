package cn.qblank.service;

import java.util.List;

import cn.qblank.model.entity.Comment;

public interface CommentService {
	
	/**
	 * 根据商品的ID得到数据库中对应的所有评论
	 * @param p_id
	 * @return
	 */
	public abstract List<Comment> getComments(String p_id);
	
	/**
	 * 将得到的评论对象插入到数据库中
	 * @param comment
	 * @return
	 */
	public abstract boolean insertComment(List<Comment> comments);
	
	/**
	 * 获得该评论的用户名
	 * @param comment
	 * @return
	 */
	public abstract String findusernameByComment(String comment);
}
