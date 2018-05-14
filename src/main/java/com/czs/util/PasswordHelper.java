package com.czs.util;

import org.apache.shiro.authc.SimpleAuthenticationInfo;  
import org.apache.shiro.crypto.RandomNumberGenerator;  
import org.apache.shiro.crypto.SecureRandomNumberGenerator;  
import org.apache.shiro.crypto.hash.SimpleHash;  
import org.apache.shiro.util.ByteSource;  
  
import com.czs.entity.User;  
  
public class PasswordHelper {  
    private RandomNumberGenerator randomNumberGenerator = new SecureRandomNumberGenerator();  
    private String algorithmName = "md5";  
    private final int hashIterations = 2;  
  
    public User encryptPassword(User user) {  
        if(user.getSalt()==null||("").equals(user.getSalt())){  
            user.setSalt(randomNumberGenerator.nextBytes().toHex());  
        }  
        String newPassword = new SimpleHash(algorithmName, user.getPassword(),  
                ByteSource.Util.bytes(user.getCredentialsSalt()), hashIterations).toHex();  
        user.setPassword(newPassword);  
        return user;  
    }  
}  
