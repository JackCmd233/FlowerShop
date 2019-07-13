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
	 * 接口方法中对应SQL映射文件AdminGoodsMapper.xml中的id
	 */
	public List<Goods> selectGoods();//查询商品	
	public List<Goods> selectAllGoodsByPage(Map<String, Object> map);//分页查询商品
	public int addGoods(Goods goods);//添加商品
	public Goods selectGoodsById(Integer id);//通过id查询商品信息
	public int deleteGoods(List<Integer> ids);//删除多个商品
	public int deleteAGoods(Integer id);//删除一个商品
	public int updateGoodsById(Goods goods);//修改商品
	//查询关联商品
	public List<Map<String, Object>> selectCartGoods(Integer id);
	public List<Map<String, Object>> selectFocusGoods(Integer id);
	public List<Map<String, Object>> selectOrderdetailGoods(Integer id);
}
