package com.dao;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import com.po.Order;
@Repository("orderDao")
@Mapper
public interface OrderDao {
	public int addOrder(Order order);//��Ӷ���
	public int addOrderDetail(Map<String, Object> map);//��Ӷ�������
	public List<Map<String, Object>> selectGoodsShop(Integer uid);//��ѯ��Ʒ������
	public int updateStore(Map<String, Object> map);//���¿��
	public int clear(Integer uid);//��չ��ﳵ
	public int pay(Integer ordersn);//֧������
}
