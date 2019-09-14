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
	//��ʾ���ж�����Ϣ
	@Override
	public String orderInfo(Model model,Integer pageCur) {
		//List<Map<String,Object>> list = adminOrderDao.orderInfo();
		//model.addAttribute("orderList", list);
		List<Map<String,Object>> list=adminOrderDao.orderInfo();
		int temp=list.size();//��Ʒ������
		//System.out.println("hahsahsh"+temp);
		model.addAttribute("totalCount", temp);//����Ʒ��������model��
		int totalPage = 0;//��ҳ��
		if (temp == 0) {
			totalPage = 0;
		} else {
			//���ش��ڻ��ߵ���ָ�����ʽ����С����
			totalPage = (int) Math.ceil((double) temp / 10);
		}
		if (pageCur == null) {
			pageCur = 1;//��ǰҳ
		}
		if ((pageCur - 1) * 10 > temp) {
			pageCur = pageCur - 1;
		}
		//��ҳ��ѯ
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("startIndex", (pageCur - 1) * 10);//��ʼλ��
		map.put("perPageSize", 10);//ÿҳ10��
		list = adminOrderDao.selectAllOrdersByPage(map);
		model.addAttribute("orderList", list);
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("pageCur", pageCur);
		return "admin/orderManager";
	}
	
	//���������鶩������
	@Override
	public String orderInfoByFactor(Model model,Integer pageCur,QueryOrder queryOrder) {
		Map<String, Object> map = new HashMap<String, Object>();
		Integer status=Integer.parseInt(queryOrder.getStatus());//ת����int�ٴ���
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
            	calendar.add(calendar.DATE,1); //��������������һ��,����  ������,������ǰ�ƶ� 
            	endtime=calendar.getTime(); //���ʱ���������������һ��Ľ�� 
            	//System.out.println(endtime);
            	map.put("endtime", endtime);
        	}else {
    	        map.put("endtime", time2);
        	}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        //��ҳ��ѯ
        List<Map<String,Object>> list=adminOrderDao.selectOrdersByFactorNum(map);
		int temp=list.size();//��Ʒ������
		model.addAttribute("totalCount", temp);//����Ʒ��������model��
		int totalPage = 0;//��ҳ��
		if (temp == 0) {
			totalPage = 0;
		} else {
			//���ش��ڻ��ߵ���ָ�����ʽ����С����
			totalPage = (int) Math.ceil((double) temp / 10);
		}
		if (pageCur == null) {
			pageCur = 1;//��ǰҳ
		}
		if ((pageCur - 1) * 10 > temp) {
			pageCur = pageCur - 1;
		}
		map.put("startIndex", (pageCur - 1) * 10);//��ʼλ��
		map.put("perPageSize", 10);//ÿҳ10��
		
        list = adminOrderDao.selectOrdersByFactor(map);
        model.addAttribute("time1", time1);
        model.addAttribute("time2", time2);
		model.addAttribute("orderList", list);
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("pageCur", pageCur);
		model.addAttribute("status", status);//���ݿ����������
		model.addAttribute("payway", payway);
		return "admin/orderManager";
	}

}
