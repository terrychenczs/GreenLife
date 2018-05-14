package com.czs.pojo;

import com.czs.entity.User;
import com.czs.util.BaseParameters;

import lombok.Data;

/**
 * @ClassName: UserParams
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author jiayq
 * @date 2016年9月6日 下午2:24:44
 * 
 */
@Data
public class UserParams extends BaseParameters {
	private String username;// 用户名
	private String workNo;// 工作编号
	private String salt;// 盐(密码安全)
	private Integer age;// 年龄
	private String state;// 状态
	private Long orgId;
	private String pic;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getWorkNo() {
		return workNo;
	}

	public void setWorkNo(String workNo) {
		this.workNo = workNo;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Long getOrgId() {
		return orgId;
	}

	public void setOrgId(Long orgId) {
		this.orgId = orgId;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public UserParams(User user) {
		if (user.getUsername() != null && user.getUsername() != "")
			this.setUsername(user.getUsername());
		if (user.getWorkNo() != null && user.getWorkNo() != "")
			this.setWorkNo(user.getWorkNo());
		if (user.getSalt() != null && user.getSalt() != "")
			this.setSalt(user.getSalt());
		if (user.getAge() != null)
			this.setAge(user.getAge());
		if (user.getState() != null && user.getState() != "")
			this.setState(user.getState());
		if (user.getOrgId() != null)
			this.setOrgId(user.getOrgId());
		if (user.getPic() != null && user.getPic() != "")
			this.setPic(user.getPic());
	}
}
