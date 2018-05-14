package com.czs.pojo;

import com.czs.entity.Role;
import com.czs.util.BaseParameters;

import lombok.Data;
/** 
* @ClassName: RoleParams 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author jiayq
* @date 2016年9月29日 下午4:13:57 
*  
*/
@Data
public class RoleParams extends BaseParameters{
	private String name;//名称
	private String description;//描述
	private String state;//状态
	private String code;//编码
	private Long pid;//父id
	private String remark;//备注
	//关联资源列表
	private String resources;
	public RoleParams(Role role) {
		if(role.getName()!=null&&role.getName()!=""){
			this.name=role.getName();
		}
		if(role.getDescription()!=null&&role.getDescription()!=""){
			this.description=role.getDescription();
		}
		if(role.getState()!=null&&role.getState()!=""){
			this.state=role.getState();
		}
		if(role.getCode()!=null&&role.getCode()!=""){
			this.code=role.getCode();
		}
		if(role.getPid()!=null){
			this.pid=role.getPid();
		}
		if(role.getRemark()!=null&&role.getRemark()!=""){
			this.remark=role.getRemark();
		}
}
	public RoleParams(){
		
	}
}
