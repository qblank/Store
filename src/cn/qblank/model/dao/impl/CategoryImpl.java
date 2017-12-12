package cn.qblank.model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import cn.qblank.model.dao.CategoryDao;
import cn.qblank.model.entity.PCategory;
import cn.qblank.model.entity.Product;
import cn.qblank.model.entity.TowPCategory;
import cn.qblank.util.ConnectionFactory;

public class CategoryImpl implements CategoryDao {

	Connection conn =null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	@Override
	//获取所有商品的大类(BroadHeading)的名字（name）
	public ArrayList<PCategory> getPCategory() {
		ArrayList<PCategory> pCategory=null;
		try {
			conn = ConnectionFactory.getConnection();
			String sql = "select id,name from s_p_category";
			pstmt = conn.prepareStatement(sql);
			pCategory = new ArrayList<PCategory>();
			
			rs = pstmt.executeQuery();
			while (rs.next()) {
				PCategory p = new PCategory();
				p.setId(rs.getString(1));
				p.setName(rs.getString(2));
				pCategory.add(p);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			ConnectionFactory.close(conn, pstmt, null, rs);
		}
		
		return pCategory;
		
	}
	@Override
	//通过大类获取每个大类的小类SmallKinds的名字（name）
	//传入一个大类的名字
	public ArrayList<TowPCategory> getTowPCategory(String pCategory) {
		ArrayList<TowPCategory> towPC =null;
		try {
			conn = ConnectionFactory.getConnection();
			String sql = "select two.id,two.name from s_p_category one, s_two_p_category two where one.id = two.c_id and one.name=?";
			pstmt =conn.prepareStatement(sql);
			pstmt.setString(1, pCategory);
			towPC = new ArrayList<TowPCategory>();
			
			rs = pstmt.executeQuery();
			while (rs.next()) {
				TowPCategory two = new TowPCategory();
				two.setId(rs.getString(1));
				two.setName(rs.getString(2));
				towPC.add(two);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			ConnectionFactory.close(conn, pstmt, null, rs);
		}
		return towPC;
	}
	@Override
	//通过每个小类的（name）获取的该类第一个商品的图片地址（image）
	public ArrayList<Product> getPicURL(String towPCategory,int i) {
		ArrayList<Product>  products=null;
		try {
			conn = ConnectionFactory.getConnection();
			String sql = "select two.id,two.image from s_two_p_category one,s_product two where one.id = two.tc_id and one.name = ? ";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, towPCategory);
			products = new ArrayList<Product>();
			
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Product p= new Product();
				p.setId(rs.getString(1));
				p.setImage(rs.getString(2));
				products.add(p);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			ConnectionFactory.close(conn, pstmt, null, rs);
		}
		return products;
	}
	

	

	@Override
	public ArrayList<Product> findById(String id) {
		String sql = "select * from s_product where tc_id = ?";
		conn = ConnectionFactory.getConnection();
		ArrayList<Product> twoProducts = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			twoProducts = new ArrayList<>();
			while(rs.next()){
				Product product = new Product();
				product.setId(rs.getString(1));
				product.setName(rs.getString(2));
				product.setPrice(rs.getDouble(3));
				product.setDescribe(rs.getString(4));
				product.setCount(rs.getInt(5));
				product.setWeight(rs.getString(6));
				product.setImage(rs.getString(7));
				product.setTc_id(rs.getString(8));
				twoProducts.add(product);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			ConnectionFactory.close(conn, pstmt, null, rs);
		}
		return twoProducts;
	}
	
	
	//通过商品id获得对应的商品信息
	@Override
	public Product getProduct(String p_id) {
		// TODO Auto-generated method stub
		Product product=new Product();
		Connection conn=ConnectionFactory.getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="select id,name,price,describe,count,weight,image,tc_id from s_product where id=?";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, p_id);
			rs=pstmt.executeQuery();
			if (rs.next()) {
				product.setId(rs.getString("id"));
				product.setName(rs.getString("name"));
				product.setPrice(rs.getDouble("price"));
				product.setDescribe(rs.getString("describe"));
				product.setCount(rs.getInt("count"));
				product.setWeight(rs.getString("weight"));
				product.setImage(rs.getString("image"));
				product.setTc_id(rs.getString("tc_id"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			ConnectionFactory.close(conn, pstmt, null, rs);
		}
		
		
		return product;
	}
	
	//通过搜索框模糊查询得到相应的商品信息
	@Override
	public ArrayList<Product> findByInput(String input) {
		ArrayList<Product> pro =null;
		try {
			conn = ConnectionFactory.getConnection();
			String sql = "select id,name,price,describe,count,weight,image,tc_id from s_product where name like ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+input+"%");
			pro = new ArrayList<Product>();
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				Product p = new Product();
				p.setId(rs.getString(1));
				p.setName(rs.getString("name"));
				p.setPrice(rs.getDouble("price"));
				p.setDescribe(rs.getString("describe"));
				p.setCount(rs.getInt("count"));
				p.setWeight(rs.getString("weight"));
				p.setImage(rs.getString("image"));
				p.setTc_id(rs.getString("tc_id"));
				pro.add(p);
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			ConnectionFactory.close(conn, pstmt, null, rs);
		}
		
		return pro;
	}
/*	public static void main(String[] args) {
		String a = "1";
		CategoryImpl c = new CategoryImpl();
		System.out.println(c.findByIdAsc(a));
		System.out.println(c.findByIdDesc(a));
	}*/
	
	//通过商品库存数量倒叙
	public ArrayList<Product> getProducts() {
		ArrayList<Product> pros =null;
		try {
			conn = ConnectionFactory.getConnection();
			String sql = "select * from (select * from s_product order by count  asc) where rownum<4";
			pstmt = conn.prepareStatement(sql);
			
			pros = new ArrayList<Product>();
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				Product p = new Product();
				p.setId(rs.getString(1));
				p.setName(rs.getString("name"));
				p.setPrice(rs.getDouble("price"));
				p.setDescribe(rs.getString("describe"));
				p.setCount(rs.getInt("count"));
				p.setWeight(rs.getString("weight"));
				p.setImage(rs.getString("image"));
				p.setTc_id(rs.getString("tc_id"));
				pros.add(p);
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			ConnectionFactory.close(conn, pstmt, null, rs);
		}
		
		return pros;
	}
	
	//价格升序
	public ArrayList<Product> findByInputAsc(String input_text) {
		ArrayList<Product> pro =null;
		try {
			conn = ConnectionFactory.getConnection();
			String sql = "select id,name,price,describe,count,weight,image,tc_id from s_product where name like ? order by price asc";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+input_text+"%");
			pro = new ArrayList<Product>();
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				Product p = new Product();
				p.setId(rs.getString(1));
				p.setName(rs.getString("name"));
				p.setPrice(rs.getDouble("price"));
				p.setDescribe(rs.getString("describe"));
				p.setCount(rs.getInt("count"));
				p.setWeight(rs.getString("weight"));
				p.setImage(rs.getString("image"));
				p.setTc_id(rs.getString("tc_id"));
				pro.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			ConnectionFactory.close(conn, pstmt, null, rs);
		}
		return pro;
	}
	@Override
	//搜索降序
	public ArrayList<Product> findByInputDesc(String input) {
		ArrayList<Product> pro =null;
		try {
			conn = ConnectionFactory.getConnection();
			String sql = "select id,name,price,describe,count,weight,image,tc_id from s_product where name like ? order by price desc";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+input+"%");
			pro = new ArrayList<Product>();
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				Product p = new Product();
				p.setId(rs.getString(1));
				p.setName(rs.getString("name"));
				p.setPrice(rs.getDouble("price"));
				p.setDescribe(rs.getString("describe"));
				p.setCount(rs.getInt("count"));
				p.setWeight(rs.getString("weight"));
				p.setImage(rs.getString("image"));
				p.setTc_id(rs.getString("tc_id"));
				pro.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			ConnectionFactory.close(conn, pstmt, null, rs);
		}
		return pro;
	}
	@Override
	//升序
	public ArrayList<Product> findByIdAsc(String id) {
		ArrayList<Product> pro =null;
		try {
			conn = ConnectionFactory.getConnection();
			String sql = "select id,name,price,describe,count,weight,image,tc_id from s_product where tc_id= ? order by price asc";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pro = new ArrayList<Product>();
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				Product p = new Product();
				p.setId(rs.getString(1));
				p.setName(rs.getString("name"));
				p.setPrice(rs.getDouble("price"));
				p.setDescribe(rs.getString("describe"));
				p.setCount(rs.getInt("count"));
				p.setWeight(rs.getString("weight"));
				p.setImage(rs.getString("image"));
				p.setTc_id(rs.getString("tc_id"));
				pro.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			ConnectionFactory.close(conn, pstmt, null, rs);
		}
		return pro;
	}
	@Override
	//降序
	public ArrayList<Product> findByIdDesc(String id) {
		ArrayList<Product> pro =null;
		try {
			conn = ConnectionFactory.getConnection();
			String sql = "select id,name,price,describe,count,weight,image,tc_id from s_product where tc_id= ? order by price desc";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,id);
			pro = new ArrayList<Product>();
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				Product p = new Product();
				p.setId(rs.getString(1));
				p.setName(rs.getString("name"));
				p.setPrice(rs.getDouble("price"));
				p.setDescribe(rs.getString("describe"));
				p.setCount(rs.getInt("count"));
				p.setWeight(rs.getString("weight"));
				p.setImage(rs.getString("image"));
				p.setTc_id(rs.getString("tc_id"));
				pro.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			ConnectionFactory.close(conn, pstmt, null, rs);
		}
		return pro;
	}
	
	

}
