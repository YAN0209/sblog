package pers.yan.sblog.common.dto;

import lombok.Data;
import pers.yan.sblog.common.enums.UserStatus;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.List;

/**
 * 用户dto
 *
 * @author likaiyan
 * @date 2021/7/30 4:38 下午
 */
@Data
public class UserDTO {

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 用户名
     */
    @NotBlank
    private String username;

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

    /**
     * 用户状态
     */
    @NotEmpty
    private UserStatus userStatus;

    /**
     * 角色列表
     */
    private List<Integer> roles;

}
