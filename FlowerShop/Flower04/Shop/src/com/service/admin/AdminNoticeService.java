package com.service.admin;

import org.springframework.ui.Model;

import com.po.Notice;

public interface AdminNoticeService {
	public String addNotice(Notice notice);//��ӹ���
	public String deleteNoticeSelect(Model model, Integer pageCur);//��ʾ���й��棬model����������й�����Ϣ
//	public String selectANotice(Model model, Integer id);//ѡ��һ������鿴���飬model�������һ��������Ϣ
	public String selectANoticeById(Model model, Integer id,Integer pageCur);//ѡ��һ������鿴���飬model�������һ��������Ϣ
	public String deleteNotice(Integer id);//ɾ������
}
