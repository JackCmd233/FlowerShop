package com.dao;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository("payDao")
@Mapper
public interface PayDao {
	public void updateOrder(Map<String, Object> map);
}
