package com.czs.pojo;

import com.czs.entity.Resource;
import com.czs.util.BaseParameters;
import com.czs.util.OrderByDirection;

import lombok.Data;

/** 
* @ClassName: UserParams 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author jiayq
* @date 2016年9月6日 下午2:24:44 
*  
*/
@Data
public class ResourceParams extends BaseParameters{
	private Long id;
	private String name;//名称
	private String type;
	private Integer leaf;
	private Long priority ;//顺序
	private Long pid;//父id
	private String permission;//权限
	private String status;//状态
	private String url;//路径
	private String outUrl;//站外路径
	private String pic;
	public ResourceParams(Resource resource) {
		this.setOrderBy("priority",OrderByDirection.ASC);
		if(resource.getId()!=null){
			this.id=resource.getId();
		}
		if(resource.getName()!=null&&resource.getName()!=""){
			this.name=resource.getName();
		}
		if(resource.getType()!=null&&resource.getType()!=""){
			this.type=resource.getType();
		}
		if(resource.getPid()!=null){
			this.pid=resource.getPid();
		}
		if(resource.getPriority()!=null){
			this.priority=resource.getPriority();
		}
		if(resource.getPermission()!=null&&resource.getPermission()!=""){
			this.permission=resource.getPermission();
		}
		if(resource.getStatus()!=null&&resource.getStatus()!=""){
			this.status=resource.getStatus();
		}
		if(resource.getUrl()!=null&&resource.getUrl()!=""){
			this.url=resource.getUrl();
		}
		if(resource.getOutUrl()!=null&&resource.getOutUrl()!=""){
			this.outUrl=resource.getOutUrl();
		}
		if(resource.getPic()!=null&&resource.getPic()!=""){
			this.pic=resource.getPic();
		}
		this.leaf=resource.getLeaf();
}
}
