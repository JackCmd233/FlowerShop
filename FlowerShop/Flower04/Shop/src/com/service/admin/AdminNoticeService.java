package com.service.admin;

import org.springframework.ui.Model;

import com.po.Notice;

public interface AdminNoticeService {
	public String addNotice(Notice notice);//添加公告
	public String deleteNoticeSelect(Model model, Integer pageCur);//显示所有公告，model用来获得所有公告信息
//	public String selectANotice(Model model, Integer id);//选择一条公告查看详情，model用来获得一条公告信息
	public String selectANoticeById(Model model, Integer id,Integer pageCur);//选择一条公告查看详情，model用来获得一条公告信息
	public String deleteNotice(Integer id);//删除公告
}
