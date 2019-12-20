package com.partern.service;
 
import com.partern.bean.SelfUserDetails;
import com.partern.bean.User;
import com.partern.mapper.UserMapper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
 
/**
 *
 * @description: 用户认证、权限
 */
@Service
public class SelfUserDetailsService implements UserDetailsService {
 
    @Autowired
    private UserMapper userMapper;
 
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        //通过username查询用户
        User u = userMapper.getUserByuId(username);
        if(u == null){
            //仍需要细化处理
            throw new UsernameNotFoundException("该用户不存在");
        }
        SelfUserDetails user = new SelfUserDetails();
        user.setUsername(u.getuId());
        user.setPassword(u.getuPassword());
        Set authoritiesSet = new HashSet();
        // 模拟从数据库中获取用户角色
        GrantedAuthority authority = new SimpleGrantedAuthority(u.getuType()+"");
        authoritiesSet.add(authority);
        user.setAuthorities(authoritiesSet);
 
        System.out.println("用户"+username+"验证通过");
        return user;
    }
}