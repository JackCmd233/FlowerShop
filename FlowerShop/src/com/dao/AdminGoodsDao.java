package com.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.po.Goods;
@Repository("adminGoodsDao")
@Mapper
public interface AdminGoodsDao {
	/**
	 * �ӿڷ����ж�ӦSQLӳ���ļ�AdminGoodsMapper.xml�е�id
	 */
	public List<Goods> selectGoods();//��ѯ��Ʒ	
	public List<Goods> selectAllGoodsByPage(Map<String, Object> map);//��ҳ��ѯ��Ʒ
	public int addGoods(Goods goods);//�����Ʒ
	public Goods selectGoodsById(Integer id);//ͨ��id��ѯ��Ʒ��Ϣ
	public int deleteGoods(List<Integer> ids);//ɾ�������Ʒ
	public int deleteAGoods(Integer id);//ɾ��һ����Ʒ
	public int updateGoodsById(Goods goods);//�޸���Ʒ
	//��ѯ������Ʒ
	public List<Map<String, Object>> selectCartGoods(Integer id);
	public List<Map<String, Object>> selectFocusGoods(Integer id);
	public List<Map<String, Object>> selectOrderdetailGoods(Integer id);
}
