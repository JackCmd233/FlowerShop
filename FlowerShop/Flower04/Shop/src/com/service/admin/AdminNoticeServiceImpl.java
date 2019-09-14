package com.service.admin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
		//������Ժ�ת��ɾ��ҳ�棬��ʾ���й���
		return "forward:/adminNotice/deleteNoticeSelect";
	}
	//��ѯ���й�����Ϣ��ʾ��ɾ��ҳ��
	@Override
	public String deleteNoticeSelect(Model model, Integer pageCur) {
		List<Notice> allNotices=adminNoticeDao.deleteNoticeSelect();
		int temp=allNotices.size();//��Ʒ������
		model.addAttribute("totalCount", temp);//����Ʒ��������model��
		int totalPage = 0;//��ҳ��
		if (temp == 0) {
			totalPage = 0;
		} else {
			//���ش��ڻ��ߵ���ָ�����ʽ����С����
			totalPage = (int) Math.ceil((double) temp / 10);
		}
		if (pageCur == null) {
			pageCur = 1;//��ǰҳ
		}
		if ((pageCur - 1) * 10 > temp) {
			pageCur = pageCur - 1;
		}
		//��ҳ��ѯ
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("startIndex", (pageCur - 1) * 10);//��ʼλ��
		map.put("perPageSize", 10);//ÿҳ10��
		allNotices = adminNoticeDao.selectAllNoticesByPage(map);
		model.addAttribute("allNotices", allNotices);
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("pageCur", pageCur);
		return "admin/deleteNoticeSelect";
	}
//	//��ѯһ��������Ϣ
//	@Override
//	public String selectANotice(Model model, Integer id) {
//		model.addAttribute("notice", adminNoticeDao.selectANotice(id));
//		//��ѯ��ת����ϸ����
//		return "admin/noticeDetail";
//	}
	//ɾ������
	@Override
	public String deleteNotice(Integer id) {
		adminNoticeDao.deleteNotice(id);
		//ɾ�����Ժ��ٴ���ת��������Ʒ����
		return "forward:/adminNotice/deleteNoticeSelect";
	}
	//��ѯһ��������Ϣ
	@Override
	public String selectANoticeById(Model model, Integer id,Integer pageCur) {
		model.addAttribute("notice", adminNoticeDao.selectANotice(id));
		model.addAttribute("flag",1);
		//��ת��������Ʒ����
		return "forward:/adminNotice/deleteNoticeSelect?pageCur="+pageCur;
	}

}
