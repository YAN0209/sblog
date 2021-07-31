package pers.yan.sblog.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pers.yan.sblog.common.bo.SblogUserDetails;
import pers.yan.sblog.dao.mapper.UserMapper;

import java.util.Optional;

/**
 * @author likaiyan
 * @date 2021/7/25 11:17 下午
 */
@Service
public class SblogUserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SblogUserDetails sblogUserDetails = new SblogUserDetails();
        sblogUserDetails.setUser(Optional.ofNullable(userMapper.findUserByLoginName(username))
                .orElseThrow(() -> new UsernameNotFoundException("无此用户")));
        sblogUserDetails.setUserVO(Optional.ofNullable(userMapper.findUserVoByLoginName(username))
                .orElseThrow(() -> new UsernameNotFoundException("无此用户")));
        return sblogUserDetails;
    }
}
