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
	 * 接口方法对应SQL映射文件AdminGoodsMapper.xml中的id
	 */
	public List<Goods> selectGoods();//查询商品
	public List<Goods> selectAllGoodsByPage(Map<String, Object> map);//分页查询商品
	public Goods selectGoodsById(Integer id);//通过id查询商品信息
	public List<GoodsType> selectGoodsType();//查询商品类型，添加或修改商品时使用
	public Integer addGoods(Goods goods);//添加商品
	public int addGoodsDiscount(@Param("id")Integer id,@Param("price")Double price);//添加商品折扣
	public int updateGoodsById(Goods goods);//修改商品
	public int updateGoodsDiscount(Integer id);//修改商品折扣状态为0
	public int deleteAGoods(Integer id);//删除一个商品
	public int deleteGoods(List<Integer> ids);//删除多个商品
	public int deleteGoodsDiscount(Integer id);//删除一个商品时先删除折扣表中相关数据
	public int deleteGoodsDiscount1(List<Integer> ids);//删除多个商品时先删除折扣表中相关数据
	public List<Map<String, Object>> selectOrderdetailGoods(Integer id);//查询关联商品
}
