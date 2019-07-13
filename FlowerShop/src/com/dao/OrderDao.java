package com.dao;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import com.po.Order;
@Repository("orderDao")
@Mapper
public interface OrderDao {
	public int addOrder(Order order);//添加订单
	public int addOrderDetail(Map<String, Object> map);//添加订单详情
	public List<Map<String, Object>> selectGoodsShop(Integer uid);//查询商品购买量
	public int updateStore(Map<String, Object> map);//更新库存
	public int clear(Integer uid);//清空购物车
	public int pay(Integer ordersn);//支付订单
}
