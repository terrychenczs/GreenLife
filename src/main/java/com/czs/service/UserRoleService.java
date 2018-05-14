package com.czs.service;

import java.util.List;
import java.util.Set;

import com.czs.entity.Role;
import com.czs.entity.User;
import com.czs.entity.UserRole;
/** 
* @ClassName: UserRoleService 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author jiayq
* @date 2016年9月29日 下午4:16:27 
*  
*/
public interface UserRoleService {
	public List<UserRole> loadByUsername(String username);
	public void save(UserRole userRole);
}
