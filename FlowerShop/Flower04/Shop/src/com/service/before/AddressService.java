package com.service.before;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


import org.springframework.ui.Model;

import com.po.Address;


public interface AddressService {
	public String addAddress(Model model,HttpServletRequest request,HttpSession session,Address address); // 添加地址

	public String deleteAddress(Model model,HttpServletRequest request,HttpSession session,Integer id); // 删除地址

	public String updateAddress(Model model,HttpServletRequest request,HttpSession session,Address address); // 修改地址信息

	public String selectAllAddress(Model model,HttpSession session); // 通过用户ID查询所有地址

	public String selectAddress(Model model,HttpServletRequest request,HttpSession session); // 查找指定用户的 指定地址 (传入用户ID和地址ID)

}
