package pers.yan.sblog.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pers.yan.sblog.common.dto.LoginDTO;
import pers.yan.sblog.common.entity.User;
import pers.yan.sblog.common.exception.SBlogException;
import pers.yan.sblog.common.vo.UserVO;
import pers.yan.sblog.dao.mapper.UserMapper;
import pers.yan.sblog.service.LoginService;
import pers.yan.sblog.util.UserUtil;

import java.util.Optional;

/**
 * 登录
 *
 * @author likaiyan
 * @date 2021/7/30 3:35 下午
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PasswordEncoder bCryptPasswordEncoder;

    @Override
    public boolean login(LoginDTO loginDTO) throws SBlogException {
        User user = Optional.ofNullable(userMapper.findUserByLoginName(loginDTO.getLoginName()))
                .orElseThrow(() -> new SBlogException("用户不存在或密码错误"));
        if (!bCryptPasswordEncoder.matches(loginDTO.getPassword(), user.getPassword())) {
            throw new SBlogException("用户不存在或密码错误");
        }
        return true;
    }

    @Override
    public UserVO userInfo() {
        return UserUtil.getCurrentUserVO();
    }
}
