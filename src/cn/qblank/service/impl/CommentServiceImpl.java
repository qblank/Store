package cn.qblank.service.impl;

import java.util.List;

import cn.qblank.model.dao.impl.CommentDaoImpl;
import cn.qblank.model.entity.Comment;
import cn.qblank.service.CommentService;

public class CommentServiceImpl implements CommentService {

	/**
	 * 根据商品id得到评论
	 */
	@Override
	public List<Comment> getComments(String p_id) {
		// TODO Auto-generated method stub
		return new CommentDaoImpl().getComments(p_id);
	}

	/**
	 * 插入评论
	 */
	@Override
	public boolean insertComment(List<Comment> comments) {
		// TODO Auto-generated method stub
		return new CommentDaoImpl().insertComment(comments);
	}
	
	/**
	 * 获得评论的用户名
	 */
	public String findusernameByComment(String comment) {
		// TODO Auto-generated method stub
		return new CommentDaoImpl().findusernameByComment(comment);
	}

}
