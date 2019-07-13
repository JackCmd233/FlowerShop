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
	//��ҳ
	@Override
	public String before(Model model, HttpSession session, Goods goods) {
		session.setAttribute("goodsType", adminTypeDao.selectGoodsType());//����Ʒ���ʹ���session��
		model.addAttribute("salelist", indexDao.getSaleOrder());//���������д���model��
		model.addAttribute("focuslist", indexDao.getFocusOrder());//���������д���model��
		model.addAttribute("noticelist", indexDao.selectNotice());//�ѹ������model��
		if(goods.getId() == null) 
			goods.setId(0);
		model.addAttribute("lastedlist", indexDao.getLastedGoods(goods));//��������Ʒ����model��
		return "before/index";
	}
	//ȥע��
	@Override
	public String toRegister(Model model) {
		model.addAttribute("rbuser", new Buser());
		return "before/register";
	}
	//ȥ��¼
	@Override
	public String toLogin(Model model) {
		model.addAttribute("lbuser", new Buser());
		return "before/login";
	}
	//��Ʒ����
	@Override
	public String goodsDetail(Model model, Integer id) {
		Goods goods = indexDao.selectGoodsById(id);
		model.addAttribute("goods", goods);
		return "before/goodsdetail";
	}
	//��ѯһ������
	@Override
	public String selectANotice(Model model, Integer id) {
		Notice notice = adminNoticeDao.selectANotice(id);
		model.addAttribute("notice", notice);
		return "admin/noticeDetail";
	}
	//��ҳ����
	@Override
	public String search(Model model, String mykey) {
		List<Goods> list = indexDao.search(mykey);
		model.addAttribute("searchlist", list);
		return "before/searchResult";
	}
	
}
