package com.dao;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository("adminOrderDao")
@Mapper
public interface AdminOrderDao {
	/**
	 * �ӿڷ�����ӦSQLӳ���ļ�AdminOrderMapper.xml�е�id
	 */
	public List<Map<String,Object>> orderInfo();
	public List<Map<String,Object>> selectAllOrdersByPage(Map<String, Object> map);
	public List<Map<String,Object>> selectOrdersByFactor(Map<String, Object> map);
	public List<Map<String,Object>> selectOrdersByFactorNum(Map<String, Object> map);
}