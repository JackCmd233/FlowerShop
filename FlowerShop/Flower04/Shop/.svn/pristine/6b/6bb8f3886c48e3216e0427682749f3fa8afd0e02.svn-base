package com.service.admin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.dao.AdminTypeDao;
import com.po.Goods;
import com.po.GoodsType;
import com.util.PageUtil;

@Service("adminTypeService")
@Transactional
public class AdminTypeServiceImpl implements AdminTypeService {
	@Autowired
	private AdminTypeDao adminTypeDao;
	
	//查询商品类型
	@Override
	public String selectGoodsType(Model model, Integer pageCur,String act) { 
		List<GoodsType> allGoodsType=adminTypeDao.selectGoodsType();
		int temp=allGoodsType.size();//商品类型总数量
		model.addAttribute("totalCount", temp);//把商品类型数量存入model中
		int totalPage = 0;//总页数
		if (temp == 0) {
			totalPage = 0;
		} else {
			//返回大于或者等于指定表达式的最小整数
			totalPage = (int) Math.ceil((double) temp / 20);
		}
		if (pageCur == null) {
			pageCur = 1;//当前页
		}
		if ((pageCur - 1) * 20 > temp) {
			pageCur = pageCur - 1;
		}
		//分页查询
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("startIndex", (pageCur - 1) * 20);//起始位置
		map.put("perPageSize", 20);//每页20个
		allGoodsType = adminTypeDao.selectAllTypeByPage(map);
		model.addAttribute("allGoodsType", allGoodsType);
		model.addAttribute("totalPage", totalPage); 
		model.addAttribute("pageCur", pageCur);
		//删除查询
		if("deleteSelect".equals(act)){
			return "admin/deleteType";
		}else {
			return "admin/showType"; 
		}
		
	}
	
	//添加商品类型
	@Override
	public String addType(GoodsType goodsType,Model model) {
		adminTypeDao.addType(goodsType);
		return "forward:/adminType/selectGoodsType";
	}
	
	//删除商品类型
	@Override
	public String deleteAGoodsType(Integer tid,Model model) {
		adminTypeDao.deleteDiscount(tid);
		adminTypeDao.deleteGoods(tid);
		adminTypeDao.deleteType(tid);
		model.addAttribute("msg", "成功删除商品类型以及与它有关的商品！");
		return "forward:/adminType/selectGoodsType?act=deleteSelect"; 	 
	}
}
