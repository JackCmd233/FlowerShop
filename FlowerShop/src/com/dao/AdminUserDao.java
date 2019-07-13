package com.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import com.po.Buser;
@Repository("adminUserDao")
@Mapper
public interface AdminUserDao {
	/**
	 * 接口方法对应SQL映射文件AdminUserMapper.xml中的id
	 */
	public List<Buser> userInfo();
	public int deleteuserManager(Integer id);
}
