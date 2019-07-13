package com.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository("cartDao")
@Mapper
public interface CartDao {
	public int focus(Map<String, Object> map);//关注商品
	public List<Map<String, Object>> isFocus(Map<String, Object> map);//是否关注
	public List<Map<String, Object>> isPutCart(Map<String, Object> map);//是否已加入购物车
	public int putCart(Map<String, Object> map);//加入购物车
	public int updateCart(Map<String, Object> map);//更新购物车
	public List<Map<String, Object>> selectCart(Integer id);//查询购物车
	public int deleteAgoods(Map<String, Object> map);//删除购物车
	public int clear(Integer id);//清除购物车
}
