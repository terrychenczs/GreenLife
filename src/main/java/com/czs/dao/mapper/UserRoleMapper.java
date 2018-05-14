package com.czs.dao.mapper;

import java.util.List;

import com.czs.entity.Role;
import com.czs.entity.User;
import com.czs.entity.UserRole;
/** 
* @ClassName: UserRoleMapper 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author jiayq
* @date 2016年9月29日 下午4:08:50 
*  
*/
public interface UserRoleMapper {
	public List<UserRole> loadByUsername(String username);
	public void save(UserRole userRole);
}
