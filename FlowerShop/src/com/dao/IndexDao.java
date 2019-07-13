package com.dao;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import com.po.Goods;
@Repository("indexDao")
@Mapper
public interface IndexDao {
	public List<Map<String, Object>> getSaleOrder();//��ѯ��������
	public List<Map<String, Object>> getFocusOrder();//��ѯ��������
	public List<Map<String, Object>> selectNotice();//��ѯ����
	public List<Map<String, Object>> getLastedGoods(Goods goods);//������Ʒ
	public Goods selectGoodsById(Integer id);//ͨ��id��ѯ��Ʒ��Ϣ���鿴��Ʒ����ʱ���õ���
	public List<Goods> search(String mykey);//��ҳ�������������ƻ����ͣ�
}
