package com.czs.controller;  
  
  
import javax.annotation.Resource;  
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.czs.enums.UserTypeEnum;
import com.czs.pojo.SysRole;
import com.czs.service.RoleService;
import com.czs.util.jsonUtil.Entity.ListObject;
import com.czs.util.jsonUtil.Entity.StatusMsg;
import com.czs.util.jsonUtil.JsonUtils;
import com.czs.util.jsonUtil.ResponseUtils;
import com.czs.util.jsonUtil.Entity.StatusCode;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;  
import org.apache.shiro.authc.ExcessiveAttemptsException;  
import org.apache.shiro.authc.IncorrectCredentialsException;  
import org.apache.shiro.authc.UnknownAccountException;  
import org.apache.shiro.authc.UsernamePasswordToken;  
import org.apache.shiro.subject.Subject;  
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.czs.service.UserService;

import java.util.ArrayList;
import java.util.List;

/**
* @ClassName: LoginController  
* @Description: TODO(登录controller)  
* @author jiayq 
* @date 2016年9月5日 下午5:06:33  
*   
*/  
@Controller  
@RequestMapping("/")  
public class LoginController {  
    @Resource  
    private UserService userService;

    @Resource
    private RoleService roleService;
    /**  
    * @Title: loginView  
    * @Description: TODO(转向登录界面)  
    * @param @return    设定文件  
    * @return String    返回类型  
    * @throws  
    */  
    @RequestMapping(value = "/login")  
    public String loginView(){  
        return "login";  
    }  
    @RequestMapping(value = "/unauthorized")  
    public String unauthorized(){  
        return "unauthorized";  
    }  
  
    /**  
    * @Title: login1  
    * @Description: TODO(shiro+EndecryptUtils进行认证)  
    * @param @param request 
    * @param @param model 
    * @param @param username 
    * @param @param password 
    * @param @return    设定文件  
    * @return String    返回类型  
    * @throws  
    */  
    @RequestMapping(value = "/loginTest")  
    public void login(HttpServletRequest request,  HttpServletResponse response,Model model, String username, String password, boolean rememberMe) {
        System.out.println("rememberMe:"+rememberMe);  
        //将form中的用户名密码传入Realm 的doGetAuthenticationInfo  
        UsernamePasswordToken token = new UsernamePasswordToken(username, password.toCharArray());  
        token.setRememberMe(rememberMe);  
        Subject currentUser = SecurityUtils.getSubject();
        //List<SysRole> roleList = new ArrayList<SysRole>();
        //SysRole sysRole = roleService.getRoleByUser(username);
        //String error = "";
        try {  
            currentUser.login(token);
        } catch (UnknownAccountException ex) {// 用户名没有找到
            ListObject listObject = new ListObject();
            listObject.setCode(StatusCode.USER_NOT_EXIST);
            listObject.setMsg("您输入的用户名不存在！");
            ResponseUtils.renderJson(response, JsonUtils.toJson(listObject));
        } catch (IncorrectCredentialsException ex) {// 用户名密码不匹配
            ListObject listObject = new ListObject();
            listObject.setCode(StatusCode.USERNAME_AND_PASSWORD_MISMATCH);
            listObject.setMsg("用户名密码不匹配 ！");
            ResponseUtils.renderJson(response, JsonUtils.toJson(listObject));
        } catch(ExcessiveAttemptsException e){
            ListObject listObject = new ListObject();
            listObject.setCode(StatusCode.USERNAME_LOCKED);
            listObject.setMsg("密码错误次数已超五次，账号锁定1小时！");
           ResponseUtils.renderJson(response, JsonUtils.toJson(listObject));
        } catch (AuthenticationException ex) {// 其他的登录错误
            ListObject listObject = new ListObject();
            listObject.setCode(StatusCode.CODE_ERROR_PROGRAM);
            listObject.setMsg("其他的登录错误  ！");
           ResponseUtils.renderJson(response, JsonUtils.toJson(listObject));
            ex.printStackTrace();
        }  
        // 验证是否成功登录的方法
        if (currentUser.isAuthenticated()) {
            ListObject listObject = new ListObject();
            listObject.setCode(StatusCode.CODE_SUCCESS);
            listObject.setMsg(StatusMsg.CODE_SUCCESS);
            //判断当前登录用户的类型
            if (currentUser.hasRole(UserTypeEnum.ADMIN_USER)){
                listObject.setPath(UserTypeEnum.ADMIN_PATH);
                //return "redirect:/admin/index";
            }
            if (currentUser.hasRole(UserTypeEnum.ORDINARY_USER)){
                listObject.setPath(UserTypeEnum.ORDINARY_PATH);
                //return "redirect:/admin/dataAjax";
            }
//            else{
//                listObject.setPath("lonin");
//            }
            //roleList.add(sysRole);
            //listObject.setItems(roleList);
            ResponseUtils.renderJson(response, JsonUtils.toJson(listObject));

            //return "redirect:/admin/index";
        }
//        else {
//            model.addAttribute("message", error);
//            currentUser.logout();
//            return "login";
//        }
    }
} 