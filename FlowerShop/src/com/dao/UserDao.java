package com.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import com.po.Buser;
@Repository("userDao")
@Mapper
public interface UserDao {
	public int register(Buser buser);//×¢²á
	public List<Buser> login(Buser buser);//µÇÂ¼
}
