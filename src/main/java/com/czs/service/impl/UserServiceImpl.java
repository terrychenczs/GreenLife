package com.czs.service.impl;

import com.czs.dao.mapper.SysUserMapper;
import com.czs.dao.mapper.UserMapper;
import com.czs.dao.mapper.UserRoleMapper;
import com.czs.entity.User;
import com.czs.pojo.SysUser;
import com.czs.pojo.UserParams;
import com.czs.service.UserService;
import com.czs.util.PasswordHelper;
import org.mybatis.spring.MyBatisSystemException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author jiayq
 * @ClassName: UserServiceImpl
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @date 2016年9月6日 上午9:24:49
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;
    @Resource
    private SysUserMapper sysUserMapper;


    @Override
    public boolean save(User user) {
        User u = new PasswordHelper().encryptPassword(user);
        try {
            userMapper.save(u);
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    @Override
    public List<User> find(UserParams userParams) {

        return userMapper.find(userParams);
    }

    @Override
    public boolean getUserByUser(SysUser sysUser) {
       try {
           String username = sysUser.getUsername();
           String phone = sysUser.getPhone();
           String email = sysUser.getEmail();
           if (username != null && phone == null && email == null){
               SysUser usernameResult = sysUserMapper.getUserByUsername(username);
               if (usernameResult == null || usernameResult.equals(null)){
                return true;
               }
           }
           if (username == null && phone != null && email == null){
               SysUser phoneResult = sysUserMapper.getUserByPhone(phone);
               if (phoneResult == null || phoneResult.equals(null)){
                   return true;
               }
           }
           if (username == null && phone == null && email != null){
               SysUser emailResult = sysUserMapper.getUserByEmail(email);
               if (emailResult == null || emailResult.equals(null)){
                   return true;
               }
           }
           return false;
       }catch (MyBatisSystemException e){
           System.out.println("搜索结果大于2条");
           return false;
       }
    }


}
