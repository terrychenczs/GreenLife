package com.czs.service;

import java.util.List;
import java.util.Set;

import com.czs.entity.Role;
import com.czs.pojo.RoleParams;
import com.czs.pojo.SysRole;
import com.czs.pojo.SysUser;

/**
* @ClassName: RoleService 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author jiayq
* @date 2016年9月29日 下午4:16:20 
*  
*/
public interface RoleService {
	public void save(Role  role);
	public List<SysRole> loadRoleIdByUsername(String username);
	public SysRole getRoleByUser(String username);
}
