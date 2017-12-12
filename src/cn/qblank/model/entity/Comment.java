package cn.qblank.model.entity;

import java.io.Serializable;
import java.sql.Date;

/**
 * 评论类
 * @author Administrator
 *
 */
public class Comment implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String user_id;
	//商品编号
	private String p_id;
	//评论内容
	private String comment;
	//评论时间
	private Date time;
	
	
	public Comment() {
		
	}


	public Comment(String id, String user_id, String p_id, String comment,
			Date time) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.p_id = p_id;
		this.comment = comment;
		this.time = time;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getUser_id() {
		return user_id;
	}


	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}


	public String getP_id() {
		return p_id;
	}


	public void setP_id(String p_id) {
		this.p_id = p_id;
	}


	public String getComment() {
		return comment;
	}


	public void setComment(String comment) {
		this.comment = comment;
	}


	public Date getTime() {
		return time;
	}


	public void setTime(Date time) {
		this.time = time;
	}


	@Override
	public String toString() {
		return "id:" + id + ", user_id:" + user_id + ", p_id:" + p_id + ", comment:" + comment + ", time:"
				+ time;
	}
	
	
	
	
}
