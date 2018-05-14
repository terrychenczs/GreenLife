package com.czs.pojo;

import com.czs.entity.RoleResource;
import com.czs.util.BaseParameters;

import lombok.Data;
/** 
* @ClassName: RoleResourceParams 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author jiayq
* @date 2016年9月29日 下午4:14:12 
*  
*/
@Data
public class RoleResourceParams extends BaseParameters{
	private Long  roleId;//角色Id
	private Long resourceId;//资源Id
	public RoleResourceParams(RoleResource roleResource) {
		if(roleResource.getRoleId()!=null){
			this.roleId=roleResource.getRoleId();
		}
		if(roleResource.getResourceId()!=null){
			this.resourceId=roleResource.getResourceId();
		}
}
}
