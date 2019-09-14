package com.service.before;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;


import org.springframework.ui.Model;

import com.po.Goods;
import com.po.Notice;


public interface IndexService {

	public String goodsDetail(Model model,Integer id);//商品详情
	public String index2(Model model);//首页界面显示
	public String search2(Model model, int currentIndex);//查询页面
	public String search(Model model, String mykey);
	public String getInfobyhot(Model model,int currentIndex);//currentIndex当前的页面
	public String getInfobypopularity(Model model,int currentIndex);
	public String selectBysale(Model model, String start, String end);
	public String selectByprice2(Model model);
	public Map<String, Object> selectInfo(Model model, Integer search_type, String search_sale, String search_method,int currentIndex);//后端接收到前端的数据之后向前端返回相关的数据
	public String toLogin(Model model);//登录页面
	public Notice selectANotice(Model model, Integer id);//根据Id值获取公告
	public String toRegister(Model model);//注册接口
	public Goods getGoods(Integer id);
	public Map<String, Object> getAddress(HttpServletRequest request);
	public String getOrderDetail(Model model,Integer id);
	public String orderPay(Model model,int orderId);//订单支付
}
