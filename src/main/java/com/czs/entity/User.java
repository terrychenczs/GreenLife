package com.czs.entity;

import java.io.Serializable;  
import java.util.List;  
  
import lombok.Data;  
/**  
* @ClassName: User  
* @Description: TODO(这里用一句话描述这个类的作用)  
* @author jiayq 
* @date 2016年9月5日 下午2:31:58  
*   
*/  
@SuppressWarnings("serial")  
@Data  
public class User implements Serializable {  
    private Long id;  
    private String username;// 用户名  
    private String workNo;// 工作编号  
    private String salt;// 盐(密码安全)  
    private String password;// 密码  
    private Integer age;// 年龄  
    private String state;// 状态  
    private Long orgId;  
    private String pic;  
    private String phone;  
    private String address;  
    private String email;  
    private Integer percent;  
    /** 
     * @Title: getCredentialsSalt 
     * @Description: salt = salt + username 
     * @param @return 设定文件 
     * @return String 返回类型 
     * @author jiayq 
     * @throws 
     */  
    public String getCredentialsSalt() {  
        return username + salt;  
    }
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getPercent() {
		return percent;
	}
	public void setPercent(Integer percent) {
		this.percent = percent;
	}  
    
}  