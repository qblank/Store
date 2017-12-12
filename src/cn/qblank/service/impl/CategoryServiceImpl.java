package cn.qblank.service.impl;

import java.util.ArrayList;

import cn.qblank.model.dao.impl.CategoryImpl;
import cn.qblank.model.entity.PCategory;
import cn.qblank.model.entity.Product;
import cn.qblank.model.entity.TowPCategory;
import cn.qblank.service.CategoryServiceDao;

public class CategoryServiceImpl implements CategoryServiceDao {

	@Override
	public ArrayList<PCategory> getPCategory() {
/*		CategoryDao cd = new CategoryImpl();
		ArrayList<String> list = cd.getPCategory();
		json
		
		if (list!=null&&list.size()>0) {
			return JSONArray.fromObject(list);
			return JSONArray.fromObject(list);
		}
		
		return null;*/
		return new CategoryImpl().getPCategory();
	}

	@Override
	public ArrayList<TowPCategory> getTowPCategory(String pCategory) {
		// TODO Auto-generated method stub
		return new CategoryImpl().getTowPCategory(pCategory);
	}

	@Override
	public ArrayList<Product> getPicURL(String towPCategory,int i) {
		// TODO Auto-generated method stub
		return new CategoryImpl().getPicURL(towPCategory,i);
	}

	@Override
	public ArrayList<Product> findById(String id) {
		return new CategoryImpl().findById(id);
	}

	@Override
	public ArrayList<Product> findByInput(String input) {
		// TODO Auto-generated method stub
		return new CategoryImpl().findByInput(input);
	}

	@Override
	public Product getProduct(String p_id) {
		return new CategoryImpl().getProduct(p_id);
	}


	@Override
	public ArrayList<Product> getProducts() {
		// TODO Auto-generated method stub
		return new CategoryImpl().getProducts();
	}

	public ArrayList<Product> findByInputAsc(String input_text) {
		// TODO Auto-generated method stub
		return new CategoryImpl().findByInputAsc(input_text);
		
	}

	@Override
	public ArrayList<Product> findByInputDesc(String input) {
		// TODO Auto-generated method stub
		return new CategoryImpl().findByInputDesc(input);
	}

	@Override
	public ArrayList<Product> findByIdAsc(String id) {
		// TODO Auto-generated method stub
		return new CategoryImpl().findByIdAsc(id);
	}

	@Override
	public ArrayList<Product> findByIdDesc(String id) {
		// TODO Auto-generated method stub
		return new CategoryImpl().findByIdDesc(id);
	}

}
