package com.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.po.Order;

@Repository("userCenterDao")
@Mapper
public interface UserCenterDao {
	public String myFocus(Integer id);//查询我的关注
	public Map<String, Object> myFocusMessage(Integer id);//查询我的关注的商品详情
	public void deleteFocus(Map<String, Object> map);//删除关注
	public String selectPassword(Integer id);//查询密码
	public int updateUserPassword(@Param("id")Integer id,@Param("newpassword")String newpasssword,@Param("oldpassword")String oldpassword);//修改用户密码
	public List<Order> showPayOrder(Integer id);//查看所有已付款订单
	public List<Order> showPayOrderByPage(Map<String, Object> map);//查看分页已付款订单
	public void deleteOrders(Integer id);//删除订单
	public List<Order> showNoPayOrder(Integer id);//查看所有未付款订单
	public List<Order> showNoPayOrderByPage(Map<String, Object> map);//查看分页未付款订单
	public void deleteFocusNum(Integer id);//该商品关注数减1
	public List<Map<String, Object>> selectGoods(Integer id);//查询该订单的商品和购买数量
	public void changeGstore(Map<String, Object> map);//释放库存
}

