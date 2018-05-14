package com.czs.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.czs.dao.mapper.RoleResourceMapper;
import com.czs.entity.RoleResource;
import com.czs.service.RoleResourceService;
/** 
* @ClassName: RoleServiceImpl 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author jiayq
* @date 2016年9月19日 下午3:38:55 
*  
*/
@Service("roleResourceService")
public class RoleResourceServiceImpl implements RoleResourceService {
@Resource
private RoleResourceMapper roleResourceMapper;
	@Override
	public void save(RoleResource roleResource) {
		roleResourceMapper.save(roleResource);
	}
}
