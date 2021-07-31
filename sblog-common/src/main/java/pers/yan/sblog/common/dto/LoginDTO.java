package pers.yan.sblog.common.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * 登录参数
 *
 * @author likaiyan
 * @date 2021/7/30 3:37 下午
 */
@Data
public class LoginDTO {

    /**
     * 登录名
     */
    @NotBlank
    private String loginName;

    /**
     * 密码
     */
    @NotBlank
    private String password;
}
