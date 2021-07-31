package pers.yan.sblog.common.vo;

import lombok.Data;

/**
 * 通用返回
 *
 * @author likaiyan
 * @date 2021/7/23 2:24 下午
 */
@Data
public class ApiResult<T> {

    private int code = 0;

    private String message = "";

    private T data;

    public static <T> ApiResult<T> ok(T data) {
        ApiResult<T> apiResult = ok();
        apiResult.setData(data);
        return apiResult;
    }

    public static <T> ApiResult<T> ok() {
        return new ApiResult<>();
    }

    public static <T> ApiResult<T> fail(String message) {
        ApiResult<T> apiResult = new ApiResult<>();
        apiResult.setMessage(message);
        apiResult.setCode(-1);
        return apiResult;
    }

}
