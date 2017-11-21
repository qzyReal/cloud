package com.cloud.shiro;

import com.cloud.service.SystemUserService;
import com.cloud.model.SystemUser;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Administrator on 2017/3/16.
 */
public class UserRealm extends AuthorizingRealm {
    @Autowired
    private SystemUserService userService;
    /**
     * 为当前用户赋予角色与权限
     *
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
       /* String username = (String) principals.getPrimaryPrincipal();
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        // 根据用户名查询当前用户拥有的角色
        Set<SysRole> roles = sysuserservice.getRolesBySysUserName(username);
        Set<String> roleNames = new HashSet<String>();
        for (SysRole role : roles) {
            roleNames.add(role.getRoleName());
        }
        // 将角色名称提供给info
        authorizationInfo.setRoles(roleNames);
        // 根据角色查询当前用户权限
        Set<SysResource> sysresources = sysuserservice.getResourceBySysUserName(username);
        Set<String> sysresourceNames = new HashSet<String>();
        for (SysResource sysresource : sysresources) {
            if(sysresource != null && !StringUtils.isEmpty(sysresource.getResourcePermission())) {
                sysresourceNames.add(sysresource.getResourcePermission());
            }
        }
        // 将权限名称提供给info
        authorizationInfo.setStringPermissions(sysresourceNames);
        return authorizationInfo;*/
       return  null;
    }

    /**
     * 验证当前用户
     *
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String username = (String) authenticationToken.getPrincipal();
        SystemUser user = userService.getUserByUserName(username);
        if (user == null) {
            // 用户名不存在抛出异常
            throw new UnknownAccountException();
        }
        if (user.getStatus() == 1) {
            // 用户被管理员锁定抛出异常
            throw new LockedAccountException();
        }
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(user.getUserName(),
                user.getPassword(),
                ByteSource.Util.bytes(user.getCredentialsSalt()),
                getName());
        return authenticationInfo;
    }
}
