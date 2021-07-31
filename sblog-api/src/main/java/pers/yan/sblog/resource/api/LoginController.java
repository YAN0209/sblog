package pers.yan.sblog.resource.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pers.yan.sblog.common.constant.Constant;
import pers.yan.sblog.common.dto.LoginDTO;
import pers.yan.sblog.common.exception.SBlogException;
import pers.yan.sblog.common.vo.ApiResult;
import pers.yan.sblog.service.LoginService;
import pers.yan.sblog.util.JwtUtil;

import javax.servlet.http.HttpServletResponse;

/**
 * 登录相关接口
 *
 * @author likaiyan
 * @date 2021/7/30 2:46 下午
 */
@RestController
@RequestMapping("/api")
public class LoginController {

    @Autowired
    private LoginService loginService;

    /**
     * 登录
     *
     * @param loginDTO 登录参数
     * @param response 返回
     * @return 通用返回
     * @throws SBlogException 用户不存在或密码错误
     */
    @PostMapping("/login")
    public ApiResult<Void> login(@RequestBody @Validated LoginDTO loginDTO, HttpServletResponse response) throws SBlogException {
        loginService.login(loginDTO);
        response.setHeader(Constant.RESPONSE_TOKEN_HEADER, JwtUtil.generateToken(loginDTO.getLoginName()));
        return ApiResult.ok();
    }

    /**
     * 刷新token
     *
     * @param token    token
     * @param response 返回
     * @return 通用返回
     */
    @GetMapping("/token/refresh")
    public ApiResult<Void> refreshToken(@RequestHeader("Authorization") String token, HttpServletResponse response) {
        response.setHeader(Constant.RESPONSE_TOKEN_HEADER, JwtUtil.refreshToken(token));
        return ApiResult.ok();
    }

}
