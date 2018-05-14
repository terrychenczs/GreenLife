package com.czs.entity;

import java.io.Serializable;

import lombok.Data;

/** 
* @ClassName: RoleResource 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author jiayq
* @date 2016年9月20日 上午10:16:57 
*  
*/
@Data
public class RoleResource implements Serializable{
	private Long id;
	private Long roleId;//角色id
	private Long resourceId;//资源id
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getRoleId() {
		return roleId;
	}
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}
	public Long getResourceId() {
		return resourceId;
	}
	public void setResourceId(Long resourceId) {
		this.resourceId = resourceId;
	}
	
}
