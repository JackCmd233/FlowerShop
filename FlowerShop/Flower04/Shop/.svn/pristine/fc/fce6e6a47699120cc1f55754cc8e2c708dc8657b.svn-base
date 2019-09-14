package com.service.before;

import javax.servlet.http.HttpSession;
import org.springframework.ui.Model;
import com.po.Buser;

public interface UserService {
	public String register(Buser buser, Model model, HttpSession session);//注册

	public String loginin(Buser buser, Model model, HttpSession session);//登录

	public int sendcode(Buser buser, Model model, HttpSession session);//发送验证码

	public String selectuser(Buser buser, Model model, HttpSession session);//查询手机号

	public String backcode(Buser buser, Model model, HttpSession session);//找回密码

}
