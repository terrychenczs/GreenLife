package com.czs.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;
/** 
* @ClassName: Resource 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author jiayq
* @date 2016年9月19日 下午4:57:11 
*  
*/
@SuppressWarnings("serial")
@Data
public class Resource implements Serializable{
	private Long id;
	private String name;//名称
	//private ResourceType type = ResourceType.menu;//资源类型
	private String type;
	private Integer leaf;//0表示是叶子节点
	private Long priority;//顺序
	private Long pid;//父id
	private String permission;//权限
	private String status;//状态
	private String url;//路径
	private String outUrl;//站外路径
	private String pic;
	//关联的角色列表
	private List<Role> roles;
	private List<Resource> children = new ArrayList<Resource>();
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Integer getLeaf() {
		return leaf;
	}
	public void setLeaf(Integer leaf) {
		this.leaf = leaf;
	}
	public Long getPriority() {
		return priority;
	}
	public void setPriority(Long priority) {
		this.priority = priority;
	}
	public Long getPid() {
		return pid;
	}
	public void setPid(Long pid) {
		this.pid = pid;
	}
	public String getPermission() {
		return permission;
	}
	public void setPermission(String permission) {
		this.permission = permission;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getOutUrl() {
		return outUrl;
	}
	public void setOutUrl(String outUrl) {
		this.outUrl = outUrl;
	}
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	public List<Resource> getChildren() {
		return children;
	}
	public void setChildren(List<Resource> children) {
		this.children = children;
	}
	
}
