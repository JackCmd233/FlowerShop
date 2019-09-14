package com.dao;


import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import com.po.Goods;
import com.po.GoodsType;
import com.po.Notice;
@Repository("indexDao")
@Mapper
public interface IndexDao {
	public List<Map<String, Object>> getSaleOrder();//获取热销商品排行
	public List<Map<String, Object>> getFocusOrder();//获取人气商品排行
	public Goods selectGoodsById(Integer id);//ͨ��id��ѯ��Ʒ��Ϣ���鿴��Ʒ����ʱ���õ���
	public List<Map<String, Object>> search(String mykey);//输入框中查询
	public Notice selectNoticeByid(Integer id);//根据id值查询公告的详情
	public List<GoodsType> getGoodTypes();//获取所有的花的种类
	public List<Map<String, Object>> getGoods(Map<String, Object> map);//查询所有花的数据
	public List<Goods> getInfoBypopularity(Map<String, Object> map);
	public List<Goods> selectInfoBysale(Map<String, Object> map);
	public List<Goods> selectInfoBysale2();
	public List<Map<String, Object>> selectInfo(Map<String, Object> map);//获取花的信息，当点击增加条件的时候
	public List<Goods> getInfoByhot(Map<String, Object> map);//热销商品的全部显示
	public List<Notice> selectNotice();//查询公告
	public List<Map<String, Object>> selectInfosale(Map<String, Object> map);//销量查询
	public Integer gethotpages();//获取热销排行的总页数
	public Integer getfollowpage();//获取关注的总页数
	public Integer selectInfopage(Map<String, Object>map);//所有信息的页数
	public Integer selectInfosalepage(Map<String, Object>map);//页数
	public Integer getGoodpage();
	public List<Map<String, Object>> getAddress(Integer userId);//获取当前用户的地址信息
	public List<Map<String, Object>> selectOrderDetail(Integer orderId);//根据订单编号获取相关的商品数据
	public Map<String, Object> selectAddressOrderDetail(Integer orderId);
	public Float getSum(Integer orderId);
}
