package com.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import com.po.Goods;
import com.po.GoodsType;
@Repository("adminTypeDao")
@Mapper
public interface AdminTypeDao {
	/**
	 * 接口方法对应SQL映射文件AdminTypeMapper.xml中的id
	 */
	public List<GoodsType> selectGoodsType();//查询类型信息
	public List<GoodsType> selectAllTypeByPage(Map<String,Object> map);//分页查询商品类型
	public int addType(GoodsType goodsType);//添加类型
	public int deleteDiscount(Integer tid);//删除类型前先把与商品有关的折扣删除
	public int deleteGoods(Integer tid);//删除类型前先删除与类型商品
	public int deleteType(Integer tid);//删除类型
	public List<Goods> selectTypeById(Integer id);//通过类型id查询商品类型信息
}
