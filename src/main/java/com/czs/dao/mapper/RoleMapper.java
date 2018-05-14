package com.czs.dao.mapper;

import java.util.List;
import java.util.Set;

import com.czs.entity.Role;
import com.czs.pojo.RoleParams;

public interface RoleMapper {
	public Long save(Role role);
	public Set<String> loadRoleIdByUsername(String username);
}
