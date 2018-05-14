package com.czs.dao.mapper;

import com.czs.entity.User;
import com.czs.pojo.UserParams;

import java.util.List;

/** 
* @ClassName: UserMapper 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author jiayq
* @date 2016年9月29日 下午4:08:43 
*  
*/
public interface UserMapper {
	public void save(User user);
	public List<User> find(UserParams userParams);
}
