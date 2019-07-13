package com.dao;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
@Repository("userCenterDao")
@Mapper
public interface UserCenterDao {
	public List<Map<String, Object>> myOrder(Integer bid);//查询我的订单
	public List<Map<String, Object>> myFocus(Integer bid);//查询我的关注
	public List<Map<String, Object>> orderDetail(Integer ordersn);//查询订单详情
}
