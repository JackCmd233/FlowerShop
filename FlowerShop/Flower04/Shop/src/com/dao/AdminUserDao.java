package com.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import com.po.Buser;
@Repository("adminUserDao")
@Mapper
public interface AdminUserDao {
	/**
	 * 接口方法对应SQL映射文件AdminUserMapper.xml中的id
	 */
	public List<Buser> selectBuser();//查询用户信息
	public List<Buser> selectAllUserByPage(Map<String,Object> map);//分页查询用户信息
	public Buser selectBuserById(Integer id);//根据id查询用户信息
	public int updateuserManager(Integer id);//修改用户状态为限制登录
	public int updateuserManager1(Integer id);//修改用户状态为可登录
}
