package com.czs.controller;

import com.czs.entity.User;
import com.czs.pojo.SysUser;
import com.czs.pojo.UserParams;
import com.czs.service.UserService;
import com.czs.util.jsonUtil.JsonUtils;
import com.czs.util.jsonUtil.Entity.ListObject;
import com.czs.util.jsonUtil.ResponseUtils;
import com.czs.util.jsonUtil.Entity.StatusCode;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

    //创建一个新用户
    @RequestMapping("/createUser")
    public void createUser(HttpServletRequest request,HttpServletResponse response) {
        User user = new User();
        user.setUsername(request.getParameter("username"));
        user.setWorkNo(request.getParameter("workNo"));
        user.setPassword(request.getParameter("password"));
        String age = request.getParameter("age");
        if (age != null && age.length() > 0) {
            user.setAge(Integer.parseInt(age));
        }
        user.setPhone(request.getParameter("phone"));
        user.setAddress(request.getParameter("address"));
        user.setEmail(request.getParameter("email"));
        ListObject listObject = new ListObject();
        if (userService.save(user)) {
//            model.addAttribute("message", "注册成功");
//            return "login";

            listObject.setCode(StatusCode.CODE_SUCCESS);
            listObject.setMsg("感谢您的注册，你现在可以去登录了！");
            ResponseUtils.renderJson(response,JsonUtils.toJson(listObject));
        } else {
//            model.addAttribute("message", "注册失败");
//            return "login";

            listObject.setCode(StatusCode.CODE_ERROR_PROGRAM);
            listObject.setMsg("注册失败，请重新注册");
            ResponseUtils.renderJson(response,JsonUtils.toJson(listObject));
        }
    }

    //用于检查用户输入的用户名，手机号，email是否重复注册
    @RequestMapping("/check")
    @ResponseBody
    public String checkUser(HttpServletRequest request, Model model) {

        SysUser user = new SysUser();
        String username = request.getParameter("username");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        user.setUsername(username);
        user.setPhone(phone);
        user.setEmail(email);
        if (userService.getUserByUser(user)) {
            return "true";
        }
        return "false";
    }

    //测试http返回json格式
    @RequestMapping("/userList")
    @ResponseBody
    public void userList(HttpServletRequest request, HttpServletResponse response){
        long id = Integer.parseInt(request.getParameter("id"));
        User user = new User();
        user.setOrgId(id);
        UserParams userParams = new UserParams(user);
        List<User> userList = userService.find(userParams);
        List<User> users2 = new ArrayList<User>();
        for (User user1:userList){
            users2.add(user1);
            ListObject listObject = new ListObject();
            listObject.setItems(users2);
            listObject.setCode(StatusCode.CODE_SUCCESS);
            listObject.setMsg("访问成功");
            ResponseUtils.renderJson(response, JsonUtils.toJson(listObject));
        }
    }
}
