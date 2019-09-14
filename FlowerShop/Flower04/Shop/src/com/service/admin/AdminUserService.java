package com.service.admin;

import org.springframework.ui.Model;

public interface AdminUserService {
	public String userInfo(Model model, Integer pageCur);
	public String updateuserManager(Integer id, Model model);
}
