package com.czs.util;

import lombok.Data;

/** 
* @ClassName: BaseParameters 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author jiayq
* @date 2016年10月11日 上午10:45:00 
*  
*/
@Data
public class BaseParameters {
/*分页起始记录数*/
private Integer start;
/*当前页码*/
private Integer page;
/*每页显示的记录数*/
private Integer rows;
/*排序字段*/
private String orderBy;
/** 
* @Title: setOrderBy 
* @Description: TODO(设置排序) 
* @param @param columnName
* @param @param dir
* @param @return    设定文件 
* @return BaseParameters    返回类型 
* @throws 
*/
public BaseParameters setOrderBy(String columnName,OrderByDirection dir){
	StringBuilder sort=new StringBuilder();
	if(orderBy!=null&&!(orderBy.trim().equals(""))){
		sort.append(this.orderBy);
		sort.append(",");
	}
	else {
		sort.append("order by ");
	}
	sort.append(columnName);
	sort.append(" ");
	sort.append(dir.toString());
	sort.append(" ");
	this.orderBy=sort.toString();
	return this;
}
}

