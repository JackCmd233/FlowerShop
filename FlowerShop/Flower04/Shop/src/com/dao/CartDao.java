package com.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.po.Order;

@Repository("cartDao")
@Mapper
public interface CartDao {
	public int focus(Map<String, Integer> map);//��ע��Ʒ
	public String isFocus(int uid);//�Ƿ��ע
	public int focusNum(int uid); //��ע����������һ��
	public int orderConfirm(Order order); //�µ�,���ǻ�û��֧��
	public int orderDetail(Map<String, Object> map); //�µ�,���ǻ�û��֧��
	public List<Integer> getBaseId(int uid);
	public int updateInventory(Map<String, Object>map) ;
}