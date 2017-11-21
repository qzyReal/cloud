package com.cloud.shiro;

import com.cloud.model.SystemUser;
import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.stereotype.Service;

/**
 * Created by cRyann on 2017/3/16.
 */
@Service
public class PasswordHelper {
    private RandomNumberGenerator randomNumberGenerator = new SecureRandomNumberGenerator();
    private String algorithmName = "md5";
    private final int hashIterations = 2;

    public void encryptPassword(SystemUser user) {
        // User对象包含最基本的字段Username和Password
        user.setUserSalt(randomNumberGenerator.nextBytes().toHex());
        // 将用户的注册密码经过散列算法替换成一个不可逆的新密码保存进数据，散列过程使用了盐
        String newPassword = new SimpleHash(algorithmName,
                user.getPassword(),
                ByteSource.Util.bytes(user.getPassword()),
                hashIterations).toHex();
        user.setPassword(newPassword);
    }
}
