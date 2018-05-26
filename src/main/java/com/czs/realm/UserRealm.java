package com.czs.realm;

import com.czs.pojo.SysRole;
import org.apache.log4j.Logger;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import com.czs.entity.User;
import com.czs.pojo.UserParams;
import com.czs.service.ResourceService;
import com.czs.service.RoleService;
import com.czs.service.UserRoleService;
import com.czs.service.UserService;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;


/**
 * @author jiayq
 * @ClassName: UserRealm
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @date 2016年9月5日 上午10:09:51
 */
public class UserRealm extends AuthorizingRealm {
    private static final Logger logger = Logger.getLogger(UserRealm.class);

    @javax.annotation.Resource
    private UserRoleService userRoleService;
    @javax.annotation.Resource
    private ResourceService resourceService;
    @javax.annotation.Resource
    private UserService userService;
    @javax.annotation.Resource
    private RoleService roleService;


    /**
     * 用户登录成功后，进行角色和权限验证
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        //直接调用getPrimaryPrincipal得到之前传入的用户名  
        User user = (User) principals.getPrimaryPrincipal();
        logger.info("[用户:" + user.getUsername() + "|权限授权]");
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        //根据用户名调用UserService接口获取角色及权限信息
        List<SysRole> userRoles = roleService.loadRoleIdByUsername(user.getUsername());
        Set<String> reloStrings = new HashSet<String>();
        Iterator<SysRole> roles = userRoles.iterator();
        while (roles.hasNext()){
            SysRole sysRole = roles.next();
            reloStrings.add(sysRole.getName());
        }
        authorizationInfo.addRoles(reloStrings);
        authorizationInfo.setStringPermissions(resourceService.loadPermissionsByUsername(user.getUsername()));
        logger.info("[用户:" + user.getUsername() + "|权限授权完成]");
        return authorizationInfo;
    }

    /**
     * 用户登录验证
     * @param authenticationToken
     * @return
     */
    @Override
    public AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) {
        // 获取基于用户名和密码的令牌  
        // 实际上这个authcToken是从LoginController里面currentUser.login(token)传过来的  
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String username = (String) token.getPrincipal();
        System.out.println("pwd:" + token.getCredentials().toString());
        logger.info("[用户:" + username + "|系统权限认证]");
        User u = new User();
        u.setUsername(username);
        if (userService.find(new UserParams(u)).size() > 0) {
            User sqluser = userService.find(new UserParams(u)).get(0);
            // 交给AuthenticatingRealm使用CredentialsMatcher进行密码匹配，如果觉得人家的不好可以自定义实现  
            System.out.println("Realm:" + ByteSource.Util.bytes(sqluser.getCredentialsSalt()));
            SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(sqluser, sqluser.getPassword(),
                    ByteSource.Util.bytes(sqluser.getCredentialsSalt()), this.getName());// realm
            logger.info("[用户:" + username + "|系统权限认证完成]");
            return authenticationInfo;
        }
        return null;
    }
}  
