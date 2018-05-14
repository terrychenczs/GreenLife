package com.czs.pojo;

import com.czs.entity.Resource;

import lombok.Data;

/** 
* @ClassName: PidUsernameDTO 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author jiayq
* @date 2016年9月29日 下午4:13:27 
*  
*/
@Data
public class PidUsernameDTO{
	private Long pid;//resource pid
	private String username;//用户名
	private Integer leaf;//判断是否为叶子节点
	public PidUsernameDTO(Long pid, String username,Resource resource) {
		super();
		this.pid = pid;
		this.username = username;
		this.leaf=resource.getLeaf();
	}
}
