package pers.yan.sblog.service;

import pers.yan.sblog.common.dto.LoginDTO;
import pers.yan.sblog.common.exception.SBlogException;

/**
 * 登录服务
 *
 * @author likaiyan
 * @date 2021/7/30 3:18 下午
 */
public interface LoginService {

    /**
     * 登录
     */
    boolean login(LoginDTO loginDTO) throws SBlogException;

}