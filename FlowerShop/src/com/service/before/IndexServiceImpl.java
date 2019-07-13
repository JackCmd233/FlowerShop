package com.service.before;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.dao.AdminNoticeDao;
import com.dao.AdminTypeDao;
import com.dao.IndexDao;
import com.po.Buser;
import com.po.Goods;
import com.po.Notice;

@Service("indexService")
@Transactional
public class IndexServiceImpl implements IndexService{
	@Autowired
	private IndexDao indexDao;
	@Autowired
	private AdminTypeDao adminTypeDao;
	@Autowired
	private AdminNoticeDao adminNoticeDao;
	//首页
	@Override
	public String before(Model model, HttpSession session, Goods goods) {
		session.setAttribute("goodsType", adminTypeDao.selectGoodsType());//把商品类型存入session中
		model.addAttribute("salelist", indexDao.getSaleOrder());//把销售排行存入model中
		model.addAttribute("focuslist", indexDao.getFocusOrder());//把人气排行存入model中
		model.addAttribute("noticelist", indexDao.selectNotice());//把公告存入model中
		if(goods.getId() == null) 
			goods.setId(0);
		model.addAttribute("lastedlist", indexDao.getLastedGoods(goods));//把最新商品存入model中
		return "before/index";
	}
	//去注册
	@Override
	public String toRegister(Model model) {
		model.addAttribute("rbuser", new Buser());
		return "before/register";
	}
	//去登录
	@Override
	public String toLogin(Model model) {
		model.addAttribute("lbuser", new Buser());
		return "before/login";
	}
	//商品详情
	@Override
	public String goodsDetail(Model model, Integer id) {
		Goods goods = indexDao.selectGoodsById(id);
		model.addAttribute("goods", goods);
		return "before/goodsdetail";
	}
	//查询一个公告
	@Override
	public String selectANotice(Model model, Integer id) {
		Notice notice = adminNoticeDao.selectANotice(id);
		model.addAttribute("notice", notice);
		return "admin/noticeDetail";
	}
	//首页搜索
	@Override
	public String search(Model model, String mykey) {
		List<Goods> list = indexDao.search(mykey);
		model.addAttribute("searchlist", list);
		return "before/searchResult";
	}
	
}
