package com.czs.entity;

import java.io.Serializable;

import lombok.Data;
/** 
* @ClassName: UserRole 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author jiayq
* @date 2016年9月20日 上午10:17:50 
*  
*/
@SuppressWarnings("serial")
@Data
public class UserRole implements Serializable {
	private Long id;
	private Long roleId;//角色id
	private Long userId;//用户id
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
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
	
}
