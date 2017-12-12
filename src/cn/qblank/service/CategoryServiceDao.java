package cn.qblank.service;

import java.util.ArrayList;

import cn.qblank.model.entity.PCategory;
import cn.qblank.model.entity.Product;
import cn.qblank.model.entity.TowPCategory;
import net.sf.json.JSONArray;
/**
 * 主页商品分类展示
 * @author Administrator
 *
 */
public interface CategoryServiceDao {

	
		/**
		 * 获取所有商品的大类(BroadHeading)的名字（name）
		 * @return
		 */
		public ArrayList<PCategory> getPCategory();
		
		/**
		 * 通过大类获取每个大类的小类SmallKinds的名字（name）
		 * @param pCategory
		 * @return
		 */
		public ArrayList<TowPCategory> getTowPCategory(String pCategory);
		
		/**
		 * 通过每个小类的（name）获取的该类第一个商品的图片地址（image）
		 * @param towPCategory
		 * @param i
		 * @return
		 */
		public ArrayList<Product> getPicURL(String towPCategory,int i);
		
		/**
		 * 通过商品类的id获取商品的列表
		 * @param id
		 * @return
		 */
		public ArrayList<Product> findById(String id);
		
		/**
		 * 通过商品id获得对应商品信息
		 * @param p_id
		 * @return
		 */
		public abstract Product getProduct(String p_id);
		
		/**
		 * 通过搜索框模糊查询得到相应的商品信息
		 * @param input
		 * @return
		 */
		public ArrayList<Product> findByInput(String input);
		
		/**
		 * 热门商品
		 * @return
		 */
		public abstract ArrayList<Product> getProducts();
		
		/**
		 * 降序
		 * @param input
		 * @return
		 */
		public ArrayList<Product> findByInputAsc(String input);
		
		/**
		 * 搜索升序
		 * @param input
		 * @return
		 */
				public ArrayList<Product> findByInputDesc(String input);
				
				/**
				 * 类降序
				 * @param id
				 * @return
				 */
				public ArrayList<Product> findByIdAsc(String id);
				
				/**
				 * 类降序
				 * @param id
				 * @return
				 */
				public ArrayList<Product> findByIdDesc(String id);

  }
