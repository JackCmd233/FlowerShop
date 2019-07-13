package com.dao;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import com.po.Goods;
@Repository("indexDao")
@Mapper
public interface IndexDao {
	public List<Map<String, Object>> getSaleOrder();//查询销售排行
	public List<Map<String, Object>> getFocusOrder();//查询人气排行
	public List<Map<String, Object>> selectNotice();//查询公告
	public List<Map<String, Object>> getLastedGoods(Goods goods);//最新商品
	public Goods selectGoodsById(Integer id);//通过id查询商品信息（查看商品详情时会用到）
	public List<Goods> search(String mykey);//首页搜索（花的名称或类型）
}
