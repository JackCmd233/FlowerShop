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
	//添加公告
	@Override
	public String addNotice(Notice notice) {
		adminNoticeDao.addNotice(notice);
		//添加了以后转到删除页面，显示所有公告
		return "forward:/adminNotice/deleteNoticeSelect";
	}
	//查询所有公告信息显示在删除页面
	@Override
	public String deleteNoticeSelect(Model model, Integer pageCur) {
		List<Notice> allNotices=adminNoticeDao.deleteNoticeSelect();
		int temp=allNotices.size();//商品总数量
		model.addAttribute("totalCount", temp);//把商品数量存入model中
		int totalPage = 0;//总页数
		if (temp == 0) {
			totalPage = 0;
		} else {
			//返回大于或者等于指定表达式的最小整数
			totalPage = (int) Math.ceil((double) temp / 10);
		}
		if (pageCur == null) {
			pageCur = 1;//当前页
		}
		if ((pageCur - 1) * 10 > temp) {
			pageCur = pageCur - 1;
		}
		//分页查询
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("startIndex", (pageCur - 1) * 10);//起始位置
		map.put("perPageSize", 10);//每页10个
		allNotices = adminNoticeDao.selectAllNoticesByPage(map);
		model.addAttribute("allNotices", allNotices);
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("pageCur", pageCur);
		return "admin/deleteNoticeSelect";
	}
//	//查询一条公告信息
//	@Override
//	public String selectANotice(Model model, Integer id) {
//		model.addAttribute("notice", adminNoticeDao.selectANotice(id));
//		//查询跳转到详细界面
//		return "admin/noticeDetail";
//	}
	//删除公告
	@Override
	public String deleteNotice(Integer id) {
		adminNoticeDao.deleteNotice(id);
		//删除了以后再次跳转到所有商品界面
		return "forward:/adminNotice/deleteNoticeSelect";
	}
	//查询一条公告信息
	@Override
	public String selectANoticeById(Model model, Integer id,Integer pageCur) {
		model.addAttribute("notice", adminNoticeDao.selectANotice(id));
		model.addAttribute("flag",1);
		//跳转到所有商品界面
		return "forward:/adminNotice/deleteNoticeSelect?pageCur="+pageCur;
	}

}
