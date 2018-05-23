package com.czs.service.impl;

import java.util.Set;

import com.czs.dao.mapper.SysRoleMapper;
import com.czs.pojo.SysRole;

import org.springframework.stereotype.Service;

import com.czs.dao.mapper.ResourceMapper;
import com.czs.dao.mapper.RoleMapper;
import com.czs.dao.mapper.RoleResourceMapper;
import com.czs.entity.Role;
import com.czs.service.RoleService;

/**
 * @author jiayq
 * @ClassName: RoleServiceImpl
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @date 2016年9月19日 下午3:38:55
 */
@Service("roleService")
public class RoleServiceImpl implements RoleService {
    @javax.annotation.Resource
    private RoleMapper roleMapper;
    @javax.annotation.Resource
    private SysRoleMapper sysRoleMapper;

    @Override
    public void save(Role role) {
        roleMapper.save(role);
    }

    @Override
    public Set<String> loadRoleIdByUsername(String username) {
        // TODO Auto-generated method stub
        return roleMapper.loadRoleIdByUsername(username);
    }

    @Override
    public SysRole getRoleByUser(String username) {
        SysRole sysRole = sysRoleMapper.getRoleByUser(username);
        return sysRole;
    }
}
