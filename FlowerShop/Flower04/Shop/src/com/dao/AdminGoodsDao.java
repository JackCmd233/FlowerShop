package com.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.po.Goods;
import com.po.GoodsType;

@Repository("adminGoodsDao")
@Mapper
public interface AdminGoodsDao {
	/**
	 * �ӿڷ�����ӦSQLӳ���ļ�AdminGoodsMapper.xml�е�id
	 */
	public List<Goods> selectGoods();//��ѯ��Ʒ
	public List<Goods> selectAllGoodsByPage(Map<String, Object> map);//��ҳ��ѯ��Ʒ
	public Goods selectGoodsById(Integer id);//ͨ��id��ѯ��Ʒ��Ϣ
	public List<GoodsType> selectGoodsType();//��ѯ��Ʒ���ͣ���ӻ��޸���Ʒʱʹ��
	public Integer addGoods(Goods goods);//�����Ʒ
	public int addGoodsDiscount(@Param("id")Integer id,@Param("price")Double price);//�����Ʒ�ۿ�
	public int updateGoodsById(Goods goods);//�޸���Ʒ
	public int updateGoodsDiscount(Integer id);//�޸���Ʒ�ۿ�״̬Ϊ0
	public int deleteAGoods(Integer id);//ɾ��һ����Ʒ
	public int deleteGoods(List<Integer> ids);//ɾ�������Ʒ
	public int deleteGoodsDiscount(Integer id);//ɾ��һ����Ʒʱ��ɾ���ۿ۱����������
	public int deleteGoodsDiscount1(List<Integer> ids);//ɾ�������Ʒʱ��ɾ���ۿ۱����������
	public List<Map<String, Object>> selectOrderdetailGoods(Integer id);//��ѯ������Ʒ
}
