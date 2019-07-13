package com.service.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.dao.AdminNoticeDao;
import com.po.Notice;
@Service("adminNoticeService")
@Transactional
public class AdminNoticeServiceImpl implements AdminNoticeService{
	@Autowired
	private AdminNoticeDao adminNoticeDao;
	//添加公告
	@Override
	public String addNotice(Notice notice) {
		adminNoticeDao.addNotice(notice);
		return "forward:/adminNotice/deleteNoticeSelect";
	}
	//查询所有公告信息显示在删除页面
	@Override
	public String deleteNoticeSelect(Model model) {
		model.addAttribute("allNotices", adminNoticeDao.deleteNoticeSelect());
		return "admin/deleteNoticeSelect";
	}
	//查询一条公告信息
	@Override
	public String selectANotice(Model model, Integer id) {
		model.addAttribute("notice", adminNoticeDao.selectANotice(id));
		return "admin/noticeDetail";
	}
	//删除公告
	@Override
	public String deleteNotice(Integer id) {
		adminNoticeDao.deleteNotice(id);
		return "forward:/adminNotice/deleteNoticeSelect";
	}

}
