package com.czs.controller;

import com.czs.entity.User;
import com.czs.pojo.SysUser;
import com.czs.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

    @RequestMapping("/createUser")
    public String createUser(HttpServletRequest request, Model model) {
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
        if (userService.save(user)) {
            model.addAttribute("message", "注册成功");
            return "login";
        } else {
            model.addAttribute("message", "注册失败");
            return "login";
        }
    }

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
}
