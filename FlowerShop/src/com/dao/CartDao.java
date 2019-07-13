package com.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository("cartDao")
@Mapper
public interface CartDao {
	public int focus(Map<String, Object> map);//��ע��Ʒ
	public List<Map<String, Object>> isFocus(Map<String, Object> map);//�Ƿ��ע
	public List<Map<String, Object>> isPutCart(Map<String, Object> map);//�Ƿ��Ѽ��빺�ﳵ
	public int putCart(Map<String, Object> map);//���빺�ﳵ
	public int updateCart(Map<String, Object> map);//���¹��ﳵ
	public List<Map<String, Object>> selectCart(Integer id);//��ѯ���ﳵ
	public int deleteAgoods(Map<String, Object> map);//ɾ�����ﳵ
	public int clear(Integer id);//������ﳵ
}
