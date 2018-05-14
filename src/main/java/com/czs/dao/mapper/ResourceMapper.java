package com.czs.dao.mapper;

import java.util.List;
import java.util.Set;

import com.czs.entity.Resource;
import com.czs.pojo.PidUsernameDTO;
import com.czs.pojo.ResourceParams;

public interface ResourceMapper {
	public void save(Resource resource);
	public List<Resource> loadPermissionsByUsername(String username);
	
}
