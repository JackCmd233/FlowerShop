package com.service.admin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import com.dao.AdminUserDao;
import com.po.Buser;
import com.po.Goods;
@Service("adminUserService")
@Transactional
public class AdminUserServiceImpl implements AdminUserService{
	@Autowired
	private AdminUserDao adminUserDao;
	@Override
	public String userInfo(Model model, Integer pageCur) {
		//model.addAttribute("userList", adminUserDao.selectBuser());
		List<Buser> userList=adminUserDao.selectBuser();
		int temp=userList.size();//商品总数量
		model.addAttribute("totalCount", temp);//把商品数量存入model中
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
		userList = adminUserDao.selectAllUserByPage(map);
		model.addAttribute("userList", userList);
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("pageCur", pageCur);
		return "admin/userManager";
	}
	//改变用户的账号的状态
	@Override
	public String updateuserManager(Integer id, Model model) {
		Buser buser=adminUserDao.selectBuserById(id);
		System.out.println(buser.getBcanlogin());
		if(buser.getBcanlogin()==1) {//将用户可登录状态改为限制登录
			adminUserDao.updateuserManager(id);
			model.addAttribute("msg", "用户账号状态修改成功！");
		}else {
			adminUserDao.updateuserManager1(id);
			model.addAttribute("msg", "用户账号状态修改成功！");
		}
		return "forward:/adminUser/userInfo";
	}
}
