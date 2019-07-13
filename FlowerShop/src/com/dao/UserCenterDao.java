package com.dao;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
@Repository("userCenterDao")
@Mapper
public interface UserCenterDao {
	public List<Map<String, Object>> myOrder(Integer bid);//��ѯ�ҵĶ���
	public List<Map<String, Object>> myFocus(Integer bid);//��ѯ�ҵĹ�ע
	public List<Map<String, Object>> orderDetail(Integer ordersn);//��ѯ��������
}
