package com.czs.entity;

import java.io.Serializable;

import lombok.Data;
/** 
* @ClassName: Role 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author jiayq
* @date 2016年9月20日 上午10:15:29 
*  
*/
@SuppressWarnings("serial")
@Data
public class Role implements Serializable{
	private Long id;
	private String name;//名称
	private String description;//描述
	private String state;//状态
	private String code;//编码
	private Long pid ;//父id
	private String remark;//备注
	//关联资源列表
	private String resources;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Long getPid() {
		return pid;
	}
	public void setPid(Long pid) {
		this.pid = pid;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getResources() {
		return resources;
	}
	public void setResources(String resources) {
		this.resources = resources;
	}
	
	
}
