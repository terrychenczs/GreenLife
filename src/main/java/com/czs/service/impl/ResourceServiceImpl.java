package com.czs.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.czs.dao.mapper.ResourceMapper;
import com.czs.entity.Resource;
import com.czs.pojo.PidUsernameDTO;
import com.czs.pojo.ResourceParams;
import com.czs.service.ResourceService;

/**
 * @ClassName: ResourceServiceImpl
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author jiayq
 * @date 2016年9月19日 下午3:38:55
 * 
 */
@Service("resourceService")
public class ResourceServiceImpl implements ResourceService {
	private static final Logger logger = Logger.getLogger(ResourceServiceImpl.class);
	@javax.annotation.Resource
	private ResourceMapper resourceMapper;

	@Override
	public void save(com.czs.entity.Resource resource) {
		resourceMapper.save(resource);
	}

	@Override
	public Set<String> loadPermissionsByUsername(String username) {
		List<Resource> resList=resourceMapper.loadPermissionsByUsername(username);
		Set<String> set=new HashSet<String>();
		StringBuffer sb=new StringBuffer();
		for(Resource resource:resList){
			if(resource.getPermission()!=null&& resource.getPermission().length() > 0){
				set.add(resource.getPermission());	
				sb.append("["+resource.getPermission()+"]");
			}
		}
		logger.info("[用户权限]："+sb);
		return set;
	}
}
