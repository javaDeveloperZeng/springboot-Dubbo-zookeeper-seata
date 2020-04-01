package com.bussines.service;

import com.bussines.dao.UserMapper;
import com.bussines.po.User;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.cas.authentication.CasAssertionAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.AuthenticationUserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
@Service
@Log4j2
public class CustomUserDetailsService implements UserDetailsService,AuthenticationUserDetailsService<CasAssertionAuthenticationToken> {


    @Resource
    private UserMapper iUser;

    /* (non-Javadoc)
     * @see org.springframework.security.core.userdetails.UserDetailsService#loadUserByUsername(java.lang.String)
     */
    @Override
    public UserDetails loadUserByUsername(String arg0) throws UsernameNotFoundException {
        // TODO Auto-generated method stub
        User userModel = iUser.findByUsername(arg0);
        log.info("验证机制里面的用户",userModel);
        if(null == userModel) {
            throw new UsernameNotFoundException("用户不存在");
        }
        List<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
        if("0".equals(userModel.getType())) {
            authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        }else {
            //其它所有用户都认为是普通用户
            authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        }
        return new org.springframework.security.core.userdetails.User(userModel.getUserName(), userModel.getPassWord(), authorities);
    }

    @Override
    public UserDetails loadUserDetails(CasAssertionAuthenticationToken casAssertionAuthenticationToken) throws UsernameNotFoundException {
        String login = casAssertionAuthenticationToken.getPrincipal().toString();
        User userModel = iUser.findByUsername(login);
        log.info("验证机制里面的用户",userModel);
        if(null == userModel) {
            throw new UsernameNotFoundException("用户不存在");
        }
        List<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
        if("0".equals(userModel.getType())) {
            authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        }else {
            //其它所有用户都认为是普通用户
            authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        }
        return new org.springframework.security.core.userdetails.User(userModel.getUserName(), userModel.getPassWord(), authorities);
    }
}
