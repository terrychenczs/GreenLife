package com.czs.service;

import com.czs.entity.User;
import com.czs.pojo.SysUser;
import com.czs.pojo.UserParams;

import java.util.List;
  
/**  
* @ClassName: UserService  
* @Description: TODO(这里用一句话描述这个类的作用)  
* @author jiayq 
* @date 2016年9月7日 上午10:09:32  
*   
*/  
public interface UserService {  
  
    public boolean save(User user);  
    public List<User> find(UserParams userParams);
    public boolean getUserByUser(SysUser sysUser);
} 
