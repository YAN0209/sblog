package pers.yan.sblog.security.handler;

import com.google.gson.Gson;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import pers.yan.sblog.common.vo.ApiResult;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 无权限处理器
 *
 * @author likaiyan
 * @date 2021/7/30 2:30 下午
 */
public class SblogAccessDeniedHandler implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json");
        response.getWriter().print(new Gson().toJson(ApiResult.fail("无权限")));
        response.getWriter().flush();
    }
}
