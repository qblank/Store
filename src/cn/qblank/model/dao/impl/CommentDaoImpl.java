package cn.qblank.model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.qblank.model.dao.ICommentDao;
import cn.qblank.model.entity.Comment;
import cn.qblank.util.ConnectionFactory;

public class CommentDaoImpl implements ICommentDao {

	
	//查找对应商品号的所有评论
	@Override
	public List<Comment> getComments(String p_id) {
		// TODO Auto-generated method stub
		List<Comment> commentList=new ArrayList<Comment>();
		Connection conn=ConnectionFactory.getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		Comment comment=null;
		String sql="select id,user_id,p_id,user_comment,c_time from s_comment where p_id = ?";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, p_id);
			rs=pstmt.executeQuery();
			while(rs.next()){
				comment=new Comment();
				comment.setId(rs.getString("id"));
				comment.setUser_id(rs.getString("user_id"));
				comment.setP_id(rs.getString("p_id"));
				comment.setComment(rs.getString("user_comment"));
				comment.setTime(rs.getDate("c_time"));
				commentList.add(comment);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			ConnectionFactory.close(conn, pstmt, null, rs);
		}
		return commentList;
	}

	
	//插入商品的评论到数据库
	@Override
	public boolean insertComment(List<Comment> comments) {
		boolean tag=false;
		Connection conn=ConnectionFactory.getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		String sql="insert into s_comment values(s_comment_seq.nextval,?,?,?,?)";
		try {
			for (Comment comment : comments) {
				conn.setAutoCommit(false);
				pstmt=conn.prepareStatement(sql);
//				pstmt.setString(1, id);
				pstmt.setString(1, comment.getUser_id());
				pstmt.setString(2, comment.getP_id());
				pstmt.setString(3, comment.getComment());
				pstmt.setDate(4, comment.getTime());
				int i=pstmt.executeUpdate();
				if(i<=0){
					tag=false;
				}
			}
			conn.commit();
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally {
			ConnectionFactory.close(conn, pstmt, null, rs);
		}
		return tag;
	}

	
	
	//通过评论查评论者的name
	public String findusernameByComment(String comment) {
		/*List<User> user =  new ArrayList<User>();*/
		String user = null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		Connection conn = ConnectionFactory.getConnection();
		
		try {
			String sql = "select name from s_user where id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, comment);
			
			rs=pstmt.executeQuery();
			while (rs.next()) {
				/*User u = new User();
				u.setName(rs.getString(1));
				
				user.add(u);*/
				 user =rs.getString(1);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			ConnectionFactory.close(conn, pstmt, null, rs);
		}
		
		
		return user;
	}

}
