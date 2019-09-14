package com.service.before;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.PayDao;
import com.po.pojo.AlipayBean;

@Service("payService")
public class PayServiceImpl implements PayService {
	@Autowired
	private PayDao payDao;
	
	@Override
	public AlipayBean updateOrder(AlipayBean alipayBean) {
		// TODO Auto-generated method stub
		Map<String, Object> map=new HashMap<String, Object>();
		Integer id=Integer.parseInt(alipayBean.getOrderId());
		map.put("id", id);
	    String payway="Ö§¸¶±¦";
	    map.put("payway", payway);
	    payDao.updateOrder(map);
		return alipayBean;
	}

}
