package com.service.before;

import javax.servlet.http.HttpSession;
import org.springframework.ui.Model;
import com.po.Buser;

public interface UserService {
	public String register(Buser buser,Model model, HttpSession session, String code);//ע��
	public String login(Buser buser,Model model, HttpSession session, String code);//��¼
}
