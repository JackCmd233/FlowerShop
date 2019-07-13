package com.dao;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
@Repository("adminOrderDao")
@Mapper
public interface AdminOrderDao {
	/**
	 * 接口方法对应SQL映射文件AdminOrderMapper.xml中的id
	 */
	public List<Map<String,Object>> orderInfo();
	public int deleteOrderDetail(Integer id);
	public int deleteOrderBase(Integer id);
}
