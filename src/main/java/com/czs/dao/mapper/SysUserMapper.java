package com.czs.dao.mapper;

import com.czs.pojo.SysUser;

public interface SysUserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SysUser record);

    int insertSelective(SysUser record);

    SysUser selectByPrimaryKey(Long id);

    SysUser getUserByUsername(String string);

    SysUser getUserByPhone(String string);

    SysUser getUserByEmail(String string);

    int updateByPrimaryKeySelective(SysUser record);

    int updateByPrimaryKey(SysUser record);
}