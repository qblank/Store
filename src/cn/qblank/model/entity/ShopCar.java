package cn.qblank.model.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;


/**
 * 购物车
 * @author Administrator
 *
 */
@SuppressWarnings("serial")
public class ShopCar implements Serializable{
	//存放每一个购物项
	private Map<String, ShopCarItem> itemMap = new HashMap<String,ShopCarItem>();
	//统计价格
	private Double total = 0.0;
	
	
	public Map<String, ShopCarItem> getItemMap() {
		return itemMap;
	}
	public void setItemMap(Map<String, ShopCarItem> itemMap) {
		this.itemMap = itemMap;
	}
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	
	
	/**
	 * 添加到购物车
	 * @param item
	 */
	public boolean addToShopCar(ShopCarItem item){
		//获取到商品的id
		String p_id = item.getProduct().getId();
		//先判断购物车里面是否有值   获取商品的id
		if (itemMap.containsKey(item.getProduct().getId())) {	
			//有商品id
			//修改数量
			ShopCarItem oItem = itemMap.get(p_id);
			
			//将数量增加
			oItem.setCount(oItem.getCount() + item.getCount());
			
			
		}else{
			//无则添加进去
			itemMap.put(p_id, item);
		}
		this.total = getTotalMoney();
		return true;
		
	}
	
	/**
	 * 通过id删除商品
	 * @param p_id
	 */
	public void removeItem(String p_id){
		ShopCarItem removeItem = itemMap.remove(p_id);
		//将商品的价格减去
		this.total -= removeItem.getSubTotal();
		
	}
	
	/**
	 * 清空购物车
	 */
	public void removeAll(){
		itemMap.clear();
		//将total清空为0
		this.total = 0.0;
		
	}
	
	/**
	 * 获取总金额
	 * @return
	 */
	public double  getTotalMoney(){
		double sum = 0.0;
		Collection<ShopCarItem> items = itemMap.values();
		Iterator<ShopCarItem> it = items.iterator();
		while(it.hasNext()){
			ShopCarItem item = it.next();
			sum += item.getSubTotal();
		}
		return sum;
	}
	
	//测试
	/*public static void main(String[] args) {
		ShopCarItem item1 = new ShopCarItem();
		ShopCarItem item2 = new ShopCarItem();
		item1.setProduct(new Product("1", "张三", 34.23, "好东西", 3, "2.5kg", "/images/product/eat/seafood/seafood_1.jpg"));
		item2.setProduct(new Product("2", "李四", 34.23, "好东西", 3, "2.5kg", "/images/product/eat/seafood/seafood_1.jpg"));
		ShopCar shop = new ShopCar();
		shop.addToShopCar(item1);
		shop.addToShopCar(item2);
		System.out.println(shop.total);
		
	}*/
	
	
	
}
