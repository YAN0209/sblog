package pers.yan.sblog.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pers.yan.sblog.common.bo.SblogUserDetails;
import pers.yan.sblog.common.constant.Constant;
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
    @Cacheable(cacheNames = Constant.REDIS_USER_DETAIL, key = "#id")
    public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
        SblogUserDetails sblogUserDetails = new SblogUserDetails();
        sblogUserDetails.setUser(Optional.ofNullable(userMapper.selectById(id))
                .orElseThrow(() -> new UsernameNotFoundException("无此用户")));
        sblogUserDetails.setUserVO(Optional.ofNullable(userMapper.findUserVoById(Integer.parseInt(id)))
                .orElseThrow(() -> new UsernameNotFoundException("无此用户")));
        return sblogUserDetails;
    }
}
