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
	//��ӹ���
	@Override
	public String addNotice(Notice notice) {
		adminNoticeDao.addNotice(notice);
		return "forward:/adminNotice/deleteNoticeSelect";
	}
	//��ѯ���й�����Ϣ��ʾ��ɾ��ҳ��
	@Override
	public String deleteNoticeSelect(Model model) {
		model.addAttribute("allNotices", adminNoticeDao.deleteNoticeSelect());
		return "admin/deleteNoticeSelect";
	}
	//��ѯһ��������Ϣ
	@Override
	public String selectANotice(Model model, Integer id) {
		model.addAttribute("notice", adminNoticeDao.selectANotice(id));
		return "admin/noticeDetail";
	}
	//ɾ������
	@Override
	public String deleteNotice(Integer id) {
		adminNoticeDao.deleteNotice(id);
		return "forward:/adminNotice/deleteNoticeSelect";
	}

}
