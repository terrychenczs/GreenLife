package com.czs.dao.mapper;

import com.czs.pojo.SysRoleResource;

public interface SysRoleResourceMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SysRoleResource record);

    int insertSelective(SysRoleResource record);

    SysRoleResource selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysRoleResource record);

    int updateByPrimaryKey(SysRoleResource record);
}