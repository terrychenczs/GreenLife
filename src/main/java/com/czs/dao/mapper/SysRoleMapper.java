package com.czs.dao.mapper;

import com.czs.entity.Role;
import com.czs.pojo.SysRole;

import java.util.List;
import java.util.Set;

public interface SysRoleMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SysRole record);

    int insertSelective(SysRole record);

    SysRole selectByPrimaryKey(Long id);

    SysRole getRoleByUser(String username);

    int updateByPrimaryKeySelective(SysRole record);

    int updateByPrimaryKey(SysRole record);

    public Long save(Role role);

    public List<SysRole> loadRoleIdByUsername(String username);
}