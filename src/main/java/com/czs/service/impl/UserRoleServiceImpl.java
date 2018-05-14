package com.czs.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.czs.dao.mapper.UserRoleMapper;
import com.czs.entity.Role;
import com.czs.entity.User;
import com.czs.entity.UserRole;
import com.czs.service.UserRoleService;
@Service("userRoleService")
public class UserRoleServiceImpl implements UserRoleService {
@Resource
private UserRoleMapper userRoleMapper;
	@Override
	public List<UserRole> loadByUsername(String username) {
		return userRoleMapper.loadByUsername(username);
	}

	@Override
	public void save(UserRole userRole) {
		userRoleMapper.save(userRole);
	}

}
