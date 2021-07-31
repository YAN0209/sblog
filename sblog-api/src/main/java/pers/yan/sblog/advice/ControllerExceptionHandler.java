package pers.yan.sblog.advice;

import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import pers.yan.sblog.common.exception.SBlogException;
import pers.yan.sblog.common.vo.ApiResult;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 全局异常处理
 *
 * @author likaiyan
 * @date 2021/7/31 2:06 下午
 */
@ControllerAdvice
@Slf4j
public class ControllerExceptionHandler {

    @ExceptionHandler(SBlogException.class)
    public void SBlogExceptionHandler(SBlogException e, HttpServletRequest request, HttpServletResponse response) throws IOException {
        log.error("SBlogExceptionHandler: {}", e);
        response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json");
        response.getWriter().print(new Gson().toJson(ApiResult.fail(e.getMessage())));
        response.getWriter().flush();
    }

    @ExceptionHandler(Exception.class)
    public void ExceptionHandler(Exception e, HttpServletRequest request, HttpServletResponse response) throws IOException {
        log.error("ExceptionHandler: {}", e);
        response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json");
        response.getWriter().print(new Gson().toJson(ApiResult.fail("未知错误")));
        response.getWriter().flush();
    }

}
