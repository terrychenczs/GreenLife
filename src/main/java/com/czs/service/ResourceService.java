package com.czs.service;

import java.util.List;
import java.util.Set;

import com.czs.entity.Resource;
import com.czs.pojo.PidUsernameDTO;
import com.czs.pojo.ResourceParams;
/** 
* @ClassName: ResourceService 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author jiayq
* @date 2016年9月29日 下午4:16:08 
*  
*/
public interface ResourceService {
	public void save(Resource  resource);
	public Set<String> loadPermissionsByUsername(String username);

}
