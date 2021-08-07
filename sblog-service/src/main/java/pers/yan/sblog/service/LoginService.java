package pers.yan.sblog.service;

import pers.yan.sblog.common.dto.LoginDTO;
import pers.yan.sblog.common.entity.User;
import pers.yan.sblog.common.exception.SBlogException;
import pers.yan.sblog.common.vo.UserVO;

/**
 * 登录服务
 *
 * @author likaiyan
 * @date 2021/7/30 3:18 下午
 */
public interface LoginService {

    /**
     * 登录
     *
     * @param loginDTO 参数
     * @return 用户
     * @throws SBlogException 用户不存在
     */
    User login(LoginDTO loginDTO) throws SBlogException;


    /**
     * 当前用户信息
     *
     * @return 用户信息
     */
    UserVO userInfo();

}