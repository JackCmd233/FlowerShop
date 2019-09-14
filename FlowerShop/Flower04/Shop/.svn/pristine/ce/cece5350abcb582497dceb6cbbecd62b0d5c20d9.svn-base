package com.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.po.Address;

@Repository("addressDao")
@Mapper
public interface AddressDao {
	public Integer addAddress(Address address); //添加地址
	public Integer deleteAddress(Integer id);  //删除地址
	public Integer updateAddress(Address address); //修改地址信息
	public List<Address> selectAllAddress(Integer uid); //通过用户ID查询所有地址
	public List<Address> selectAddress(Address address); //查找指定用户的 指定地址  (传入用户ID和地址ID)
	public Integer getNum(Integer uid);
}
