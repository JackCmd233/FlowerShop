package com.dao;

import java.util.List;
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
	public int addType(String typename);//添加类型
	public int deleteType(Integer id);//删除类型
	public List<Goods> selectGoodsByType(Integer id);//通过类型id查询商品信息
}
