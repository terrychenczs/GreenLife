package com.czs.service;

import java.util.List;
import java.util.Set;

import com.czs.entity.Role;
import com.czs.pojo.RoleParams;
/** 
* @ClassName: RoleService 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author jiayq
* @date 2016年9月29日 下午4:16:20 
*  
*/
public interface RoleService {
	public void save(Role  role);
	public Set<String> loadRoleIdByUsername(String username);

}