package com.service.before;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.dao.IndexDao;
import com.po.Buser;
import com.po.Goods;
import com.po.GoodsType;
import com.po.Notice;
import com.sun.org.apache.regexp.internal.recompile;



@Service("indexService")
@Transactional
public class IndexServiceImpl implements IndexService{
	@Autowired
	private IndexDao indexDao;

	//��������
	@Override
	public String toRegister(Model model) {
		model.addAttribute("rbuser", new Buser());
		return "before/register";
	}
	//��������
	@Override
	public String toLogin(Model model) {
		model.addAttribute("lbuser", new Buser());
		return "before/login";
	}
	//������������
	@Override
	public String goodsDetail(Model model, Integer id) {
		Goods goods = indexDao.selectGoodsById(id);
		model.addAttribute("goods", goods);
		return "before/goodsdetail";
	}
//-------------------------������index-------------------------
	//������������
	@Override
	public String index2(Model model) {
		System.out.println(indexDao.selectNotice().size());
		model.addAttribute("salelist", indexDao.getSaleOrder());//��������������������
		model.addAttribute("focuslist", indexDao.getFocusOrder());//������������������
		model.addAttribute("noticelist", indexDao.selectNotice());//������������
		return "before/index2";
	}
	//����id����������������������
	@Override
	public Notice selectANotice(Model model, Integer id) {
		Notice notice = indexDao.selectNoticeByid(id);
		return notice;
	}
	//��������������
	@Override
	public String search2(Model model, int currentIndex) {
		//������������������
		//������������������
		int firstIndex = (currentIndex -1)*8;//数据库中的限制范围的start
		int endIndex  = currentIndex*8;//限制范围的end
 		Map<String, Object> map  = new HashMap<>();
 		map.put("firstIndex", firstIndex);
 		map.put("endIndex", endIndex);
 		
		List<GoodsType> goodsTypes = indexDao.getGoodTypes();
		model.addAttribute("goodsTypes", goodsTypes);
		model.addAttribute("goods", indexDao.getGoods(map));//��������������������������
		System.out.println("--------------2");
		double  page = indexDao.getGoodpage();
		System.out.println("--------------3");
		double pageSize = 8.0;
		model.addAttribute("pages",(int)Math.ceil(page/pageSize));//先上取整需要完全的使用double来才可以实现
		model.addAttribute("id", 3);
		
		return "before/search";
	}
	//������������������
	@Override
	public String search(Model model, String mykey) {
		//������������
		List<GoodsType> goodsTypes = indexDao.getGoodTypes();
		model.addAttribute("goodsTypes", goodsTypes);
		model.addAttribute("goods", indexDao.search(mykey));
		return "before/search";
	}
	//��������������
	@Override
	public String getInfobyhot(Model model,int currentIndex) {
		//获取到当前页数之后
		int firstIndex = (currentIndex -1)*8;//数据库中的限制范围的start
		int endIndex  = currentIndex*8;//限制范围的end
 		Map<String, Object> map  = new HashMap<>();
 		map.put("firstIndex", firstIndex);
 		map.put("endIndex", endIndex);
		
 		List<GoodsType> goodsTypes = indexDao.getGoodTypes();
		model.addAttribute("goodsTypes", goodsTypes);//������������
		model.addAttribute("goods", indexDao.getInfoByhot(map));
		model.addAttribute("currentIndex", currentIndex);
		
		double  page = indexDao.gethotpages();
		double pageSize = 8.0;
		model.addAttribute("pages",(int)Math.ceil(page/pageSize));//先上取整需要完全的使用double来才可以实现
		model.addAttribute("id", 0);
		return "before/search";
	}
	
	
	//��������������
	@Override
	public String getInfobypopularity(Model model,int currentIndex) {
		int firstIndex = (currentIndex -1)*8;//数据库中的限制范围的start
		int endIndex  = currentIndex*8;//限制范围的end
 		Map<String, Object> map  = new HashMap<>();
 		map.put("firstIndex", firstIndex);
 		map.put("endIndex", endIndex);
 		
		List<GoodsType> goodsTypes = indexDao.getGoodTypes();
		model.addAttribute("goodsTypes", goodsTypes);//������������
		model.addAttribute("goods", indexDao.getInfoBypopularity(map));
		
		model.addAttribute("currentIndex", currentIndex);
		double  page = indexDao.getfollowpage();
		double pageSize = 8.0;
		model.addAttribute("pages",(int)Math.ceil(page/pageSize));//先上取整需要完全的使用double来才可以实现
		model.addAttribute("id", 1);
		return "before/search";
	}
	//����������������������
	@Override
	public String selectBysale(Model model, String start, String end) {
		List<GoodsType> goodsTypes = indexDao.getGoodTypes();
		model.addAttribute("goodsTypes", goodsTypes);//������������
		Map<String, Object> map = new HashMap<>();
		map.put("start", start);
		map.put("end", end);
		List<Goods> goods = indexDao.selectInfoBysale(map);
		model.addAttribute("goods", goods);
		return "before/search";
	}
	//��������������������
	@Override
	public String selectByprice2(Model model) {
		List<GoodsType> goodsTypes = indexDao.getGoodTypes();
		model.addAttribute("goodsTypes", goodsTypes);//������������
		model.addAttribute("goods", indexDao.selectInfoBysale2());//����������������
		return "before/search";
	}
	//����������������������������������������������
	@Override
	public Map<String, Object> selectInfo(Model model, Integer search_type, String search_sale, String search_method,int currentIndex) {
		//价格范围
		double pageSize = 8.0;
		double  page = 0;
		Integer start = null;
		Integer end = null;
		List<Goods> goods = new ArrayList<Goods>();
		Map<String, Object> map = new HashMap<String, Object>();//��������������
		Map<String, Object> map2 = new HashMap<String,Object>();//��������
		//��������������������������search_type��������
		if(search_type == -1) {
			search_type = null;
		}
		
		//��������
		if (search_sale.equals("-1")) {
			search_sale = null;
		}else {
			String[] list = search_sale.split("-");//������������
			start = Integer.parseInt(list[0]);//������������
			if(start == 200) {
				end = 100000000;
			}else {
				end = Integer.parseInt(list[1]);
			}
		}
		//个数限制
		int firstIndex = (currentIndex-1)*8;//数据库中的限制范围的start
		int endIndex  = currentIndex*8;//限制范围的end
 		map.put("firstIndex", firstIndex);
 		map.put("endIndex", endIndex);
 		map2.put("currentIndex", currentIndex);
 		
 		
		map.put("search_type", search_type);
		map.put("start", start);
		map.put("end", end);
		
		if(search_method.equals("-1")) {
			search_method = null;
			map.put("search_method", search_method);
			map2.put("goods", indexDao.selectInfo(map));
			page = indexDao.selectInfopage(map);
			map2.put("page",(int)Math.ceil(page/pageSize));
			
		}else if(search_method.equals("sales")) {
			//���������������
			map2.put("goods",  indexDao.selectInfosale(map));
			page = indexDao.selectInfosalepage(map);
			map2.put("page",(int)Math.ceil(page/pageSize));
	}else {
			//��������
			//������������������������������
			map.put("search_method", search_method);
			map2.put("goods",indexDao.selectInfo(map));
			page = indexDao.selectInfopage(map);
			map2.put("page",(int)Math.ceil(page/pageSize));
		}
		
		return map2;
	}
	
	//通过ID获取 商品的类
	@Override
	public Goods getGoods(Integer id) {
		Goods good = indexDao.selectGoodsById(id);
		return good;
	}
	
	//获取用户相关的地址信息
	@Override
	public Map<String, Object> getAddress(HttpServletRequest request ) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session =request.getSession();
		Buser user  =(Buser)session.getAttribute("bruser");
		Integer userId = user.getId();
		List<Map<String, Object>> list = indexDao.getAddress(userId);
		map.put("address", list);
		return map;
	}
	//订单详情显示
	@Override
	public String getOrderDetail(Model model,Integer orderId) {
		//获取订单的id值
		//根据订单的id值获取相关的商品数据
		model.addAttribute("goods", indexDao.selectOrderDetail(orderId));
		//根据订单id值获取相关的地址信息
		model.addAttribute("address", indexDao.selectAddressOrderDetail(orderId));
		return "before/selectOrderDetail";
	}
	//订单支付
	@Override
	public String orderPay(Model model,int orderId) {
		model.addAttribute("amount", indexDao.getSum(orderId));
		model.addAttribute("orderId",orderId);
		return "before/pay";
	}
	
	
	
}



