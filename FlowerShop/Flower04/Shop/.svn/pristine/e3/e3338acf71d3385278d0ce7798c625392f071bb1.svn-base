package com.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import com.po.Notice;
@Repository("adminNoticeDao")
@Mapper
public interface AdminNoticeDao {
	/**
	 * 接口方法对应SQL映射文件AdminNoticMapper.xml中的id
	 */
	public int addNotice(Notice notice);
	public List<Notice> deleteNoticeSelect();
	public List<Notice> selectAllNoticesByPage(Map<String, Object> map);
	public int deleteNotice(Integer id);
	public Notice selectANotice(Integer id);

}
