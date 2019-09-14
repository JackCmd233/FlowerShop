package com.service.admin;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import com.dao.AdminDao;
import com.po.Auser;
@Service("adminService")
@Transactional
public class AdminServiceImpl implements AdminService{
	@Autowired
	private AdminDao adminDao;

	@Override
	public String login(Auser auser, Model model, HttpSession session) {
		if(auser.getAname().equals("")||auser.getApwd().equals("")){
			model.addAttribute("msg", "请输入账号密码！");
			return "admin/login";
		}
		else if(adminDao.login(auser) != null && adminDao.login(auser).size() > 0) {
			session.setAttribute("auser", auser);
			//设置session有效时间为一天
			session.setMaxInactiveInterval(24*60*60);
			//添加商品与修改商品页面使用
			return "admin/main";
		}else {
			model.addAttribute("msg", "用户名或密码错误！");
			return "admin/login";
		}	
	}
}
