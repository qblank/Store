package cn.qblank.test;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import cn.qblank.model.dao.impl.CommentDaoImpl;
import cn.qblank.model.entity.Comment;

public class CommentTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		CommentDaoImpl cdi=new CommentDaoImpl();
		List<Comment> comments=new ArrayList<Comment>();
		Comment comment=new Comment();
		comment.setP_id("3");
		comment.setUser_id("1");
		comment.setComment("wahhhhhhhhhhhhhhhhh");
		comment.setTime(new Date(System.currentTimeMillis()));
		comments.add(comment);
		cdi.insertComment(comments);
		List<Comment> commentList=cdi.getComments("3");
		for (Comment comment1 : commentList) {
			System.out.println(comment1);
		}
		System.out.println(commentList);
		
	}

}
