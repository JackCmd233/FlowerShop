package com.service.admin;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import com.dao.AdminDao;
import com.dao.AdminTypeDao;
import com.po.Auser;
@Service("adminService")
@Transactional
public class AdminServiceImpl implements AdminService{
	@Autowired
	private AdminDao adminDao;
	@Autowired
	private AdminTypeDao adminTypeDao;
	@Override
	public String login(Auser auser, Model model, HttpSession session) {
		if(auser.getAname().equals("")||auser.getApwd().equals("")){
			return "admin/login";
		}
		else if(adminDao.login(auser) != null && adminDao.login(auser).size() > 0) {
			session.setAttribute("auser", auser);
			//添加商品与修改商品页面使用
			session.setAttribute("goodsType", adminTypeDao.selectGoodsType());
			return "admin/main";
		}else {
			model.addAttribute("msg", "用户名或密码错误！");
			return "admin/login";
		}	
	}
}
