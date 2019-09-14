package com.service.admin;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.dao.AdminOrderDao;
import com.po.pojo.QueryOrder;

@Service("adminOrderService")
@Transactional
public class AdminOrderServiceImpl implements AdminOrderService{
	@Autowired
	private AdminOrderDao adminOrderDao;
	//显示所有订单信息
	@Override
	public String orderInfo(Model model,Integer pageCur) {
		//List<Map<String,Object>> list = adminOrderDao.orderInfo();
		//model.addAttribute("orderList", list);
		List<Map<String,Object>> list=adminOrderDao.orderInfo();
		int temp=list.size();//商品总数量
		//System.out.println("hahsahsh"+temp);
		model.addAttribute("totalCount", temp);//把商品数量存入model中
		int totalPage = 0;//总页数
		if (temp == 0) {
			totalPage = 0;
		} else {
			//返回大于或者等于指定表达式的最小整数
			totalPage = (int) Math.ceil((double) temp / 10);
		}
		if (pageCur == null) {
			pageCur = 1;//当前页
		}
		if ((pageCur - 1) * 10 > temp) {
			pageCur = pageCur - 1;
		}
		//分页查询
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("startIndex", (pageCur - 1) * 10);//起始位置
		map.put("perPageSize", 10);//每页10个
		list = adminOrderDao.selectAllOrdersByPage(map);
		model.addAttribute("orderList", list);
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("pageCur", pageCur);
		return "admin/orderManager";
	}
	
	//根据条件查订单详情
	@Override
	public String orderInfoByFactor(Model model,Integer pageCur,QueryOrder queryOrder) {
		Map<String, Object> map = new HashMap<String, Object>();
		Integer status=Integer.parseInt(queryOrder.getStatus());//转成了int再传的
		String payway=queryOrder.getPayway();
;		map.put("status",status);
		map.put("payway", payway);
		//System.out.println(status);
		//System.out.println(payway);
		String time1=queryOrder.getTime1();
		String time2=queryOrder.getTime2();
//		System.out.println(time1);
//		System.out.println(time2);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
        	if(time1!=null) {
            	Date starttime=sdf.parse(time1);
            	//System.out.println(starttime);
            	map.put("starttime", starttime);
        	}else {
        		map.put("starttime", time1);
        	}
        	if(time2!=null) {
            	Date endtime=sdf.parse(time2);
            	Calendar calendar = new GregorianCalendar(); 
            	calendar.setTime(endtime); 
            	calendar.add(calendar.DATE,1); //把日期往后增加一天,整数  往后推,负数往前移动 
            	endtime=calendar.getTime(); //这个时间就是日期往后推一天的结果 
            	//System.out.println(endtime);
            	map.put("endtime", endtime);
        	}else {
    	        map.put("endtime", time2);
        	}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        //分页查询
        List<Map<String,Object>> list=adminOrderDao.selectOrdersByFactorNum(map);
		int temp=list.size();//商品总数量
		model.addAttribute("totalCount", temp);//把商品数量存入model中
		int totalPage = 0;//总页数
		if (temp == 0) {
			totalPage = 0;
		} else {
			//返回大于或者等于指定表达式的最小整数
			totalPage = (int) Math.ceil((double) temp / 10);
		}
		if (pageCur == null) {
			pageCur = 1;//当前页
		}
		if ((pageCur - 1) * 10 > temp) {
			pageCur = pageCur - 1;
		}
		map.put("startIndex", (pageCur - 1) * 10);//起始位置
		map.put("perPageSize", 10);//每页10个
		
        list = adminOrderDao.selectOrdersByFactor(map);
        model.addAttribute("time1", time1);
        model.addAttribute("time2", time2);
		model.addAttribute("orderList", list);
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("pageCur", pageCur);
		model.addAttribute("status", status);//数据库里的是数字
		model.addAttribute("payway", payway);
		return "admin/orderManager";
	}

}
