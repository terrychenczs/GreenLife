package com.czs.controller;  
  
import com.czs.entity.Role;
import com.czs.entity.RoleResource;
import com.czs.entity.User;
import com.czs.entity.UserRole;
import com.czs.service.*;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.junit.Test;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
  
@Controller  
//@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/applicationContext.xml")  
@RequestMapping("/test")  
public class TestController {  
@Resource  
private UserService userService;  
@Resource
private ResourceService resourceService;
@Resource
private RoleResourceService roleResourceService;
@Resource
private RoleService roleService;
@Resource
private UserRoleService userRoleService;

@Test  
public void userCreate(){  
    User user=new User();  
    user.setAge(20);  
    user.setPassword("111");  
    user.setUsername("user1");  
    userService.save(user);  
}  
@Test  
public void resourceCreate(){  
    //建立三个资源  
    for(int i=1;i<4;i++){  
        com.czs.entity.Resource resource=new com.czs.entity.Resource();  
        resource.setName("resourceTest_"+i);  
        resource.setPermission("test:permission_"+i);  
        resourceService.save(resource);  
    }  
}  
@Test  
public void roleCreate(){  
    Role role=new Role();  
    role.setName("testRole");  
    roleService.save(role);  
    for(int i=143;i<146;i++){  
        RoleResource roleResource=new RoleResource();  
        roleResource.setRoleId(role.getId());  
        roleResource.setResourceId((long)i);  
        roleResourceService.save(roleResource);   
    }  
}
@Test  
public void UserCreate(){  
    User user=new User();  
    user.setAge(20);  
    user.setPassword("123");  
    user.setUsername("shiroUser1");  
    userService.save(user);  
    UserRole ur=new UserRole();  
    ur.setRoleId((long)25);  
    ur.setUserId(user.getId());  
    userRoleService.save(ur);  
}  
@RequiresPermissions("test:permission_1")  
@RequestMapping("/testAnnotation")  
public String testAnnotation(){  

    return "/index";
}  
  
@RequiresPermissions("test:nopermission")  
@RequestMapping("/testAnnotation1")  
public String testAnnotation1(){  

    return "index";
}  
}